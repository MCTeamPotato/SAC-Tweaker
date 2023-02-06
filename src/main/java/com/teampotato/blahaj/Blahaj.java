package com.teampotato.blahaj;

import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.core.data.gson.AnimationSerializing;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
        String data = "animations";
        for (ResourceLocation getter : resourceManager.listResources(data, file -> file.equals("player.animation.json"))) {
            assert getter != null;
            String id = getter.getNamespace();
            String path = getter.getPath();
            try {
                List<KeyframeAnimation> readAnimations = AnimationSerializing.deserializeAnimation(Objects.requireNonNull(Blahaj.class.getResourceAsStream("../../../assets" + id + "/" + path)));
                for (KeyframeAnimation animation : readAnimations) {
                    animations.put(animation.extraData.get("name").toString(), animation);
                }
            } catch (Exception exception) {
                System.out.println("Blahaj failed to load animation. This shouldn't happen!");
                exception.printStackTrace();
            }
        }
        System.out.println("Animations start to load.");
        System.out.println(animations);
    }
}