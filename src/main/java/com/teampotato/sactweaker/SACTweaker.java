package com.teampotato.sactweaker;

import com.teampotato.sactweaker.item.SACTweakerFood;
import com.teampotato.sactweaker.item.SACTweakerGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("sactweaker")
public class SACTweaker {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "sactweaker");
    public static final RegistryObject<Item> blueShark = ITEMS.register("blue_shark", () -> new SACTweakerFood());
    public static final ItemGroup sactweakerGroup = new SACTweakerGroup();

    public SACTweaker() {
        MinecraftForge.EVENT_BUS.register(this);
        SACTweaker.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}