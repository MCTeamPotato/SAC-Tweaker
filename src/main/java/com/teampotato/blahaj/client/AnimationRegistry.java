package com.teampotato.blahaj.client;

import com.teampotato.blahaj.Blahaj;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.core.data.gson.AnimationSerializing;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AnimationRegistry {
    public static Map<String, KeyframeAnimation> animations = new HashMap<>();

    public static void load(IResourceManager resourceManager) {
        String data = "animations";
        for (ResourceLocation getter : resourceManager.listResources(data, file -> file.equals("player.animation.json"))) {
            assert getter != null;
            String modid = getter.getNamespace();
            String resource = getter.getPath();
            try {
                List<KeyframeAnimation> readAnimations = AnimationSerializing.deserializeAnimation(Objects.requireNonNull(Blahaj.class.getResourceAsStream("../../../assets" + modid + "/" + resource)));
                for (KeyframeAnimation animation : readAnimations) {
                    animations.put(animation.extraData.get("name").toString(), animation);
                }
            } catch (Exception exception) {
                System.out.println("Failed to load animation " + modid.toString());
                exception.printStackTrace();
            }
        }
    }
}
