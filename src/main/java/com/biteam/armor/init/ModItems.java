package com.biteam.armor.init;


import com.biteam.armor.item.*;
import com.biteam.armor.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;

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
    }
}
