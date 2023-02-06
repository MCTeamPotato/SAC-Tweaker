package com.teampotato.blahaj.events;

import com.teampotato.blahaj.Blahaj;
import com.teampotato.blahaj.CuddlyItem;
import com.teampotato.blahaj.ServerAnimationApi;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.StringNBT;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber
public class ServerEventHandler {
    @SubscribeEvent
    public static void onBlahajHolding(TickEvent.PlayerTickEvent event) {
        if (event.player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem().getRegistryName().getNamespace().equals("blahaj")) {
            ServerAnimationApi.setPlayerAnimation(event.player.getUUID(), Blahaj.animations.get("blahaj:blahaj"));
        }
    }
    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        if(event.getLeft().getItem() instanceof CuddlyItem) {
            event.getLeft().addTagElement(CuddlyItem.OWNER_KEY, StringNBT.valueOf(Objects.requireNonNull(event.getPlayer()).getName().getString()));
        }
    }
}