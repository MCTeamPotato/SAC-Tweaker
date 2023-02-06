package com.teampotato.sactweaker.item;

import com.teampotato.sactweaker.SACTweaker;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SACTweakerFood extends Item {
    private static final Food food = (new Food.Builder()).alwaysEat().effect(() -> new EffectInstance(Effects.WATER_BREATHING, 600 * 20), 1).build();

    public SACTweakerFood() {
        super(new Properties().food(food).stacksTo(1).tab(SACTweaker.sactweakerGroup));
    }
}
