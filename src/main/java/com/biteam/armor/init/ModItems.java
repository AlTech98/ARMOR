package com.biteam.armor.init;


import com.biteam.armor.item.ItemARMOR;
import com.biteam.armor.item.ItemAtomicPickaxe;
import com.biteam.armor.item.ItemEpicSword;
import com.biteam.armor.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemSword epicSword = new ItemEpicSword();
    public static final ItemPickaxe atomicPickaxe = new ItemAtomicPickaxe();

    public static void init()
    {
        GameRegistry.registerItem(epicSword, "epicSword");
        GameRegistry.registerItem(atomicPickaxe, "atomicPickaxe");
    }
}
