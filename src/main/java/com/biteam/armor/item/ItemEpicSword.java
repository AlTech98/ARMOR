package com.biteam.armor.item;


import cofh.api.energy.IEnergyContainerItem;
import cofh.api.item.IEmpowerableItem;
import cofh.lib.util.helpers.DamageHelper;
import cofh.lib.util.helpers.EnergyHelper;
import cofh.lib.util.helpers.MathHelper;
import cofh.lib.util.helpers.StringHelper;
import com.biteam.armor.creativetab.CreativeTabARMOR;
import com.biteam.armor.reference.Material;
import com.biteam.armor.reference.Reference;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemEpicSword extends ItemSword implements IEnergyContainerItem
{

    private int maxEnergy = 9000;
    private int maxTransfer = 1600;
    private int energyPerUse = 200;
    private int energyPerUseCharged = 800;
    private int damage = 99;



    public ItemEpicSword()
    {
        super(Material.Tools.EPIC_MATTER);
        this.setUnlocalizedName("EpicSword");
        this.setCreativeTab(CreativeTabARMOR.ARMOR_TAB);
        this.setNoRepair();
    }

    protected int useEnergy(ItemStack stack, boolean simulate) {

        int unbreakingLevel = MathHelper.clampI(EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack), 0, 4);
        return extractEnergy(stack, false ? energyPerUseCharged * (5 - unbreakingLevel) / 5 : energyPerUse * (5 - unbreakingLevel) / 5, simulate);
    }

    protected int getEnergyPerUse(ItemStack stack) {

        int unbreakingLevel = MathHelper.clampI(EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack), 0, 4);
        return (false ? energyPerUseCharged : energyPerUse) * (5 - unbreakingLevel) / 5;
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToRepair, ItemStack stack) {

        return false;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.uncommon;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {

        list.add(EnergyHelper.setDefaultEnergyTag(new ItemStack(item, 1, 0), 0));
        list.add(EnergyHelper.setDefaultEnergyTag(new ItemStack(item, 1, 0), maxEnergy));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase player) {

        if (stack.getItemDamage() > 0) {
            stack.setItemDamage(0);
        }
        EntityPlayer thePlayer = (EntityPlayer) player;
        float fallingMult = (player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder() && !player.isInWater()
                && !player.isPotionActive(Potion.blindness) && player.ridingEntity == null) ? 1.5F : 1.0F;

        if (thePlayer.capabilities.isCreativeMode || useEnergy(stack, false) == getEnergyPerUse(stack)) {
            float enchantDamage = damage + EnchantmentHelper.getEnchantmentModifierLiving(player, entity);

            entity.attackEntityFrom(DamageHelper.causePlayerFluxDamage(thePlayer), 1);
            entity.attackEntityFrom(DamageSource.causePlayerDamage(thePlayer), (1 + enchantDamage) * fallingMult);
        } else {
            entity.attackEntityFrom(DamageSource.causePlayerDamage(thePlayer), 1 * fallingMult);
        }
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {

        if (block.getBlockHardness(world, x, y, z) != 0.0D) {
            extractEnergy(stack, energyPerUse, false);
        }
        return true;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isCurrentItem) {


        if (entity instanceof EntityPlayer) {
            if (((EntityPlayer) entity).isBlocking()) {

                AxisAlignedBB axisalignedbb = entity.boundingBox.expand(2.0D, 1.0D, 2.0D);
                List<EntityMob> list = entity.worldObj.getEntitiesWithinAABB(EntityMob.class, axisalignedbb);

            }
        }
    }



    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) {

        if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
            list.add(StringHelper.shiftForDetails());
        }
        if (!StringHelper.isShiftKeyDown()) {
            return;
        }
        if (stack.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(stack, 0);
        }
        list.add(StringHelper.localize("info.cofh.charge") + ": " + stack.stackTagCompound.getInteger("Energy") + " / " + maxEnergy + " RF");

        list.add(StringHelper.ORANGE + getEnergyPerUse(stack) + " " + StringHelper.localize("info.redstonearsenal.tool.energyPerUse") + StringHelper.END);

        if (getEnergyStored(stack) >= getEnergyPerUse(stack)) {
            list.add("");
            list.add(StringHelper.LIGHT_BLUE + "+" + damage + " " + StringHelper.localize("info.cofh.damageAttack") + StringHelper.END);


        }
    }

    @Override
    public int getDisplayDamage(ItemStack stack) {

        if (stack.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(stack, 0);
        }
        return 1 + maxEnergy - stack.stackTagCompound.getInteger("Energy");
    }

    @Override
    public int getMaxDamage(ItemStack stack) {

        return 1 + maxEnergy;
    }

    @Override
    public boolean isDamaged(ItemStack stack) {

        return stack.getItemDamage() != Short.MAX_VALUE;
    }

    @Override
    public Multimap getItemAttributeModifiers() {

        return HashMultimap.create();
    }

    @Override
    public IIcon getIconIndex(ItemStack stack) {

        return getIcon(stack, 0);
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

        if (container.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(container, 0);
        }
        int stored = container.stackTagCompound.getInteger("Energy");
        int receive = Math.min(maxReceive, Math.min(maxEnergy - stored, maxTransfer));

        if (!simulate) {
            stored += receive;
            container.stackTagCompound.setInteger("Energy", stored);
        }
        return receive;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

        if (container.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(container, 0);
        }
        int stored = container.stackTagCompound.getInteger("Energy");
        int extract = Math.min(maxExtract, stored);

        if (!simulate) {
            stored -= extract;
            container.stackTagCompound.setInteger("Energy", stored);


        }
        return extract;
    }

    @Override
    public int getEnergyStored(ItemStack container) {

        if (container.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(container, 0);
        }
        return container.stackTagCompound.getInteger("Energy");
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {

        return maxEnergy;
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
