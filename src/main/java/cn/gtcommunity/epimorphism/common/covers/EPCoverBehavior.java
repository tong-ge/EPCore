package cn.gtcommunity.epimorphism.common.covers;

import cn.gtcommunity.epimorphism.Epimorphism;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.items.behavior.CoverItemBehavior;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.common.covers.CoverConveyor;
import gregtech.common.covers.CoverPump;
import gregtech.common.covers.CoverRoboticArm;
import net.minecraft.util.ResourceLocation;

public class EPCoverBehavior {
    public static void init() {
        //  Id Range: 113-200
        registerBehavior(113, new ResourceLocation(Epimorphism.MODID, "pump.ulv"), ELECTRIC_PUMP_ULV, (def, tile, side) -> new CoverPump(def, tile, side, GTValues.ULV, 320));
        registerBehavior(114, new ResourceLocation(Epimorphism.MODID, "conveyor_module.ulv"), CONVEYOR_MODULE_ULV, (def, tile, side) -> new CoverConveyor(def, tile, side, GTValues.ULV, 4));
        registerBehavior(115, new ResourceLocation(Epimorphism.MODID, "robot_arm.ulv"), ROBOT_ARM_ULV, (def, tile, side) -> new CoverRoboticArm(def, tile, side, GTValues.ULV, 4));
        registerBehavior(116, new ResourceLocation(Epimorphism.MODID, "pump.max"), ELECTRIC_PUMP_MAX, (def, tile, side) -> new CoverPump(def, tile, side, GTValues.MAX, 1048576));
        registerBehavior(117,  new ResourceLocation(Epimorphism.MODID, "conveyor_module.max"), CONVEYOR_MODULE_MAX, (def, tile, side) -> new CoverConveyor(def, tile, side, GTValues.MAX, 1024));
        registerBehavior(118, new ResourceLocation(Epimorphism.MODID, "robot_arm.max"), ROBOT_ARM_MAX, (def, tile, side) -> new CoverRoboticArm(def, tile, side, GTValues.MAX, 1024));
    }

    public static void registerBehavior(int coverNetworkId, ResourceLocation coverId, MetaItem.MetaValueItem placerItem, CoverDefinition.CoverCreator behaviorCreator) {
        placerItem.addComponents(new CoverItemBehavior(registerCover(coverNetworkId, coverId, placerItem, behaviorCreator)));
    }

    public static CoverDefinition registerCover(int coverNetworkId, ResourceLocation coverId, MetaItem.MetaValueItem itemStack, CoverDefinition.CoverCreator behaviorCreator) {
        CoverDefinition coverDefinition = new CoverDefinition(coverId, behaviorCreator, itemStack.getStackForm());
        GregTechAPI.COVER_REGISTRY.register(coverNetworkId, coverId, coverDefinition);
        return coverDefinition;
    }
}