package ru.enis.ehidetags.misc;

import org.bukkit.entity.Player;

public class PluginPlaceholders {
    public static String replacePlaceholder(String s, Player p){
        return s.replaceAll("%player%", p.getDisplayName());
    }
}
