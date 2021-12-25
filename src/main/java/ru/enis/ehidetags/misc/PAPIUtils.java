package ru.enis.ehidetags.misc;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Logger;

public class PAPIUtils {
    private static final Logger log = Bukkit.getLogger();

    public String REL;
    public String STANDART;
    public PAPIUtils(Player p, @NotNull final String s, @Nullable Player P){
        try {
            this.STANDART = setPlaceholders(p, setBracketPlaceholders(p, s));
            this.REL = setPlaceholders(p, setBracketPlaceholders(p, setRelationalPlaceholders(p, s, P)));
        }
        catch (Exception e){
            log.warning("PlaceholderAPI loaded unsuccessful. Disabling PlaceholderAPI support");
        }
    }
    @NotNull
    public static String setPlaceholders(final Player p, @NotNull String s) {
        try {
            return PlaceholderAPI.setPlaceholders(p, s);
        } catch (Exception e){
            return s;
        }
    }
    public static String setBracketPlaceholders(Player p, String s) {
        try {
            return PlaceholderAPI.setBracketPlaceholders(p, s);
        } catch (Exception e){}
        return s;
    }
    public static String setRelationalPlaceholders(Player p, String s, Player P) {
        try {
            return PlaceholderAPI.setRelationalPlaceholders(p, P, s);
        } catch (Exception e){
            return s;
        }
    }
}
