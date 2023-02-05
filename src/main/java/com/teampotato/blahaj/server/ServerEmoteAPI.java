package com.teampotato.blahaj.server;

import dev.kosmx.playerAnim.core.data.KeyframeAnimation;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class ServerEmoteAPI {

    protected static ServerEmoteAPI INSTANCE;
    protected abstract void setPlayerPlayingEmoteImpl(UUID player, @Nullable KeyframeAnimation KeyframeAnimation);

    public static void setPlayerEmote(UUID player, @Nullable KeyframeAnimation emote) {
        INSTANCE.setPlayerPlayingEmoteImpl(player, emote);
    }
}
