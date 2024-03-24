package cn.gtcommunity.epimorphism.common.blocks;

import gregtech.api.GregTechAPI;
import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

import javax.annotation.Nonnull;

public class EPBlockPineLog extends BlockLog {

    public static final PropertyBool NATURAL = PropertyBool.create("natural");

    public EPBlockPineLog() {
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(LOG_AXIS, EnumAxis.Y)
                .withProperty(NATURAL, false));
        setTranslationKey("ep_pine_log");
        setCreativeTab(GregTechAPI.TAB_GREGTECH);
        setHarvestLevel(ToolClasses.AXE, 0);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LOG_AXIS, NATURAL);
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
                .withProperty(NATURAL, (meta & 1) == 1)
                .withProperty(LOG_AXIS, EnumAxis.values()[meta >> 1]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(NATURAL) ? 1 : 0) | (state.getValue(LOG_AXIS).ordinal() << 1);
    }
}