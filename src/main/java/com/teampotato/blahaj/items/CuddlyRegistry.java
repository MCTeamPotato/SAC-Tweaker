package com.teampotato.blahaj.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CuddlyRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "blahaj");
    public static final RegistryObject<Item> blueShark = ITEMS.register("blue_shark", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_MISC), "item.blahaj.blue_shark.tooltip"));
    public static final RegistryObject<Item> bread = ITEMS.register("bread", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_MISC), null));
}
