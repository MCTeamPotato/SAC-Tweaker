package com.teampotato.sactweaker.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.GameRules;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber
public class SACTweakerEventHandler {
    @SubscribeEvent
    public static void onSACTweakerEaten(PlayerInteractEvent.RightClickItem event) {
        PlayerEntity player = event.getPlayer();
        Set<String> tags = player.getTags();
        UUID id = player.getUUID();
        if(Objects.requireNonNull(event.getItemStack().getItem().getRegistryName()).getNamespace().equals("sactweaker")) {
            player.sendMessage(new TranslationTextComponent("event.sactweaker.eaten"), id);
            if (tags.contains("sactweaker.eaten")) {
                player.sendMessage(new TranslationTextComponent("event.sactweaker.final"), id);
                tags.remove("sactweaker.eaten");
                return;
            }
            event.setCanceled(true);
            player.addTag("sactweaker.eaten");
        }
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.isEndConquered()) return;
        if (event.getPlayer().getCommandSenderWorld().getServer().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).toString().equals("true")) {
            System.out.println("Your armor durability is reduced!");
            event.getPlayer().addTag("armoreducer");
        }
    }
}
