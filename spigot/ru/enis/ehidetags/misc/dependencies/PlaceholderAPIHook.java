package ru.enis.ehidetags.misc.dependencies;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.misc.logger.Log;

public class PlaceholderAPIHook {

    public String REL;
    public String STANDART;

    public PlaceholderAPIHook(Player p, @NotNull final String s, @Nullable Player P){
        try {
            if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null && Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                this.STANDART = setPlaceholders(p, setBracketPlaceholders(p, s));
                this.REL = setPlaceholders(p, setBracketPlaceholders(p, setRelationalPlaceholders(p, s, P)));
                }
            else {
                returnInput(s);
            }
        }
        catch (Exception e){
            Log.info("PlaceholderAPI loaded unsuccessful");
        }
    }
    private String setPlaceholders(final Player p, @NotNull String s) {
        try {
            return PlaceholderAPI.setPlaceholders(p, s);
        } catch (Exception e){
            return s;
        }
    }
    private String setBracketPlaceholders(Player p, String s) {
        try {
            return PlaceholderAPI.setBracketPlaceholders(p, s);
        } catch (Exception e){}
        return s;
    }
    private String setRelationalPlaceholders(Player p, String s, Player P) {
        try {
            return PlaceholderAPI.setRelationalPlaceholders(p, P, s);
        } catch (Exception e){
            return s;
        }
    }
    private String returnInput(String s) {
        return s;
    }
}