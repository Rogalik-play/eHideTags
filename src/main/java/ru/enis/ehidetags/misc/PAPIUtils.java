package ru.enis.ehidetags.misc;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.misc.logger.Log;

public class PAPIUtils {

    public String REL;
    public String STANDART;
    public PAPIUtils(Player p, @NotNull final String s, @Nullable Player P){
        try {
            this.STANDART = setPlaceholders(p, setBracketPlaceholders(p, s));
            this.REL = setPlaceholders(p, setBracketPlaceholders(p, setRelationalPlaceholders(p, s, P)));
        }
        catch (Exception e){
            Log.info("PlaceholderAPI loaded unsuccessful. Disabling PlaceholderAPI support");
        }
    }
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