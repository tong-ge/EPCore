package cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part;

import appeng.api.config.Actionable;
import appeng.api.networking.IGridHost;
import appeng.api.networking.security.IActionSource;
import appeng.api.networking.storage.IBaseMonitor;
import appeng.api.networking.storage.IStorageGrid;
import appeng.api.storage.*;
import appeng.api.storage.data.IAEFluidStack;
import appeng.api.storage.data.IItemList;
import appeng.fluids.util.AEFluidStack;
import appeng.me.GridAccessException;
import appeng.me.storage.MEInventoryHandler;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.EPMultiblockAbility;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.impl.FilteredItemHandler;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.NotifiableFluidTank;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.*;
import gregtech.api.items.itemhandlers.GTItemStackHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.multi.multiblockpart.appeng.MetaTileEntityAEHostablePart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.*;
import java.util.function.Consumer;

public class EPMetaTileEntityFluidStorageHatch extends MetaTileEntityAEHostablePart
        implements IMultiblockAbilityPart<IFluidTank>, ICellProvider, IMEInventory<IAEFluidStack>{
    private final HatchFluidTank fluidTank;
    private final MEInventoryHandler<IAEFluidStack> meInventoryHandler;
    private boolean workingEnabled;
    private boolean online;
    public EPMetaTileEntityFluidStorageHatch(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier, false);
        this.fluidTank = new HatchFluidTank(20_0000_0000, this);
        this.meInventoryHandler = new MEInventoryHandler<>(this, FLUID_NET);
        this.workingEnabled = true;
        this.initializeInventory();
    }

    private void postDifference(Iterable<IAEFluidStack> a) {
        try{
            IStorageGrid gridCache = this.getProxy().getGrid().getCache(IStorageGrid.class);
            gridCache.postAlterationOfStoredItems(FLUID_NET,a,getActionSource());
        }catch (GridAccessException e)
        {

        }
    }

    private void disconnectNetwork()
    {
        if(online) {
            try {
                IStorageGrid gridCache = this.getProxy().getGrid().getCache(IStorageGrid.class);
                gridCache.unregisterCellProvider(this);
            } catch (GridAccessException e) {
                throw new RuntimeException(e);
            }
            online=false;
        }
    }

    @Override
    public void onNeighborChanged() {
        super.onNeighborChanged();
        if(!(this.getNeighbor(this.frontFacing) instanceof IGridHost))
        {
            disconnectNetwork();
        }
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (this.shouldRenderOverlay()){
            Textures.ME_INPUT_HATCH.renderSided(getFrontFacing(), renderState, translation, pipeline);
        }
    }

    @Override
    public void update() {
        super.update();
        if (!getWorld().isRemote && this.workingEnabled && this.shouldSyncME()) {
            if(updateMEStatus()) {
                try {
                    IStorageGrid gridCache = this.getProxy().getGrid().getCache(IStorageGrid.class);
                    if (!online) {
                        gridCache.registerCellProvider(this);
                        online = true;
                    }
                } catch (GridAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                disconnectNetwork();
            }
        }
    }

    @Override
    public void onRemoval() {
        disconnectNetwork();
        super.onRemoval();
    }

    @Override
    public boolean isWorkingEnabled() {
        return workingEnabled;
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        this.workingEnabled = workingEnabled;
        World world = this.getWorld();
        if (world != null && !world.isRemote) {
            this.writeCustomData(GregtechDataCodes.WORKING_ENABLED, (buf) -> {
                buf.writeBoolean(workingEnabled);
            });
        }
    }

    protected void initializeInventory() {
        super.initializeInventory();
        this.exportFluids = this.importFluids;
        this.fluidInventory = this.importFluids;

    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityFluidStorageHatch(this.metaTileEntityId, this.getTier());
    }


    public ModularUI.Builder createTankUI(IFluidTank fluidTank, String title, EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.defaultBuilder();
        TankWidget tankWidget;
        tankWidget = (new TankWidget(fluidTank, 69, 52, 18, 18)).setAlwaysShowFull(true).setDrawHoveringText(false);
        builder.image(7, 16, 81, 55, GuiTextures.DISPLAY).widget(new ImageWidget(91, 36, 14, 15, GuiTextures.TANK_ICON)).widget((new SlotWidget(this.exportItems, 0, 90, 53, true, false)).setBackgroundTexture(GuiTextures.SLOT, GuiTextures.OUT_SLOT_OVERLAY));

        return builder.label(6, 6, title).label(11, 20, "gregtech.gui.fluid_amount", 16777215)
                .widget(new AdvancedTextWidget(11, 30, this.getFluidAmountText(tankWidget), 16777215))
                .widget(new AdvancedTextWidget(11, 40, this.getFluidNameText(tankWidget), 16777215))
                .widget(tankWidget)

                .widget((new FluidContainerSlotWidget(this.importItems, 0, 90, 16, false))
                        .setBackgroundTexture(GuiTextures.SLOT, GuiTextures.IN_SLOT_OVERLAY))


                .bindPlayerInventory(entityPlayer.inventory);
    }

    private Consumer<List<ITextComponent>> getFluidNameText(TankWidget tankWidget) {
        return (list) -> {
            TextComponentTranslation translation = tankWidget.getFluidTextComponent();
            if (translation != null) {
                list.add(translation);
            }

        };
    }

    private Consumer<List<ITextComponent>> getFluidAmountText(TankWidget tankWidget) {
        return (list) -> {
            String fluidAmount = "";
            if (!tankWidget.getFormattedFluidAmount().equals("0")) {
                fluidAmount = tankWidget.getFormattedFluidAmount();
            }

            if (!fluidAmount.isEmpty()) {
                list.add(new TextComponentString(fluidAmount));
            }

        };
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return this.createTankUI(this.fluidTank, this.getMetaFullName(), entityPlayer).build(this.getHolder(), entityPlayer);
    }

    @Override
    public MultiblockAbility<IFluidTank> getAbility() {
        return EPMultiblockAbility.STORAGE_FLUIDS;
    }

    @Override
    public void registerAbilities(List<IFluidTank> list) {
        list.add(this.fluidTank);
    }

    @Override
    public List<IMEInventoryHandler> getCellArray(IStorageChannel<?> iStorageChannel) {
        if (iStorageChannel == FLUID_NET) {
            return Collections.singletonList(this.meInventoryHandler);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public IAEFluidStack injectItems(IAEFluidStack input, Actionable type, IActionSource src) {
        FluidStack fluidStack = input.getFluidStack();

        // Insert
        int wasFillled = this.fluidTank.fill(fluidStack, type != Actionable.SIMULATE);
        int remaining = fluidStack.amount - wasFillled;
        if (fluidStack.amount == remaining) {
            // The stack was unmodified, target tank is full
            return input;
        }

        if (type == Actionable.MODULATE) {
            IAEFluidStack added = input.copy().setStackSize(input.getStackSize() - remaining);
            //this.cache.currentlyCached.add(added);
            this.postDifference(Collections.singletonList(added));
            try {
                this.getProxy().getTick().alertDevice(this.getProxy().getNode());
            } catch (GridAccessException ex) {
                // meh
            }
        }

        fluidStack.amount = remaining;

        return AEFluidStack.fromFluidStack(fluidStack);
    }

    @Override
    public IAEFluidStack extractItems(IAEFluidStack request, Actionable mode, IActionSource src) {
        FluidStack requestedFluidStack = request.getFluidStack();
        final boolean doDrain = (mode == Actionable.MODULATE);

        // Drain the fluid from the tank
        FluidStack gathered = this.fluidTank.drain(requestedFluidStack, doDrain);
        if (gathered == null) {
            // If nothing was pulled from the tank, return null
            return null;
        }

        IAEFluidStack gatheredAEFluidstack = AEFluidStack.fromFluidStack(gathered);
        if (mode == Actionable.MODULATE) {
            this.postDifference(Collections.singletonList(gatheredAEFluidstack.copy().setStackSize(-gatheredAEFluidstack.getStackSize())));
            try {
                this.getProxy().getTick().alertDevice(this.getProxy().getNode());
            } catch (GridAccessException ex) {
                // meh
            }
        }
        return gatheredAEFluidstack;
    }

    @Override
    public IItemList<IAEFluidStack> getAvailableItems(IItemList<IAEFluidStack> iItemList) {
        new Exception("Getting available items").printStackTrace();
        iItemList.add(AEFluidStack.fromFluidStack(this.fluidTank.getFluid()));
        return iItemList;
    }

    @Override
    public IStorageChannel<IAEFluidStack> getChannel() {
        return FLUID_NET;
    }

    protected FluidTankList createImportFluidHandler() {
        return new FluidTankList(false, this.fluidTank);
    }


    protected IItemHandlerModifiable createImportItemHandler() {
        return (new FilteredItemHandler(this, 1)).setFillPredicate(FilteredItemHandler.getCapabilityFilter(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY));
    }

    protected IItemHandlerModifiable createExportItemHandler() {
        return new GTItemStackHandler(this, 1);
    }

    @Override
    public void gridChanged() {
        super.gridChanged();

    }


    private static class HatchFluidTank extends NotifiableFluidTank {
        public HatchFluidTank(int capacity, MetaTileEntityAEHostablePart entityToNotify) {
            super(capacity, entityToNotify, false);
        }

        public boolean canFillFluidType(FluidStack fluid) {
            return true;
        }
    }
}
