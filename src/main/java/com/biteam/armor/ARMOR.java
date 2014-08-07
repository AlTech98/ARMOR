package com.biteam.armor;

import com.biteam.armor.handler.ConfigurationHandler;
import com.biteam.armor.init.ModBlocks;
import com.biteam.armor.init.ModItems;
import com.biteam.armor.init.Recipes;
import com.biteam.armor.proxy.IProxy;
import com.biteam.armor.reference.Reference;
import com.biteam.armor.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class ARMOR
{
    @Mod.Instance(Reference.MOD_ID)
    public static ARMOR instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("Pre Initialization Complete!");

        ModItems.init();
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Elenca nella console tutto quello che appartiene all'ore Dictionary alde cacca
        for(String oreName : OreDictionary.getOreNames())
        {
            LogHelper.info(oreName);
        }
        LogHelper.info("Post Initialization Complete!");
    }
}
