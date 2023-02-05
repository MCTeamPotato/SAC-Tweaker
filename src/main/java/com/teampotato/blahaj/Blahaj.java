package com.teampotato.blahaj;

import com.teampotato.blahaj.items.CuddlyItem;
import com.teampotato.blahaj.items.CuddlyRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("blahaj")
public class Blahaj {
    public Blahaj() {
        MinecraftForge.EVENT_BUS.register(this);
        CuddlyRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        System.out.println("The shark is sooooooooooooo cute.");
    }
}
