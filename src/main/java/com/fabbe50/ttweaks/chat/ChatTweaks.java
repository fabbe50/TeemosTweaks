package com.fabbe50.ttweaks.chat;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by fabbe on 09/07/2017.
 */
public class ChatTweaks {
    @SubscribeEvent
    public void pinger(ServerChatEvent event) {
        if (!event.getPlayer().world.isRemote) {
            String message = event.getMessage();
            String name = event.getUsername();
            if (message.toLowerCase().contains("what") && message.toLowerCase().contains("my") && message.toLowerCase().contains("ping")) {
                event.getPlayer().sendMessage(new TextComponentString("<" + name + "> " + message));
                event.getPlayer().sendMessage(new TextComponentString(ChatHelper.MAGENTA + "[Server] " + ChatHelper.RESET + "Your ping is " + event.getPlayer().ping + "ms!"));
                event.setCanceled(true);
            }
            else if (message.toLowerCase().contains("ping")) {
                event.getPlayer().sendMessage(new TextComponentString("<" + name + "> " + message));
                event.getPlayer().sendMessage(new TextComponentString(ChatHelper.MAGENTA + "[Server] " + ChatHelper.RESET + "Pong!"));
                event.setCanceled(true);
            }
        }
    }
}
