package com.biteam.armor.init;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.atomicPickaxe), " s ", "sss", " s ", 's', new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.flag), new ItemStack(Items.blaze_rod), new ItemStack(Items.baked_potato));

        /* Crafting Using Ore Dictionary
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.atomicPickaxe), " s ", "sss", " s ", 's', "ingotCopper"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.flag), new ItemStack(Items.blaze_rod), new ItemStack(Items.baked_potato)));
        */
    }
}
