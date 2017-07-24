package com.fabbe50.ttweaks;

import com.fabbe50.ttweaks.chat.ChatTweaks;
import com.fabbe50.ttweaks.recipes.RecipeRegistry;
import com.fabbe50.ttweaks.stacksizes.StackSizes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

@Mod(name = TeemosTweaks.MODNAME, modid = TeemosTweaks.MODID, version = TeemosTweaks.VERSION)
public class TeemosTweaks {
    public static final String MODNAME = "Teemo's Tweaks";
    public static final String MODID = "ttweaks";
    public static final String VERSION = "1.0.3";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        RecipeRegistry.init();
        StackSizes.init();
    }

    @EventHandler
    public void serverStarted(FMLServerStartedEvent event) {
        MinecraftForge.EVENT_BUS.register(new StackSizes());
        MinecraftForge.EVENT_BUS.register(new ChatTweaks());
    }
}
