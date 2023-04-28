package com.nlblackeagle.eventtp.events;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.nlblackeagle.eventtp.config.ConfigHandler.*;

public class ExplosionEvent {

    // Backrooms mining fix
    @SubscribeEvent
    public void breakEvent(net.minecraftforge.event.world.ExplosionEvent.Detonate event) {

        //System.out.println("Event Block Break Fired");

        List<Integer> DIM_DB = Arrays.stream(DIMENSION_BLACKLIST_BLOCKS.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        int dimID = event.getWorld().provider.getDimension();

        for (int y : DIM_DB){
            if(dimID == (y)){
                event.getAffectedBlocks().clear();
            }
        }
    }
}
