package com.biteam.armor.init;


import com.biteam.armor.item.ItemAtomicAxe;
import com.biteam.armor.item.ItemAtomicPickaxe;
import com.biteam.armor.item.ItemAtomicSword;
import com.biteam.armor.item.ItemEpicSword;
import com.biteam.armor.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemSword epicSword = new ItemEpicSword();
    public static final ItemPickaxe atomicPickaxe = new ItemAtomicPickaxe();
    public static final ItemAxe atomicAxe = new ItemAtomicAxe();
    public static final ItemSword atomicSword = new ItemAtomicSword();


    public static void init()
    {
        GameRegistry.registerItem(epicSword, "epicSword");
        GameRegistry.registerItem(atomicPickaxe, "atomicPickaxe");
        GameRegistry.registerItem(atomicAxe, "atomicAxe");
        GameRegistry.registerItem(atomicSword,"atomicSword");
    }
}
