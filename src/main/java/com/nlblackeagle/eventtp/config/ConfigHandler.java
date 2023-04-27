package com.nlblackeagle.eventtp.config;

import com.nlblackeagle.eventtp.util.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.nlblackeagle.eventtp.EventTP;

import java.io.File;

public class ConfigHandler
{
    public static Configuration config;

    //Dimensions
    public static int DIMENSION_TELEPORT = 1000;
    public static String DIMENSION_BLACKLIST = "-1000,1000,1001,1002,1003,1004,1005,1006";
    public static String DIMENSION_COORDINATES = "0,62,0";
    public static String DIMENSION_BLACKLIST_DOORS = "-1000,1000,1001,1002,1003,1004,1005,1006";

    //Door teleportation chance
    public static String DIMENSION_DOORS_CHANCE = "0,0,0";

    //Damagetypes
    public static int DAMAGE_FALL = 0;
    public static int DAMAGE_INWALL = 0;
    public static int DAMAGE_FLYINTOWALL = 0;
    public static int DAMAGE_ANVIL = 0;
    public static int DAMAGE_FALLINGBLOCK = 0;
    public static int DAMAGE_OUTOFWORLD = 0;
    public static int DAMAGE_STARVE = 0;
    public static int DAMAGE_DROWN = 0;
    public static int DAMAGE_LAVA = 0;
    public static int DAMAGE_THORNS = 0;
    public static int DAMAGE_MOB = 0;
    public static int DAMAGE_PLAYER = 0;
    public static int DAMAGE_WITHER = 0;
    public static int DAMAGE_ONFIRE = 0;
    public static int DAMAGE_MAGIC = 0;
    public static int DAMAGE_LIGHTNINGBOLT = 0;
    public static int DAMAGE_INFIRE = 0;
    public static int DAMAGE_HOTFLOOR = 0;
    public static int DAMAGE_FIREWORKS = 0;
    public static int DAMAGE_DRAGONBREATH = 0;
    public static int DAMAGE_CRAMMING = 0;
    public static int DAMAGE_CACTUS = 0;

    //Miscellaneous
    public static String DIMENSION_DOORS = "backrooms:metal_door,backrooms:metal_black_door,backrooms:metal_maintenance_door";
//    public static boolean GENERATE_AIR_POCKET = false;
//    public static boolean GENERATE_OBSIDIAN = false;


    public static void init(File file)
    {
        config = new Configuration(file);
        String category;

//        category = "Miscellaneous";
//        config.addCustomCategoryComment(category, "Miscellaneous settings.");
//        GENERATE_AIR_POCKET = config.getBoolean(GENERATE_AIR_POCKET, category, false, "Generates a airpocket at the teleport coordinates.");
//        GENERATE_OBSIDIAN = config.getBoolean(GENERATE_OBSIDIAN, category, false, "Generates a obsidian at the teleport coordinates.");

        category = "DoorType Teleportation";
        config.addCustomCategoryComment(category, "Teleportation on door interactions.");
        DIMENSION_DOORS = config.getString("Doors ID's", category, "backrooms:metal_door,backrooms:metal_black_door,backrooms:metal_maintenance_door", "Doors capable of teleporting players to the configured dimension when interacted with.");
        DIMENSION_DOORS_CHANCE = config.getString("Door Teleport Chance", category, "0,0,0", "Syntax = 100,0,8 will have 100% chance to teleport on interact with backrooms:metal_door, 0% with backrooms:metal_black_door and 8% with backrooms:metal_maintenance_door.");

        category = "Damage Types";
        config.addCustomCategoryComment(category, "Percentage chance of teleportation per damage type. 0 = disabled");
        DAMAGE_INWALL = config.getInt("Suffocation", category, 100, 0,100, "Chance to teleport on suffocation in wall damage.");
        DAMAGE_FALL = config.getInt("Fall", category, 10, 0,100, "Chance to teleport on fall damage.");
        DAMAGE_FLYINTOWALL = config.getInt("Kinetic", category, 10, 0,100, "Chance to teleport on kinetic damage.");
        DAMAGE_ANVIL = config.getInt("Anvil", category, 10, 0,100, "Chance to teleport on anvil damage.");
        DAMAGE_FALLINGBLOCK = config.getInt("FallingBlock", category, 10, 0,100, "Chance to teleport on falling block damage.");
        DAMAGE_OUTOFWORLD = config.getInt("Void", category, 100, 0,100, "Chance to teleport on falling through void damage.");
        DAMAGE_STARVE = config.getInt("Starve", category, 0, 0,100, "Chance to teleport on starving damage.");
        DAMAGE_DROWN = config.getInt("Drown", category, 0, 0,100, "Chance to teleport on drowning damage.");
        DAMAGE_LAVA = config.getInt("Lava", category, 0, 0,100, "Chance to teleport on lava damage.");
        DAMAGE_THORNS = config.getInt("Thorns", category, 0, 0,100, "Chance to teleport on thorns damage.");
        DAMAGE_MOB = config.getInt("Mob", category, 0, 0,100, "Chance to teleport on damage done by mob.");
        DAMAGE_PLAYER = config.getInt("Player", category, 0, 0,100, "Chance to teleport on damage done by player.");
        DAMAGE_WITHER = config.getInt("Wither", category, 0, 0,100, "Chance to teleport on wither damage.");
        DAMAGE_ONFIRE = config.getInt("OnFire", category, 0, 0,100, "Chance to teleport on being on fire damage.");
        DAMAGE_MAGIC = config.getInt("Magic", category, 0, 0,100, "Chance to teleport on magic damage.");
        DAMAGE_LIGHTNINGBOLT = config.getInt("LightningBolt", category, 50, 0,100, "Chance to teleport on lightning damage.");
        DAMAGE_INFIRE = config.getInt("InFire", category, 0, 0,100, "Chance to teleport on in fire damage.");
        DAMAGE_HOTFLOOR = config.getInt("HotFloor", category, 0, 0,100, "Chance to teleport on hot floor damage.");
        DAMAGE_FIREWORKS = config.getInt("Fireworks", category, 0, 0,100, "Chance to teleport on fireworks damage.");
        DAMAGE_DRAGONBREATH = config.getInt("DragonBreath", category, 0, 0,100, "Chance to teleport on dragon breath damage.");
        DAMAGE_CRAMMING = config.getInt("Cramming", category, 50, 0,100, "Chance to teleport on cramming damage.");
        DAMAGE_CACTUS = config.getInt("Cactus", category, 0, 0,100, "Chance to teleport on cactus damage.");

        category = "Dimension ID's & Coordinates";
        config.addCustomCategoryComment(category, "Set the dimension ID to teleport to.");
        DIMENSION_TELEPORT = config.getInt("Dimension ID", category, 1000, 0, 5000, "Default Dimension ID, level 0 of the Backrooms Ultimate Edition");
        DIMENSION_BLACKLIST = config.getString("Blacklisted DamageType Dimension ID's", category, "-1000,1000,1001,1002,1003,1004,1005,1006", "You wont be teleported from these dimensions on damage.");
        DIMENSION_BLACKLIST_DOORS = config.getString("Blacklisted DoorType Dimension ID's", category, "-1000,1000,1001,1002,1003,1004,1005,1006", "You wont be teleported from these dimensions when you open doors configured in the Miscellaneous section.");
        DIMENSION_COORDINATES = config.getString("Teleport Coordinates", category, "0,62,0", "Coordinates of the spot you will teleport to. DOES NOT ACCEPT DECIMALS!");

        config.save();
    }

    public static void registerConfig(FMLPreInitializationEvent event)
    {
        EventTP.config = new File(event.getModConfigurationDirectory() + File.separator + Reference.MOD_ID);
        EventTP.config.mkdirs();
        init(new File(EventTP.config.getPath(), Reference.MOD_ID + ".cfg"));

    }
}
