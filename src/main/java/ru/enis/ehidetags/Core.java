package ru.enis.ehidetags;

import java.util.logging.Logger;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.jetbrains.annotations.NotNull;
import ru.enis.ehidetags.commands.MainCommand;
import ru.enis.ehidetags.events.onInteract;
import ru.enis.ehidetags.events.onJoin;
import ru.enis.ehidetags.misc.UpdateChecker;
import ru.enis.ehidetags.misc.configs.ConfigInit;
import ru.enis.ehidetags.misc.logger.Log;
import ru.enis.ehidetags.misc.other;

public final class Core extends JavaPlugin implements Listener {
   String serverPackageName;
   String serverApiVersion;
   static int majorMinecraftVersion;
   public static boolean OUTDATED = false;
   private static Core instance;
   Logger log = this.getLogger();
   private static BukkitAudiences adventure;

   public static @NotNull BukkitAudiences adventure() {
      if(adventure == null) {
         throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
      }
      return adventure;
   }
   public static Core getInstance(){
      return instance;
   }

   public static int majorMinecraftVersion() {
      return majorMinecraftVersion;
   }

   public void onEnable() {
      adventure = BukkitAudiences.create(this);

      if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
         Bukkit.getPluginManager().registerEvents(this, this);
      } else {
         log.warning("Could not find PlaceholderAPI!.");
      }
      instance = this;

      this.serverPackageName = this.getServer().getClass().getPackage().getName();
      this.serverApiVersion = this.serverPackageName.substring(this.serverPackageName.lastIndexOf('.') + 1);
      majorMinecraftVersion = Integer.parseInt(this.serverApiVersion.split("_")[1]);
      //Logger
      Log.init();
      //Config
      new ConfigInit(this);
      //Board
      other.boardSettings();
      //Event
      new onJoin(this);
      new onInteract(this);
      //Command
      new MainCommand(this);
      //Update Checker
      new UpdateChecker(this, 97904).getVersion(version -> {
         if (!this.getDescription().getVersion().equals(version)) {
            Log.info("There is a new update available.");
            OUTDATED = true;
         }
      });
      //bStats
      int thisId = 	13770;
      final Metrics metrics = new Metrics(this, thisId);

      if (!Bukkit.getOnlinePlayers().isEmpty()) {
         Bukkit.getOnlinePlayers().forEach(other::hideName);
      }

      Bukkit.getConsoleSender().sendMessage("");
      Bukkit.getConsoleSender().sendMessage("§6eHideTags §f| §aSuccessfully enabled");
      Bukkit.getConsoleSender().sendMessage("§6eHideTags §f| §aBy: §fvk.com/rogablik");
      Bukkit.getConsoleSender().sendMessage("");
   }

   @Override
   public void onDisable() {
      if(adventure != null) {
         adventure.close();
         adventure = null;
      }
   }
}