package com.biteam.armor.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Material
{
    public static final class Tools
    {
        public static final Item.ToolMaterial EPIC_MATTER = EnumHelper.addToolMaterial("EPIC_MATTER", 3, 0, 30f, 96f, 0);
    }

    public static final class Armor
    {
        public static final ItemArmor.ArmorMaterial EPIC_MATTER = EnumHelper.addArmorMaterial("EPIC_MATTER", 0, new int[]{3, 8, 6, 3}, 0);
    }
}