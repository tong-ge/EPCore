package cn.gtcommunity.epimorphism.mixin.gregtech;

import appeng.api.storage.*;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

@Mixin(MetaTileEntityHolder.class)
public abstract class MixinMTEHolder implements ICellContainer {
    @Shadow(remap = false)
    MetaTileEntity metaTileEntity;
    @Override
    public void blinkCell(int i) {

    }

    @Override
    public List<IMEInventoryHandler> getCellArray(IStorageChannel<?> iStorageChannel) {
        //EPLog.logger.info("Getting cell array");
        if(metaTileEntity instanceof ICellProvider)
        {
            return ((ICellProvider)metaTileEntity).getCellArray(iStorageChannel);
        }
        return Collections.emptyList();
    }

    @Override
    public int getPriority() {
        if(metaTileEntity instanceof ICellProvider)
        {
            return ((ICellProvider)metaTileEntity).getPriority();
        }
        return 0;
    }

    @Override
    public void saveChanges(@Nullable ICellInventory<?> iCellInventory) {
        if(metaTileEntity instanceof ISaveProvider)
        {
            ((ISaveProvider)metaTileEntity).saveChanges(iCellInventory);
        }
    }
}
