package com.teampotato.blahaj.event;

import com.teampotato.blahaj.items.CuddlyItem;
import net.minecraft.nbt.StringNBT;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber
public class AnvilEventListener {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        if(event.getLeft().getItem() instanceof CuddlyItem) {
            event.getLeft().addTagElement(CuddlyItem.OWNER_KEY, StringNBT.valueOf(Objects.requireNonNull(event.getPlayer()).getName().getString()));
        }
    }
}
