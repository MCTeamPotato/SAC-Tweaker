package com.teampotato.sactweaker.item;

import com.teampotato.sactweaker.SACTweaker;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SACTweakerGroup extends ItemGroup {
    public SACTweakerGroup() {
        super("sactweaker_group");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(SACTweaker.blueShark.get());
    }
}
