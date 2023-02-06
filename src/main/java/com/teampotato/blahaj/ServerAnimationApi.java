package com.teampotato.blahaj;

import dev.kosmx.playerAnim.core.data.KeyframeAnimation;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class ServerAnimationApi {
    protected static ServerAnimationApi API;
    protected abstract void setPlayerPlayingAnimationImpl(UUID player, @Nullable KeyframeAnimation KeyframeAnimation);
    public static void setPlayerAnimation(UUID player, @Nullable KeyframeAnimation animation) {
        API.setPlayerPlayingAnimationImpl(player, animation);
    }
}