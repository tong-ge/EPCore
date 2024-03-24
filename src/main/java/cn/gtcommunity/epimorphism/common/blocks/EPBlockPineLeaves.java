package cn.gtcommunity.epimorphism.common.blocks;

import cn.gtcommunity.epimorphism.api.worldgen.WorldGenPineTree;
import cn.gtcommunity.epimorphism.common.items.EPMetaItems;
import com.google.common.collect.Lists;
import gregtech.api.GregTechAPI;
import gregtech.core.CoreModule;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class EPBlockPineLeaves extends BlockLeaves {

    public EPBlockPineLeaves() {
        setDefaultState(this.blockState.getBaseState()
                .withProperty(CHECK_DECAY, true)
                .withProperty(DECAYABLE, true));
        setTranslationKey("ep_pine_leaves");
        setCreativeTab(GregTechAPI.TAB_GREGTECH);
        Blocks.FIRE.setFireInfo(this, 30, 60);
    }

    @Override
    public EnumType getWoodType(int meta) {
        return null;
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE);
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public IBlockState getStateForPlacement(@Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull EnumFacing facing,
                                            float hitX, float hitY,
                                            float hitZ, int meta, @Nonnull EntityLivingBase placer) {
        return this.getDefaultState().withProperty(DECAYABLE, false).withProperty(CHECK_DECAY, false);
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
                .withProperty(DECAYABLE, (meta & 1) == 0)
                .withProperty(CHECK_DECAY, (meta & 2) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int meta = 0;
        if (!state.getValue(DECAYABLE)) {
            meta |= 1;
        }
        if (state.getValue(CHECK_DECAY)) {
            meta |= 2;
        }
        return meta;
    }

    @Nonnull
    @Override
    public Item getItemDropped(@Nonnull IBlockState state, @Nonnull Random rand, int fortune) {
        return Item.getItemFromBlock(EPMetablocks.EP_PINE_SAPLING);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        int chance = this.getSaplingDropChance(state);

        if (fortune > 0)
        {
            chance -= 2 << fortune;
            if (chance < 10) chance = 10;
        }

        if (rand.nextInt(chance) == 0)
        {
            ItemStack drop = new ItemStack(getItemDropped(state, rand, fortune), 1, damageDropped(state));
            if (!drop.isEmpty())
                drops.add(drop);
        }

        chance = 200;
        if (fortune > 0)
        {
            chance -= 10 << fortune;
            if (chance < 40) chance = 40;
        }

        this.captureDrops(true);
        if (world instanceof World)
            this.dropApple((World)world, pos, state, chance); // Dammet mojang
        drops.addAll(this.captureDrops(false));
    }

    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance)
    {
        if(WorldGenPineTree.randInt(0, 10) > 9)
            spawnAsEntity(worldIn, pos, EPMetaItems.PINE_CONE.getStackForm());
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return Lists.newArrayList(new ItemStack(this, 1, 0));
    }

    @Override
    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        if (!fancyLeaves()) {
            return super.getRenderLayer();
        }
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
        if (!fancyLeaves()) {
            return super.isOpaqueCube(state);
        }
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(@Nonnull IBlockState blockState, @Nonnull IBlockAccess blockAccess,
                                        @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
        if (!fancyLeaves()) {
            return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
        }
        return true;
    }

    private static boolean fancyLeaves() {
        return CoreModule.proxy.isFancyGraphics();
    }
}