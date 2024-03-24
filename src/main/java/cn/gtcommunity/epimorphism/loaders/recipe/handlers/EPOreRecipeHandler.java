package cn.gtcommunity.epimorphism.loaders.recipe.handlers;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import cn.gtcommunity.epimorphism.api.unification.ore.EPOrePrefix;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import cn.gtcommunity.epimorphism.common.items.EPMetaItems;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.gem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class EPOreRecipeHandler {
    private EPOreRecipeHandler() {/**/}

    public static void register() {
        EPOrePrefix.milled.addProcessingHandler(PropertyKey.ORE, EPOreRecipeHandler::processMilled);
    }

    public static void processPineOil(){
        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(4)
                .input(EPMetaItems.PINE_CONE)
                .circuitMeta(14)
                .EUt(60)
                .duration(200)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 7500, 500)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 5000, 500)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 5000, 500)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 2500, 500)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(3)
                .input(dust, Materials.Potash, 3)
                .input(dust, Materials.Quicklime, 5)
                .fluidInputs(Materials.Water.getFluid(5000))
                .fluidInputs(Materials.CarbonDioxide.getFluid(1000))
                .circuitMeta(18)
                .EUt(120)
                .duration(600)
                .output(dust, EPMaterials.CalciumCarbonate, 5)
                .outputs(EPMetaItems.POTASSIUM_ETHYLATE.getStackForm(6))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(3)
                .input(Blocks.SAPLING, 32)
                .fluidInputs(Materials.DistilledWater.getFluid(8000))
                .fluidInputs(Materials.Mutagen.getFluid(2000))
                .circuitMeta(6)
                .EUt(64)
                .duration(2400)
                .output(EPMetablocks.EP_PINE_SAPLING, 16)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(3)
                .input(dust, Materials.Sodium)
                .fluidInputs(Materials.Ethanol.getFluid(1000))
                .circuitMeta(16)
                .EUt(120)
                .duration(600)
                .fluidOutputs(Materials.Hydrogen.getFluid(1000))
                .outputs(EPMetaItems.SODIUM_ETHYLATE.getStackForm(9))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(5)
                .inputs(EPMetaItems.POTASSIUM_ETHYLATE.getStackForm(3))
                .fluidInputs(EPMaterials.CarbonDisulfide.getFluid(1000))
                .circuitMeta(17)
                .EUt(120)
                .duration(1200)
                .outputs(EPMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(12))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(5)
                .inputs(EPMetaItems.SODIUM_ETHYLATE.getStackForm(9))
                .fluidInputs(EPMaterials.CarbonDisulfide.getFluid(1000))
                .fluidInputs(Materials.Ethanol.getFluid(1000))
                .circuitMeta(17)
                .EUt(120)
                .duration(1200)
                .outputs(EPMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(12))
                .fluidOutputs(Materials.Water.getFluid(1000))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(4)
                .inputs(EPMetaItems.PINE_FRAGMENT.getStackForm(64))
                .fluidInputs(Materials.Steam.getFluid(5000))
                .circuitMeta(16)
                .EUt(120)
                .duration(1200)
                .chancedOutput(dust, Materials.Ash, 5, 3000, 15)
                .chancedOutput(dust, Materials.Ash, 5, 3000, 15)
                .chancedOutput(dust, Materials.DarkAsh, 5, 3000, 15)
                .chancedOutput(dust, Materials.DarkAsh, 5, 3000, 15)
                .fluidOutputs(EPMaterials.PineOil.getFluid(500))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(5)
                .inputs(EPMetaItems.PINE_FRAGMENT.getStackForm(64))
                .fluidInputs(Materials.Steam.getFluid(5000))
                .circuitMeta(18)
                .EUt(120)
                .duration(900)
                .chancedOutput(OrePrefix.dustTiny, Materials.Ash, 5, 3000, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.Ash, 5, 3000, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.DarkAsh, 5, 3000, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.DarkAsh, 5, 3000, 15)
                .fluidOutputs(EPMaterials.PineOil.getFluid(1500))
                .buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(gem, Materials.Coke, 8)
                .input(dust, Materials.Sulfur, 16)
                .output(dust, Materials.DarkAsh, 1)
                .fluidOutputs(EPMaterials.CarbonDisulfide.getFluid(4000))
                .blastFurnaceTemp(1500)
                .EUt(30).duration(12000)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(3)
                .input(dust, Materials.Sulfur, 4)
                .fluidInputs(Materials.CoalGas.getFluid(1000))
                .circuitMeta(20)
                .EUt(30)
                .duration(6000)
                .fluidOutputs(EPMaterials.CarbonDisulfide.getFluid(2000))
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(4)
                .input(Item.getItemFromBlock(EPMetablocks.EP_PINE_LEAVES))
                .circuitMeta(14)
                .EUt(30)
                .duration(200)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 2, 5000, 0)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 2, 5000, 0)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 2, 2500, 0)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 2, 2500, 0)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(4)
                .input(Item.getItemFromBlock(EPMetablocks.EP_PINE_SAPLING))
                .circuitMeta(14)
                .EUt(60)
                .duration(200)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 4, 7500, 0)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 4, 7500, 0)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 4, 2500, 0)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 4, 2500, 0)
                .buildAndRegister();

        EPRecipeMaps.CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .CasingTier(4)
                .input(Item.getItemFromBlock(EPMetablocks.EP_PINE_LOG))
                .circuitMeta(14)
                .EUt(120)
                .duration(200)
                .output(EPMetaItems.PINE_FRAGMENT, 16)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 16, 7500, 0)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 16, 5000, 0)
                .chancedOutput(EPMetaItems.PINE_FRAGMENT, 16, 2500, 0)
                .buildAndRegister();
    }

    public static void processMilled(OrePrefix milledPrefix, Material material, OreProperty property) {
        EPRecipeMaps.ISA_MILL_GRINDER.recipeBuilder().EUt(GTValues.VA[ZPM]).duration(1500)
                .input(OrePrefix.crushed, material, 16)
                .output(milledPrefix, material, 16)
                .circuitMeta(11)
                .grindBallTier(1)
                .buildAndRegister();
        EPRecipeMaps.ISA_MILL_GRINDER.recipeBuilder().EUt(GTValues.VA[ZPM]).duration(1200)
                .input(OrePrefix.crushed, material, 16)
                .output(milledPrefix, material, 32)
                .circuitMeta(10)
                .grindBallTier(2)
                .buildAndRegister();
    }
}
