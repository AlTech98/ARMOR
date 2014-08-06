package com.biteam.armor.creativetab;


import com.biteam.armor.init.ModItems;
import com.biteam.armor.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabARMOR
{
    public static final CreativeTabs ARMOR_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.epicSword; // Creative Tab's Icon 2
        }
    };
}
