package com.nlblackeagle.eventtp.util;

import com.nlblackeagle.eventtp.events.BreakEvent;
import com.nlblackeagle.eventtp.events.ExplosionEvent;
import com.nlblackeagle.eventtp.events.LivingHurtEvent;
import com.nlblackeagle.eventtp.events.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;


public class EventHandler {

    public static void registerEvents()
    {
        LivingHurtEvent livingHurtEvent = new LivingHurtEvent();
        PlayerInteractEvent playerInteractEvent = new PlayerInteractEvent();
        BreakEvent livingDestroyBlockEvent = new BreakEvent();
        ExplosionEvent breakEvent = new ExplosionEvent();

        MinecraftForge.EVENT_BUS.register(breakEvent);
        MinecraftForge.EVENT_BUS.register(livingHurtEvent);
        MinecraftForge.EVENT_BUS.register(playerInteractEvent);
        MinecraftForge.EVENT_BUS.register(livingDestroyBlockEvent);
    }
}