package cn.gtcommunity.epimorphism.api.unification.materials;

import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import gregtech.api.unification.material.Materials;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.info.MaterialFlags;
import static gregtech.api.util.GTUtility.gregtechId;

public class EPBiologicalMaterials {
    //  Range 25601-25800
    private static int startId = 25601;
    private static final int END_ID = startId + 200;

    public static void register() {
        //  25601 Dry Red Algae
        DryRedAlgae = new Material.Builder(getMaterialsId(), gregtechId("dry_red_algae"))
                .dust()
                .color(0x880808)
                .build();
        //  25602 Red Algae
        RedAlgae = new Material.Builder(getMaterialsId(), gregtechId("red_algae"))
                .dust()
                .color(0xAA4A44)
                .build();
        //  25603 Dry Green Algae
        DryGreenAlgae = new Material.Builder(getMaterialsId(), gregtechId("dry_green_algae"))
                .dust()
                .color(0x4F7942)
                .build();
        //  25604 Green Algae
        GreenAlgae = new Material.Builder(getMaterialsId(), gregtechId("green_algae"))
                .dust()
                .color(0x5F8575)
                .build();
        //  25605 Dry Golden Algae
        DryGoldenAlgae = new Material.Builder(getMaterialsId(), gregtechId("dry_golden_algae"))
                .dust()
                .color(0xDAA520)
                .build();
        //  25606 Golden Algae
        GoldenAlgae = new Material.Builder(getMaterialsId(), gregtechId("golden_algae"))
                .dust()
                .color(0xEEDC82)
                .build();
        //  25607 Dry Brown Algae
        DryBrownAlgae = new Material.Builder(getMaterialsId(), gregtechId("dry_brown_algae"))
                .dust()
                .color(0x5C4033)
                .build();
        //  25608 Brown Algae
        BrownAlgae = new Material.Builder(getMaterialsId(), gregtechId("brown_algae"))
                .dust()
                .color(0x988558)
                .build();
        //  25609 UraeMix
        EPMaterials.UreaMix = new Material.Builder(getMaterialsId(), gregtechId("urea_mix"))
                .liquid(new FluidBuilder().temperature(200))
                .color(0x443610)
                .build();
        //  25610 Fermentation Base
        EPMaterials.FermentationBase = new Material.Builder(getMaterialsId(), gregtechId("fermentation_base"))
                .liquid(new FluidBuilder().temperature(200))
                .color(0x5E5839)
                .build();
        // Resin
        EPMaterials.Resin = new Material.Builder(getMaterialsId(), gregtechId("resin"))
                .liquid(new FluidBuilder().temperature(200))
                .color(0x353533)
                .build();
        // CaCO3
        EPMaterials.CalciumCarbonate = new Material.Builder(getMaterialsId(), gregtechId("calcium_carbonate"))
                .dust()
                .components(Materials.Calcium, 1, Materials.Carbon, 1, Oxygen, 3)
                .color(0xE8E8CB)
                .build();
        // Propionic Acid
        EPMaterials.PropionicAcid = new Material.Builder(getMaterialsId(), gregtechId("propionic_acid"))
                .liquid(new FluidBuilder().temperature(200))
                .color(0xB3BC88)
                .build();
        //Sodium Aluminate
        EPMaterials.SodiumAluminate = new Material.Builder(getMaterialsId(), gregtechId("sodium_aluminate"))
                .dust()
                .colorAverage()
                .components(Sodium, 1, Aluminium, 1, Oxygen, 2)
                .build();
        // RedMud
        EPMaterials.RedMud = new Material.Builder(getMaterialsId(), gregtechId("red_mud"))
                .fluid()
                .colorAverage()
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(Rutile, 1, HydrochloricAcid, 2)
                .build();
        //  Pine oil
        EPMaterials.PineOil = new Material.Builder(getMaterialsId(), gregtechId("pine_oil"))
                .fluid()
                .colorAverage()
                .color(0xd6ac37)
                .build();
    }
    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
