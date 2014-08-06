package com.biteam.armor.init;


import com.biteam.armor.item.ItemARMOR;
import com.biteam.armor.item.ItemMapleLeaf;
import com.biteam.armor.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemARMOR mapleLeaf = new ItemMapleLeaf();

    public static void init()
    {
        GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
    }
}
