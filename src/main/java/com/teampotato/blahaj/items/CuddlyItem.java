package com.teampotato.blahaj.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

public class CuddlyItem extends Item {

    public static final String OWNER_KEY = "Owner";

    public CuddlyItem(Properties properties, String subtitle) {
        super(properties);
    }

    @Override
    public void onCraftedBy(ItemStack stack, World world, PlayerEntity player) {
        if (player != null && (player instanceof FakePlayer)) {
            stack.addTagElement(OWNER_KEY, StringNBT.valueOf(player.getName().getString()));
        }
        super.onCraftedBy(stack, world, player);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return super.getDestroySpeed(stack, state);
    }
}
