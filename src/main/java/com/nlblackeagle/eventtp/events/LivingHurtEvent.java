package com.nlblackeagle.eventtp.events;


import com.nlblackeagle.eventtp.commands.CustomTeleport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.*;
import java.util.stream.Collectors;

import static com.nlblackeagle.eventtp.config.ConfigHandler.*;


public class LivingHurtEvent
{

    @SubscribeEvent
    public void livingHurtEvent(net.minecraftforge.event.entity.living.LivingHurtEvent event)
    {


        if(event.getEntityLiving() instanceof EntityPlayer) {

            net.minecraft.entity.player.EntityPlayer player = (EntityPlayer) event.getEntityLiving();


            int dimID = player.getEntityWorld().provider.getDimension();
            List<Integer> DIM_B = Arrays.stream(DIMENSION_BLACKLIST.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
            List<Integer> DIM_C = Arrays.stream(DIMENSION_COORDINATES.split(",")).map(x -> Integer.parseInt(x.trim())).collect(Collectors.toList());

            int coordX = DIM_C.get(0);
            int coordY = DIM_C.get(1);
            int coordZ = DIM_C.get(2);

            //System.out.println(coordX + "," + coordY + "," + coordZ);
            //System.out.println("Dimensions Blacklisted:" + DIM_B);

            boolean found = true;
            for (int x : DIM_B){
                if(dimID == (x)){
                    found = false;
                    break;
                }
            }


            if (found) {

                String mobString = event.getSource().getDamageType();

                List<String> ar = new ArrayList<>();
                List<Integer> arNum = new ArrayList<>();

                if (DAMAGE_FALL > 0) {
                    ar.add("fall");
                    arNum.add(DAMAGE_FALL);
                }
                if (DAMAGE_INWALL > 0) {
                    ar.add("inWall");
                    arNum.add(DAMAGE_INWALL);
                }
                if (DAMAGE_FLYINTOWALL > 0) {
                    ar.add("flyIntoWall");
                    arNum.add(DAMAGE_INWALL);
                }
                if (DAMAGE_ANVIL > 0) {
                    ar.add("anvil");
                    arNum.add(DAMAGE_ANVIL);
                }
                if (DAMAGE_FALLINGBLOCK > 0) {
                    ar.add("fallingBlock");
                    arNum.add(DAMAGE_FALLINGBLOCK);
                }
                if (DAMAGE_OUTOFWORLD > 0) {
                    ar.add("outOfWorld");
                    arNum.add(DAMAGE_OUTOFWORLD);
                }
                if (DAMAGE_STARVE > 0) {
                    ar.add("starve");
                    arNum.add(DAMAGE_STARVE);
                }
                if (DAMAGE_DROWN > 0) {
                    ar.add("drown");
                    arNum.add(DAMAGE_DROWN);
                }
                if (DAMAGE_LAVA > 0) {
                    ar.add("lava");
                    arNum.add(DAMAGE_LAVA);
                }
                if (DAMAGE_THORNS > 0) {
                    ar.add("thorns");
                    arNum.add(DAMAGE_THORNS);
                }
                if (DAMAGE_MOB > 0) {
                    ar.add("mob");
                    arNum.add(DAMAGE_MOB);
                }
                if (DAMAGE_PLAYER > 0) {
                    ar.add("player");
                    arNum.add(DAMAGE_PLAYER);
                }
                if (DAMAGE_WITHER > 0) {
                    ar.add("wither");
                    arNum.add(DAMAGE_WITHER);
                }
                if (DAMAGE_ONFIRE > 0) {
                    ar.add("onFire");
                    arNum.add(DAMAGE_ONFIRE);
                }
                if (DAMAGE_MAGIC > 0) {
                    ar.add("magic");
                    arNum.add(DAMAGE_MAGIC);
                }
                if (DAMAGE_LIGHTNINGBOLT > 0) {
                    ar.add("lightningBolt");
                    arNum.add(DAMAGE_LIGHTNINGBOLT);
                }
                if (DAMAGE_INFIRE > 0) {
                    ar.add("inFire");
                    arNum.add(DAMAGE_INFIRE);
                }
                if (DAMAGE_HOTFLOOR > 0) {
                    ar.add("hotFloor");
                    arNum.add(DAMAGE_HOTFLOOR);
                }
                if (DAMAGE_FIREWORKS > 0) {
                    ar.add("fireworks");
                    arNum.add(DAMAGE_FIREWORKS);
                }
                if (DAMAGE_DRAGONBREATH > 0) {
                    ar.add("dragonBreath");
                    arNum.add(DAMAGE_DRAGONBREATH);
                }
                if (DAMAGE_CRAMMING > 0) {
                    ar.add("cramming");
                    arNum.add(DAMAGE_CRAMMING);
                }
                if (DAMAGE_CACTUS > 0) {
                    ar.add("cactus");
                    arNum.add(DAMAGE_CACTUS);
                }

                //System.out.println("ArrayList: " + ar);


                //int[] perc = {100, 100, 100, 100, 100, 100}; //Teleport Chance Array

                int index = 0;

                for (String s : ar) {
                    index++;
                    if (mobString.equals(s)) {


                        //System.out.println("CurrentArray: " + index);
                        //System.out.println("ArrayName: " + s);
                        int percentageNum = arNum.get(index);
                        //System.out.println("Index: " + index + " DamageType: " + s + " Teleport Chance: " + percentageNum);

                        Random randomNum = new Random();
                        int rNum = randomNum.nextInt(100);

                        //System.out.println("rNum >= percentageNum: " + rNum + " <= " + percentageNum);

                        if (rNum <= percentageNum) {
                            CustomTeleport.teleportToDimension(player, DIMENSION_TELEPORT, coordX, coordY, coordZ);
                        }
                    }
                }
            }
        }
    }
}

