package ru.enis.ehidetags.utils;

import java.util.Objects;
import ru.enis.ehidetags.utils.CustomYML;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
   public static String message;

   public void loadConfig() {
      CustomYML config = new CustomYML("MainСonfig", (JavaPlugin) Bukkit.getPluginManager().getPlugin("eHideTags"));
      message = (String)config.getConfigField("message", "%player_displayname%");
   }
}
