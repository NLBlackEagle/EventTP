package com.nlblackeagle.eventtp.util;

import com.nlblackeagle.eventtp.events.LivingHurtEvent;
import com.nlblackeagle.eventtp.events.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;


public class EventHandler {

    public static void registerEvents()
    {
        LivingHurtEvent livingHurtEvent = new LivingHurtEvent();
        PlayerInteractEvent playerInteractEvent = new PlayerInteractEvent();

        MinecraftForge.EVENT_BUS.register(livingHurtEvent);
        MinecraftForge.EVENT_BUS.register(playerInteractEvent);
    }
}