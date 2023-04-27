package com.nlblackeagle.eventtp.util;

import com.nlblackeagle.eventtp.commands.CommandTeleportDim;
import com.nlblackeagle.eventtp.config.ConfigHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@EventBusSubscriber
public class RegistryHandler {

    public static void preInitRegistries(FMLPreInitializationEvent event)
    {
        EventHandler.registerEvents();
        ConfigHandler.registerConfig(event);
    }

    public static void serverRegistries(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandTeleportDim());
    }
}
