package com.biteam.armor.init;


import com.biteam.armor.block.BlockARMOR;
import com.biteam.armor.block.BlockFlag;
import com.biteam.armor.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockARMOR flag = new BlockFlag();

    public static void init()
    {
        GameRegistry.registerBlock(flag, "flag");
    }
}
