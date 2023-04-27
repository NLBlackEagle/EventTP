package com.nlblackeagle.eventtp.events;


import com.nlblackeagle.eventtp.commands.CustomTeleport;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.nlblackeagle.eventtp.config.ConfigHandler.*;

public class PlayerInteractEvent {

    @SubscribeEvent
    public void playerInteractEvent(net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock event) {

        EntityPlayer player = event.getEntityPlayer();
        BlockPos posBlock = event.getPos();
        IBlockState blockState = player.world.getBlockState(posBlock);
        Block BlockMaterial = blockState.getBlock();
        String blockStateString = blockState.toString();
        BlockPos LowerDoor = event.getPos().down();
        IBlockState getblockStateLower = player.world.getBlockState(LowerDoor);
        String blockStateLower = getblockStateLower.toString();
        boolean pass = false;

        String DIM_D = DIMENSION_DOORS;
        String[] words = DIM_D.split(",");


        if (event.getEntityLiving() instanceof EntityPlayer) {

            int index = -1;


            for (String x : words) {

                String DOORS = ("Block{"+x+"}");

                index++;
                if (BlockMaterial.toString().equals(DOORS)) {


                    int dimID = player.getEntityWorld().provider.getDimension();
                    List<Integer> DIM_B = Arrays.stream(DIMENSION_BLACKLIST_DOORS.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
                    List<Integer> DIM_C = Arrays.stream(DIMENSION_COORDINATES.split(",")).map(z -> Integer.parseInt(z.trim())).collect(Collectors.toList());
                    List<Integer> DIM_DC = Arrays.stream(DIMENSION_DOORS_CHANCE.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

                    int coordX = DIM_C.get(0);
                    int coordY = DIM_C.get(1);
                    int coordZ = DIM_C.get(2);

                    //System.out.println(coordX + "," + coordY + "," + coordZ);
                    //System.out.println("Dimensions Blacklisted:" + DIM_B);

                    boolean found = true;
                    for (int y : DIM_B){
                        if(dimID == (y)){
                            found = false;
                            break;
                        }
                    }

                    if(blockStateString.contains("half=lower") && blockStateString.contains("open=false"))
                    {
                        pass = true;
                    }
                    if(blockStateString.contains("half=upper"))
                    {
                        if(blockStateLower.contains("half=lower") && blockStateLower.contains("open=false"))
                        {
                            pass = true;
                        }
                    }


                    if ((found) && (pass)) {

                        int percentageNum = DIM_DC.get(index);

                        Random randomNum = new Random();
                        int rNum = randomNum.nextInt(100);

                        if (rNum <= percentageNum) {

                            CustomTeleport.teleportToDimension(player, DIMENSION_TELEPORT, coordX, coordY, coordZ);
                        }
                    }
                }
            }
        }
    }
}
