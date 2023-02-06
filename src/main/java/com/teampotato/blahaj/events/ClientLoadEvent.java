package com.teampotato.blahaj.events;

import com.teampotato.blahaj.Blahaj;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "blahaj", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientLoadEvent {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        Blahaj.load(Minecraft.getInstance().getResourceManager());
    }
}
