package com.teampotato.blahaj.events;

import com.teampotato.blahaj.Blahaj;
import com.teampotato.blahaj.CuddlyItem;
import com.teampotato.blahaj.ServerAnimationApi;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.StringNBT;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber
public class ServerEventHandler {
    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        if(event.getLeft().getItem() instanceof CuddlyItem) {
            event.getLeft().addTagElement(CuddlyItem.OWNER_KEY, StringNBT.valueOf(Objects.requireNonNull(event.getPlayer()).getName().getString()));
        }
    }

    @SubscribeEvent
    public static void onCuddling(PlayerInteractEvent.RightClickItem event) {
        if (event.getItemStack().getItem().getRegistryName().getNamespace().equals("blahaj")) {
            ServerAnimationApi.setPlayerAnimation(event.getPlayer().getUUID(), Blahaj.animations.get("blahaj:blahaj"));
        }
    }
}