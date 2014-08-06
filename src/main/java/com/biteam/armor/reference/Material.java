package com.biteam.armor.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Material
{
    public static final class Tools
    {
        public static final Item.ToolMaterial EPIC_MATTER = EnumHelper.addToolMaterial("EPIC_MATTER", 3, 0, 30f, 96f, 0);
        public static final Item.ToolMaterial ATOMIC_MATTER = EnumHelper.addToolMaterial("ATOMIC_MATTER", 3, 0, 30f, 96f, 0);
        public static final Item.ToolMaterial BASIC_MATTER = EnumHelper.addToolMaterial("BASIC_MATTER", 3, 0, 30f, 96f, 0);
    }

    public static final class Armor
    {
        public static final ItemArmor.ArmorMaterial EPIC_MATTER = EnumHelper.addArmorMaterial("EPIC_MATTER", 0, new int[]{3, 8, 6, 3}, 0);
        public static final ItemArmor.ArmorMaterial ATOMIC_MATTER = EnumHelper.addArmorMaterial("ATOMIC_MATTER", 0, new int[]{3, 8, 6, 3}, 0);
        public static final ItemArmor.ArmorMaterial BASIC_MATTER = EnumHelper.addArmorMaterial("BASIC_MATTER", 0, new int[]{3, 8, 6, 3}, 0);
    }
}