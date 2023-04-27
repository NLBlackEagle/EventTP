package com.nlblackeagle.eventtp;

//Todo: add check for damage in the backrooms.
// Lost Cities is a good example.

import com.nlblackeagle.eventtp.util.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import java.io.File;

@Mod(modid = EventTP.MODID, name = EventTP.NAME, version = EventTP.VERSION)

public class EventTP
{
    public static File config;
    public static final String MODID = "eventtp";
    public static final String NAME = "EventTp";
    public static final String VERSION = "1.0";

    @EventHandler
    public static void init(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistries(event);
    }

    @EventHandler
    public static void serverinit(FMLServerStartingEvent event)
    {
        RegistryHandler.serverRegistries(event);
    }
}
