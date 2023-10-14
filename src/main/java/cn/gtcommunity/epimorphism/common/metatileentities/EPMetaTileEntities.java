package cn.gtcommunity.epimorphism.common.metatileentities;

import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.*;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityBufferHatch;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityMillBallHatch;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoCategory;
import net.minecraftforge.fml.common.Loader;

import static cn.gtcommunity.epimorphism.api.utils.EPUtils.epId;

public class EPMetaTileEntities {

    //SingleBlock



    //  Multiblocks
    public static EPMetaTileEntitySonicator SONICATOR;
    public static EPMetaTileEntityCVDUnit CVD_UNIT;
    public static EPMetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static EPMetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static EPMetaTileEntityCatalyticReformer CATALYTIC_REFORMER;
    public static EPMetaTileEntityFermentationTank FERMENTATION_TANK;
    public static EPMetaTileEntityBlazingBlastFurnace BLAZING_BLAST_FURNACE;
    public static EPMetaTileEntityCryogenicFreezer CRYOGENIC_FREEZER;

    public static EPMetaTileEntityBufferHatch MULTIPART_BUFFER_HATCH;
    public static EPMetaTileEntityMillBallHatch MULTIPART_BALL_HATCH;

    //  Range: 12300-13300
    private static <F extends MetaTileEntity> F registerSingleMetaTileEntity(int id, F mte) {
        if (id > 1000) return null;
        return MetaTileEntities.registerMetaTileEntity(id + 12300, mte);
    }

    //  Range: 13300-14300
    private static <T extends MultiblockControllerBase> T registerMultiMetaTileEntity(int id, T mte) {
        return MetaTileEntities.registerMetaTileEntity(id + 13300, mte);
    }

    public static void init() {

        //SingleBlock: Id 12300-13300
        MULTIPART_BUFFER_HATCH = registerSingleMetaTileEntity(1, new EPMetaTileEntityBufferHatch(epId("buffer_hatch")));
        MULTIPART_BALL_HATCH = registerSingleMetaTileEntity(2, new EPMetaTileEntityMillBallHatch(epId("mill_ball_hatch")));

        //Multiblocks: Id 13300-14300
        SONICATOR = registerMultiMetaTileEntity(1, new EPMetaTileEntitySonicator(epId("sonicator")));
        CVD_UNIT = registerMultiMetaTileEntity(2, new EPMetaTileEntityCVDUnit(epId("cvd_unit")));
        NANOSCALE_FABRICATOR = registerMultiMetaTileEntity(3, new EPMetaTileEntityNanoscaleFabricator(epId("nanoscale_fabricator")));
        CRYSTALLIZATION_CRUCIBLE = registerMultiMetaTileEntity(4, new EPMetaTileEntityCrystallizationCrucible(epId("crystallization_crucible")));
        CATALYTIC_REFORMER = registerMultiMetaTileEntity(5, new EPMetaTileEntityCatalyticReformer(epId("catalytic_reformer")));
        FERMENTATION_TANK= registerMultiMetaTileEntity(6, new EPMetaTileEntityFermentationTank(epId("fermentation_tank")));
        BLAZING_BLAST_FURNACE = registerMultiMetaTileEntity(7, new EPMetaTileEntityBlazingBlastFurnace(epId("blazing_blast_furnace")));
        CRYOGENIC_FREEZER = registerMultiMetaTileEntity(8, new EPMetaTileEntityCryogenicFreezer(epId("cryogenic_freezer")));
    }
    
}
