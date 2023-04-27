package com.nlblackeagle.eventtp.proxy;

import com.google.common.util.concurrent.ListenableFuture;
import net.minecraft.entity.player.EntityPlayer;

public class CommonProxy
{

    public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule)
    {
        throw new IllegalStateException("This should only be called from client side");
    }

    public EntityPlayer getClientPlayer()
    {
        throw new IllegalStateException("This should only be called from client side");
    }
}
