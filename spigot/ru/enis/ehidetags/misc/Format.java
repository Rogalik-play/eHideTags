package ru.enis.ehidetags.misc;

import org.bukkit.entity.Player;

public class Format {
    public static String replacePlaceholder(String s, Player p) {
        return s
            .replaceAll("%name%", p.getName())
            .replaceAll("%displayname%", p.getDisplayName());
    }
}
