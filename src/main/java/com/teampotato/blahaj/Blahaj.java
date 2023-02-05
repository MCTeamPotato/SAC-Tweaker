package com.teampotato.blahaj;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod("blahaj")
public class Blahaj {

    public Blahaj() {

        MinecraftForge.EVENT_BUS.register(this);

        DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, "blahaj");

        items.register("blue_shark", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_MISC), "item.blahaj.blue_shark.tooltip"));
        items.register("bread", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_MISC), null));

        System.out.println("The shark is sooooooooooooo cute.");


    }
}
