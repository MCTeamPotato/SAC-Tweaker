package com.teampotato.blahaj;

import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.core.data.gson.AnimationSerializing;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.resources.IResource;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mod("blahaj")
public class Blahaj {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "blahaj");
    public static final RegistryObject<Item> blueShark = ITEMS.register("blue_shark", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> bread = ITEMS.register("bread", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_MISC)));

    public Blahaj() {
        System.out.println("小鲨鱼真是太可爱了，让人时时刻刻都不想放开。");
        MinecraftForge.EVENT_BUS.register(this);
        Blahaj.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        System.out.println("The shark is sooooooooooooo cute.");
    }

    public static Map<String, KeyframeAnimation> animations = new HashMap<>();
    public static void load(IResourceManager resourceManager) {
        String animationFile = "player_animations";
        for (ResourceLocation entry : resourceManager.listResources(animationFile, file -> file.endsWith(".json"))) {
            try {
                IResource resource = resourceManager.getResource(entry);
                List<KeyframeAnimation> readAnimations = AnimationSerializing.deserializeAnimation(resource.getInputStream());
                KeyframeAnimation animation = readAnimations.get(0);

                String id = entry.toString().replace(animationFile + "/", "");
                id = id.substring(0, id.lastIndexOf("."));
                animations.put(id, animation);
            } catch (Exception exception) {
                System.out.println("Failed to load animation " + entry.toString());
                exception.printStackTrace();
            }
        }
    }
}