package ru.enis.ehidetags.utils;

import java.util.Objects;

import ru.enis.ehidetags.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
   public static String message;
   private Core plugin;

   public Config(Core pluginA) {
      plugin = pluginA;
      CustomYML config = new CustomYML("MainСonfig", plugin);
      message = (String)config.getConfigField("message", "%player_displayname%");
   }
}
