package com.nlblackeagle.eventtp.events;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.nlblackeagle.eventtp.config.ConfigHandler.*;

public class BreakEvent {

    // Backrooms mining fix
    @SubscribeEvent
    public void breakEvent(net.minecraftforge.event.world.BlockEvent.BreakEvent event) {

        System.out.println("Event Block Break Fired");

        List<Integer> DIM_DB = Arrays.stream(DIMENSION_BLACKLIST_BLOCKS.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        int dimID = event.getWorld().provider.getDimension();

        boolean pass = false;
        for (int y : DIM_DB){
            if(dimID == (y)){
                pass = true;
                //System.out.println("Dimension " + dimID + " == " + y);
                break;
            }
        }

        BlockPos posBlock = event.getPos();
        IBlockState blockState = event.getWorld().getBlockState(posBlock);
        Block BlockMaterial = blockState.getBlock();
        String DIM_BB = BLACKLIST_BLOCKS.toLowerCase();
        String[] words_bb = DIM_BB.split(",");
        //System.out.println("Something Broke" + BlockMaterial);

        if (pass) {
            for (String bb : words_bb) {
                String BLOCKS = ("Block{" + bb + "}");
                if (BlockMaterial.toString().equals(BLOCKS)) {
                    event.setCanceled(true);
                    //System.out.println("Break Event Cancelled");
                    break;
                }
            }
        }
    }
}
