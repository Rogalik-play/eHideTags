package ru.enis.ehidetags.misc;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;

public class Format {
    public static String playerPlaceholders(String s, Player p) {
        return s
            .replaceAll("%name%", p.getName())
            .replaceAll("%displayname%", p.getDisplayName());
    }
    public static Component colorize(String input) {
        return MiniMessage.miniMessage().deserialize(input);
    }
}
