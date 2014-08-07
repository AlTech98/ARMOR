package com.biteam.armor.init;


import com.biteam.armor.item.*;
import com.biteam.armor.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemSword epicSword = new ItemEpicSword();
    public static final ItemPickaxe atomicPickaxe = new ItemAtomicPickaxe();
    public static final ItemAxe atomicAxe = new ItemAtomicAxe();
    public static final ItemARMOR basicIngot = new ItemBasicIngot();
    public static final ItemARMOR atomicIngot = new ItemAtomicIngot();
    public static final ItemARMOR epicIngot = new ItemEpicIngot();
    public static final ItemARMOR basicCrystal = new ItemBasicCrystal();
    public static final ItemARMOR atomicCrystal = new ItemAtomicCrystal();
    public static final ItemARMOR epicCrystal = new ItemEpicCrystal();
    public static final ItemSword atomicSword = new ItemAtomicSword();
    public static final ItemArmor epicHelmet = new ItemEpicArmor("epicHelmet", 0, 0);
    public static final ItemArmor epicChestplate = new ItemEpicArmor("epicChestplate", 0, 1);
    public static final ItemArmor epicLegs = new ItemEpicArmor("epicLegs", 0, 2);
    public static final ItemArmor epicBoots = new ItemEpicArmor("epicBoots", 0, 3);


    public static void init()
    {
        GameRegistry.registerItem(epicSword, "epicSword");
        GameRegistry.registerItem(atomicPickaxe, "atomicPickaxe");
        GameRegistry.registerItem(atomicAxe, "atomicAxe");
        GameRegistry.registerItem(basicIngot, "basicIngot");
        GameRegistry.registerItem(atomicIngot, "atomicIngot");
        GameRegistry.registerItem(epicIngot, "epicIngot");
        GameRegistry.registerItem(basicCrystal, "basicCrystal");
        GameRegistry.registerItem(atomicCrystal, "atomicCrystal");
        GameRegistry.registerItem(epicCrystal, "epicCrystal");
        GameRegistry.registerItem(atomicSword, "atomicSword");
        GameRegistry.registerItem(epicHelmet, "epicHelmet");
        GameRegistry.registerItem(epicChestplate, "epicChestplate");
        GameRegistry.registerItem(epicLegs, "epicLegs");
        GameRegistry.registerItem(epicBoots, "epicBoots");
    }
}
