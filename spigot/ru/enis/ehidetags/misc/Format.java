package ru.enis.ehidetags.misc;

import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;

public class Format {
    public static String playerPlaceholders(String s, Player p) {
        return s
            .replaceAll("%name%", p.getName())
            .replaceAll("%displayname%", p.getDisplayName());
    }
    public static String tameablePlaceholders(String s, Tameable t) {
        return s
            .replaceAll("%name%", t.getName())
            .replaceAll("%owner%", t.getOwner().getName());
    }
}
