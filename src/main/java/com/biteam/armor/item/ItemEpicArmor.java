package com.biteam.armor.item;

import com.biteam.armor.creativetab.CreativeTabARMOR;
import com.biteam.armor.init.ModItems;
import com.biteam.armor.reference.Material;
import com.biteam.armor.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;


public class ItemEpicArmor extends ItemArmor
{
    public ItemEpicArmor(String name, int id, int placement)
    {
        super(Material.Armor.EPIC_MATTER, id, placement);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabARMOR.ARMOR_TAB);

        if (placement == 0) this.setTextureName(Reference.MOD_ID + ":epicHelmet");
        if (placement == 1) this.setTextureName(Reference.MOD_ID + ":epicChestplate");
        if (placement == 2) this.setTextureName(Reference.MOD_ID + ":epicLeggins");
        if (placement == 3) this.setTextureName(Reference.MOD_ID + ":epicBoots");
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == ModItems.epicHelmet || stack.getItem() == ModItems.epicChestplate || stack.getItem() == ModItems.epicBoots)
        {
            return Reference.MOD_ID + ":models/armor/epicArmor_1.png";
        }
        if(stack.getItem() == ModItems.epicLegs)
        {
            return Reference.MOD_ID + ":models/armor/epicArmor_2.png";
        }
        else return null;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }



    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
