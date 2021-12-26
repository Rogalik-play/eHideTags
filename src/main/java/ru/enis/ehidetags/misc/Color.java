package ru.enis.ehidetags.misc;

public class Color {

    public static String ColorFormat(String translate){
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', org.bukkit.ChatColor.translateAlternateColorCodes('§', translate));
    }
    /*
     * Здесь будет поддержка HEX цветов
     */
}
