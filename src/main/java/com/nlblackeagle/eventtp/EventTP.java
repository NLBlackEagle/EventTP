package com.nlblackeagle.eventtp;

//Todo: add check for damage in the backrooms.
// Lost Cities is a good example.

import com.nlblackeagle.eventtp.util.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import java.io.File;

//Blocks from Backrooms Dimension:
/*

//Teleports player between -1000 <-> 1000
BACKROOMS:WHITE_WOODEN_DOOR_BLOCK_BOTTOM
BACKROOMS:WHITE_WOODEN_DOOR_BLOCK_TOP

//Teleports player between 1000 <-> 1001
BACKROOMS:METAL_MAINTENANCE_DOOR_BLOCK_BOTTOM
BACKROOMS:METAL_MAINTENANCE_DOOR_BLOCK_TOP

//Teleports player between 1001 <-> 1002
BACKROOMS:METAL_DOOR_BLOCK_BOTTOM
BACKROOMS:METAL_DOOR_BLOCK_TOP

//Teleports player between 1002 <-> 1003
BACKROOMS:METAL_BLACK_DOOR_BLOCK_BOTTOM
BACKROOMS:METAL_BLACK_DOOR_BLOCK_TOP

//Teleports player between 1005 -> 1006
BACKROOMS:RUSTY_METAL_DOOR_BLOCK_BOTTOM
BACKROOMS:RUSTY_METAL_DOOR_BLOCK_TOP

//Teleports player between 1002 -> 1004 && 1005 -> 1004
BACKROOMS:OFFICE_WOODEN_DOOR_BLOCK_BOTTOM
BACKROOMS:OFFICE_WOODEN_DOOR_BLOCK_TOP

//Teleports player between 1004 -> 1005
BACKROOMS:DARK_WOODEN_DOOR_BLOCK_BOTTOM
BACKROOMS:DARK_WOODEN_DOOR_BLOCK_TOP

//Teleports player to 0
BACKROOMS:WHITE_METAL_DOOR_BLOCK_BOTTOM
BACKROOMS:WHITE_METAL_DOOR_BLOCK_TOP

 */

@Mod(modid = EventTP.MODID, name = EventTP.NAME, version = EventTP.VERSION, dependencies = EventTP.DEPENDENCIES)

public class EventTP
{
    public static File config;
    public static final String MODID = "eventtp";
    public static final String NAME = "EventTp";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "";

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
