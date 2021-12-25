package ru.enis.ehidetags;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin implements Listener {
   private static Core instance;
   Logger log = this.getLogger();
   public static Core getInstance(){
      return instance;
   }

   public void onEnable() {
      if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
         Bukkit.getPluginManager().registerEvents(this, this);
      } else {
         log.warning("Could not find PlaceholderAPI!.");
      }
      instance = this;
      new MainInit(this);
   }
}