package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class ComponentAssemblyLineRecipes {
    public static void init() {
        Motor();
        Piston();
        ConveyorModule();
    }

    private static void Motor() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 64)
                .input(stick, IronMagnetic, 64)
                .input(wireGtQuadruple, Lead, 64)
                .output(ELECTRIC_MOTOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tin, 8)
                .input(stickLong, Iron, 64)
                .input(stickLong, IronMagnetic, 32)
                .input(wireGtHex, Copper, 16)
                .output(ELECTRIC_MOTOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tin, 8)
                .input(stickLong, Steel, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Copper, 16)
                .output(ELECTRIC_MOTOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Copper, 8)
                .input(stickLong, Aluminium, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Cupronickel, 32)
                .output(ELECTRIC_MOTOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Silver, 16)
                .input(stickLong, StainlessSteel, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Electrum, 32)
                .output(ELECTRIC_MOTOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Aluminium, 16)
                .input(stickLong, Titanium, 64)
                .input(stickLong, NeodymiumMagnetic, 32)
                .input(wireGtHex, Kanthal, 32)
                .output(ELECTRIC_MOTOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tungsten, 16)
                .input(stickLong, TungstenSteel, 64)
                .input(stickLong, NeodymiumMagnetic, 32)
                .input(wireGtHex, Graphene, 32)
                .output(ELECTRIC_MOTOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(cableGtHex, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(L * 64))
                .fluidInputs(Ruridit.getFluid(L * 8))
                .output(ELECTRIC_MOTOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(cableGtHex, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Lubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(L * 64 * 2))
                .fluidInputs(Europium.getFluid(L * 12))
                .output(ELECTRIC_MOTOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(cableGtHex, YttriumBariumCuprate, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Lubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(L * 64 * 2))
                .fluidInputs(Americium.getFluid(L * 16))
                .output(ELECTRIC_MOTOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 2 * 64))
                .fluidInputs(SiliconCarbide.getFluid(L * 16))
                .output(ELECTRIC_MOTOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(cableGtHex, CarbonNanotube, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(L * 2 * 64))
                .fluidInputs(Abyssalloy.getFluid(L * 16))
                .output(ELECTRIC_MOTOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void Piston() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, WroughtIron, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(plateDouble, WroughtIron, 32)
                .input(gearSmall, WroughtIron, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .output(ELECTRIC_PISTON_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Steel, 64)
                .input(cableGtHex, Tin, 8)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 32)
                .input(gearSmall, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .output(ELECTRIC_PISTON_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Aluminium, 64)
                .input(cableGtHex, Copper, 8)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 32)
                .input(gearSmall, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .output(ELECTRIC_PISTON_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, StainlessSteel, 64)
                .input(cableGtHex, Gold, 8)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 32)
                .input(gearSmall, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .output(ELECTRIC_PISTON_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Titanium, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 32)
                .input(gearSmall, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .output(ELECTRIC_PISTON_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, TungstenSteel, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 32)
                .input(gearSmall, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .output(ELECTRIC_PISTON_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(cableGtHex, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(L * 4 * 64 + L * 4 * 64 + L * 2 * 64)) //  Gear (576 * 64) + Round (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_LUV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(cableGtHex, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Lubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(L * 4 * 64 + L * 4 * 64 + L * 2 * 64))  //  Gear (576 * 64) + Round (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(cableGtHex, YttriumBariumCuprate, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Lubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(L * 4 * 64))
                .fluidInputs(NaquadahAlloy.getFluid(L * 4 * 64 + L * 2 * 64)) //  Gear (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64))
                .fluidInputs(Draconium.getFluid(L * 4 * 64 + L * 2 * 64)) //  Gear (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(cableGtHex, CarbonNanotube, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(L * 4 * 64))
                .fluidInputs(Neutronium.getFluid(L * 4 * 64 + L * 2 * 64)) //  Gear (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void ConveyorModule() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .circuitMeta(1)
                .output(CONVEYOR_MODULE_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(1)
                .buildAndRegister();

        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(pipeTinyFluid, Bronze, 64)
                    .input(ELECTRIC_MOTOR_ULV, 64)
                    .input(ELECTRIC_MOTOR_ULV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_ULV, 64)
                    .EUt(VA[ULV])
                    .duration(300)
                    .CasingTier(1)
                    .buildAndRegister();
        }

        //  LV (15s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Tin, 4)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_LV, 64)
                    .EUt(VA[LV])
                    .duration(300)
                    .CasingTier(LV)
                    .buildAndRegister();
        }

        //  MV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Copper, 4)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_MV, 64)
                    .EUt(VA[MV])
                    .duration(600)
                    .CasingTier(MV)
                    .buildAndRegister();
        }

        //  HV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Gold, 4)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_HV, 64)
                    .EUt(VA[HV])
                    .duration(600)
                    .CasingTier(HV)
                    .buildAndRegister();
        }

        //  EV (45s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Aluminium, 4)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV, 64)
                    .EUt(VA[EV])
                    .duration(900)
                    .CasingTier(EV)
                    .buildAndRegister();
        }

        //  IV (45s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Tungsten, 4)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_IV, 64)
                    .EUt(VA[IV])
                    .duration(900)
                    .CasingTier(IV)
                    .buildAndRegister();
        }

        //  LuV (60s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 8 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 8 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(plateDouble, HSSS, 64)
                    .input(stickLong, HSSS, 64)
                    .input(stickLong, HSSS, 64)
                    .input(cableGtHex, NiobiumTitanium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64))
                    .fluidInputs(Lubricant.getFluid(16000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(HSSS.getFluid(L * 4 * 64 + L * 32)) //  Round + (1 Ingot -> 8 Bolt -> 8 Screw)
                    .output(CONVEYOR_MODULE_LuV, 64)
                    .EUt(VA[LuV])
                    .duration(1200)
                    .CasingTier(LuV)
                    .buildAndRegister();
        }

        //  ZPM (60s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 16 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 16 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(plateDouble, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 64)
                    .input(cableGtHex, VanadiumGallium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                    .fluidInputs(Lubricant.getFluid(32000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Osmiridium.getFluid(L * 4 * 64 + L * 32)) //  Round + (1 Ingot -> 8 Bolt -> 8 Screw)
                    .output(CONVEYOR_MODULE_ZPM, 64)
                    .EUt(VA[ZPM])
                    .duration(1200)
                    .CasingTier(ZPM)
                    .buildAndRegister();
        }
        //  UV (75s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 24 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 24 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(plateDouble, Tritanium, 64)
                    .input(stickLong, Tritanium, 64)
                    .input(stickLong, Tritanium, 64)
                    .input(cableGtHex, YttriumBariumCuprate, 8)
                    .fluidInputs(Lubricant.getFluid(L * 4 * 64))
                    .fluidInputs(Lubricant.getFluid(64000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                    .fluidInputs(Tritanium.getFluid(L * 4 * 64 + L * 32))
                    .output(CONVEYOR_MODULE_UV, 64)
                    .EUt(VA[UV])
                    .duration(1500)
                    .CasingTier(UV)
                    .buildAndRegister();
        }

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 32 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64 + L * 32))
                .output(CONVEYOR_MODULE_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(cableGtHex, CarbonNanotube, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 40 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 2 * 64))
                .fluidInputs(Hdcs.getFluid(L * 4 * 64 + L * 32))
                .output(CONVEYOR_MODULE_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }
}
