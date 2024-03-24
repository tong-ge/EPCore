package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import cn.gtcommunity.epimorphism.common.items.EPMetaItems;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.recipes.ingredients.IntCircuitIngredient.getIntegratedCircuit;
import gregtech.api.unification.material.Materials;
import static gregtech.api.unification.ore.OrePrefix.*;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EPBiologyRecipes {

    public static void init() {

        //Common Algae Usage
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.ORDINARY_ALGAE, 10)
                .fluidInputs(Materials.DistilledWater.getFluid(500))
                .notConsumable(getIntegratedCircuit(12))
                .EUt(64)
                .duration(100)
                .fluidOutputs(Materials.Methane.getFluid(500))
                .buildAndRegister();
        //Green Algae Usage
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.GREEN_ALGA, 5)
                .inputs(new ItemStack(Blocks.DIRT))
                .notConsumable(getIntegratedCircuit(3))
                .EUt(30)
                .duration(20)
                .output(EPMetaItems.ROUGH_BIOLOGY_RESIN)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.GREEN_ALGA, 16)
                .input(EPMetaItems.COMPOST, 8)
                .fluidInputs(EPMaterials.UreaMix.getFluid(200))
                .notConsumable(getIntegratedCircuit(12))
                .EUt(60)
                .duration(600)
                .output(MetaItems.FERTILIZER, 32)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.GREEN_ALGA, 10)
                .input(EPMetaItems.BROWN_ALGA, 6)
                .fluidInputs(Materials.DistilledWater.getFluid(5000))
                .notConsumable(getIntegratedCircuit(7))
                .EUt(60)
                .duration(1000)
                .fluidOutputs(Materials.SulfuricAcid.getFluid(5000))
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.GREEN_ALGA, 4)
                .output(EPMetaItems.COMPOST)
                .EUt(2).duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .notConsumable(getIntegratedCircuit(4))
                .input(EPMetaItems.GREEN_ALGA, 2)
                .output(EPMetaItems.CELLULOSE_FIBER)
                .EUt(16).duration(30)
                .buildAndRegister();

        //Brown Algae Usage
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(getIntegratedCircuit(8))
                .input(EPMetaItems.BROWN_ALGA, 40)
                .fluidInputs(Materials.DistilledWater.getFluid(2000))
                .output(dust, Materials.SodaAsh, 20)
                .EUt(30).duration(600)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(getIntegratedCircuit(8))
                .input(EPMetaItems.BROWN_ALGA, 2)
                .fluidInputs(Materials.DistilledWater.getFluid(100))
                .output(dust, Materials.SodaAsh, 1)
                .EUt(30).duration(30)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(3)
                .input(EPMetaItems.CELLULOSE_FIBER_YELLOW, 2)
                .input(EPMetaItems.BROWN_ALGA, 10)
                .fluidInputs(Materials.DistilledWater.getFluid(5000))
                .notConsumable(getIntegratedCircuit(7))
                .EUt(180)
                .duration(120)
                .fluidOutputs(Materials.SulfuricAcid.getFluid(5000))
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.BROWN_ALGA, 10)
                .output(EPMetaItems.ALGAE_ACID, 2)
                .EUt(30).duration(45)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.BROWN_ALGA, 2)
                .output(EPMetaItems.COMPOST)
                .EUt(2).duration(400)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .notConsumable(getIntegratedCircuit(8))
                .input(EPMetaItems.BROWN_ALGA, 4)
                .output(dust, Materials.LithiumChloride, 1)
                .blastFurnaceTemp(1200)
                .EUt(120).duration(24)
                .buildAndRegister();

        //Gold Algae

        MACERATOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.CHRYSOPHYCEAE)
                .output(EPMetaItems.COMPOST)
                .EUt(2).duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .notConsumable(getIntegratedCircuit(12))
                .input(EPMetaItems.CHRYSOPHYCEAE, 2)
                .output(EPMetaItems.CELLULOSE_FIBER_YELLOW)
                .EUt(120).duration(30)
                .buildAndRegister();

        //Red Algae

        MACERATOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.RED_ALGA)
                .output(EPMetaItems.COMPOST, 2)
                .EUt(2).duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .notConsumable(getIntegratedCircuit(16))
                .input(EPMetaItems.RED_ALGA, 2)
                .output(EPMetaItems.CELLULOSE_FIBER_RED)
                .EUt(240).duration(30)
                .buildAndRegister();

        //Algae Acid
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(EPMetaItems.ALGAE_ACID, 2)
                .input(EPMetaItems.CELLULOSE_FIBER, 8)
                .output(EPMetaItems.CELLULOSE_PULP, 10)
                .EUt(16).duration(200)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(EPMetaItems.ALGAE_ACID, 1)
                .input(EPMetaItems.CELLULOSE_FIBER, 4)
                .output(EPMetaItems.CELLULOSE_PULP, 5)
                .EUt(16).duration(100)
                .buildAndRegister();

        //Cellulose Fiber
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.CELLULOSE_FIBER, 8)
                .input(EPMetaItems.CELLULOSE_FIBER_YELLOW, 6)
                .input(EPMetaItems.CELLULOSE_FIBER_RED, 4)
                .fluidInputs(Materials.Methane.getFluid(2000))
                .notConsumable(getIntegratedCircuit(13))
                .EUt(60)
                .duration(200)
                .fluidOutputs(Materials.Ethylene.getFluid(2000))
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.CELLULOSE_FIBER, 3)
                .output(EPMetaItems.COMPOST)
                .EUt(2).duration(400)
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.CELLULOSE_FIBER, 3)
                .fluidOutputs(Materials.Methanol.getFluid(250))
                .EUt(30).duration(37)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .notConsumable(getIntegratedCircuit(2))
                .input(EPMetaItems.CELLULOSE_FIBER, 4)
                .output(EPMetaItems.WOOD_PELLETS, 8)
                .EUt(7).duration(16)
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .notConsumable(EPMetaItems.PELLETS_MOULD)
                .input(EPMetaItems.CELLULOSE_FIBER, 4)
                .output(EPMetaItems.WOOD_PELLETS)
                .EUt(16).duration(66)
                .buildAndRegister();

        //Cellulose Fiber yellow
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.CELLULOSE_FIBER_YELLOW, 6)
                .input(EPMetaItems.CELLULOSE_FIBER_RED, 16)
                .fluidInputs(EPMaterials.FermentationBase.getFluid(48000))
                .notConsumable(getIntegratedCircuit(5))
                .EUt(32)
                .duration(2000)
                .fluidOutputs(EPMaterials.Butanol.getFluid(18000))
                .fluidOutputs(Materials.Acetone.getFluid(9000))
                .fluidOutputs(Materials.Ethanol.getFluid(3000))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.CELLULOSE_FIBER, 8)
                .input(EPMetaItems.CELLULOSE_FIBER_YELLOW, 6)
                .input(EPMetaItems.CELLULOSE_FIBER_RED, 4)
                .fluidInputs(Materials.Methane.getFluid(2000))
                .notConsumable(getIntegratedCircuit(13))
                .EUt(60)
                .duration(200)
                .fluidOutputs(Materials.Ethylene.getFluid(3000))
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.CELLULOSE_FIBER_YELLOW)
                .fluidOutputs(Materials.Ammonia.getFluid(500))
                .EUt(120).duration(300)
                .buildAndRegister();

        //Cellulose Fiber Red
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.CELLULOSE_FIBER_RED, 3)
                .output(dust, EPMaterials.CalciumCarbonate, 5)
                .EUt(240).duration(90)
                .buildAndRegister();

        //Wood Pellets
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(EPMetaItems.WOOD_PELLETS)
                .fluidOutputs(Materials.CarbonDioxide.getFluid(70))
                .EUt(120).duration(300)
                .buildAndRegister();

        COKE_OVEN_RECIPES.recipeBuilder()
                .input(EPMetaItems.WOOD_PELLETS, 2)
                .output(Items.COAL, 3, 1)
                .duration(1200)
                .buildAndRegister();

        //Cellulose Pulp
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.CELLULOSE_PULP, 8)
                .fluidInputs(EPMaterials.Resin.getFluid(144))
                .notConsumable(getIntegratedCircuit(3))
                .EUt(30)
                .duration(1200)
                .output(MetaItems.STICKY_RESIN, 32)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(2)
                .input(EPMetaItems.CELLULOSE_PULP, 4)
                .fluidInputs(Materials.AceticAcid.getFluid(500))
                .fluidInputs(EPMaterials.PropionicAcid.getFluid(500))
                .notConsumable(getIntegratedCircuit(16))
                .EUt(240)
                .duration(200)
                .fluidOutputs(Materials.Polyethylene.getFluid(1000))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .notConsumable(getIntegratedCircuit(2))
                .input(EPMetaItems.CELLULOSE_PULP, 2)
                .output(Items.PAPER, 2)
                .EUt(16).duration(20)
                .buildAndRegister();

        //Rough Biology Resin
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(EPMetaItems.ROUGH_BIOLOGY_RESIN)
                .fluidInputs(Materials.Ethanol.getFluid(200))
                .notConsumable(getIntegratedCircuit(3))
                .EUt(30)
                .duration(100)
                .fluidOutputs(EPMaterials.Resin.getFluid(500))
                .buildAndRegister();

        //Aluminium Pellets
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(gem, Materials.Coke, 1)
                .input(dust, Materials.SodaAsh, 6)
                .input(EPMetaItems.ALUMINIUM_PELLETS)
                .output(dust, EPMaterials.SodiumAluminate, 8)
                .notConsumable(getIntegratedCircuit(18))
                .EUt(120)
                .duration(2400)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(gem, Materials.Coal, 2)
                .input(dust, Materials.SodaAsh, 6)
                .input(EPMetaItems.ALUMINIUM_PELLETS)
                .output(dust, EPMaterials.SodiumAluminate, 8)
                .notConsumable(getIntegratedCircuit(18))
                .EUt(120)
                .duration(3600)
                .buildAndRegister();

        //Mould Pellets
        LATHE_RECIPES.recipeBuilder()
                .input(block, Materials.Gold)
                .output(EPMetaItems.PELLETS_MOULD)
                .EUt(90).duration(9000)
                .buildAndRegister();

        //Purified Aluminium Mixture

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.Sapphire, 5)
                .fluidInputs(Materials.Steam.getFluid(10000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(30)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 3)
                .fluidOutputs(EPMaterials.RedMud.getFluid(300))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.GreenSapphire, 5)
                .fluidInputs(Materials.Steam.getFluid(10000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(30)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 3)
                .fluidOutputs(EPMaterials.RedMud.getFluid(300))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.Ruby, 6)
                .fluidInputs(Materials.Steam.getFluid(12000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(60)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 3)
                .fluidOutputs(EPMaterials.RedMud.getFluid(300))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.Pyrope, 20)
                .fluidInputs(Materials.Steam.getFluid(40000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(90)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 3)
                .fluidOutputs(EPMaterials.RedMud.getFluid(300))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.Spodumene, 10)
                .fluidInputs(Materials.Steam.getFluid(20000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(90)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 2)
                .fluidOutputs(EPMaterials.RedMud.getFluid(200))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.Grossular, 20)
                .fluidInputs(Materials.Steam.getFluid(40000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(90)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 3)
                .fluidOutputs(EPMaterials.RedMud.getFluid(300))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.Sodalite, 11)
                .fluidInputs(Materials.Steam.getFluid(22000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(90)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 5)
                .fluidOutputs(EPMaterials.RedMud.getFluid(500))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.Bauxite, 39)
                .fluidInputs(Materials.Steam.getFluid(78000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(90)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 23)
                .fluidOutputs(EPMaterials.RedMud.getFluid(2300))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .input(crushedPurified, Materials.Lazurite, 14)
                .fluidInputs(Materials.Steam.getFluid(28000))
                .notConsumable(getIntegratedCircuit(14))
                .EUt(120)
                .duration(1200)
                .output(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 5)
                .fluidOutputs(EPMaterials.RedMud.getFluid(500))
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .notConsumable(EPMetaItems.PELLETS_MOULD)
                .input(EPMetaItems.PURIFIED_ALUMINIUM_MIXTURE, 4)
                .output(EPMetaItems.ALUMINIUM_PELLETS)
                .EUt(64).duration(600)
                .buildAndRegister();
        //Fish~
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(2)
                .inputs(new ItemStack(Items.FISH))
                .EUt(300)
                .duration(233)
                .outputs(new ItemStack(Items.COOKED_FISH))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .fluidInputs(Materials.CarbonDioxide.getFluid(300))
                .fluidInputs(Materials.Ammonia.getFluid(600))
                .notConsumable(getIntegratedCircuit(9))
                .EUt(30)
                .duration(100)
                .fluidOutputs(EPMaterials.UreaMix.getFluid(300))
                .fluidOutputs(Materials.DistilledWater.getFluid(300))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(1)
                .fluidInputs(EPMaterials.UreaMix.getFluid(200))
                .fluidInputs(EPMaterials.Formaldehyde.getFluid(200))
                .notConsumable(getIntegratedCircuit(9))
                .EUt(30)
                .duration(100)
                .fluidOutputs(EPMaterials.Resin.getFluid(200))
                .buildAndRegister();


    }
}