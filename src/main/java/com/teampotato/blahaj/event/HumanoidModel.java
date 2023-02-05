package com.teampotato.blahaj.event;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HumanoidModel {

    @SubscribeEvent
    public static void onBlahajHolding(TickEvent.PlayerTickEvent event) {
        if (event.player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem().getRegistryName().getNamespace().equals("blahaj")) {
            //ServerEmoteAPI.setPlayerEmote(event.player.getUUID(), AnimationRegistry.animations.get(Object.class));
        }
    }

}
