package ru.enis.ehidetags;

import lombok.Getter;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.enis.ehidetags.commands.MainCommand;
import ru.enis.ehidetags.events.onInteract;
import ru.enis.ehidetags.events.onJoin;
import ru.enis.ehidetags.misc.Color;
import ru.enis.ehidetags.misc.UpdateChecker;
import ru.enis.ehidetags.misc.configs.Config;
import ru.enis.ehidetags.misc.configs.Messages;
import ru.enis.ehidetags.misc.logger.Log;
import ru.enis.ehidetags.misc.other;

import static net.kyori.adventure.text.Component.text;
import static ru.enis.ehidetags.misc.Color.defaultColorize;

public final class Core extends JavaPlugin implements Listener {
   String serverPackageName;
   String serverApiVersion;
   static int majorMinecraftVersion;
   public static boolean OUTDATED = false;
   @Getter private static Core instance;
   private static BukkitAudiences adventure;

   public static @NotNull BukkitAudiences adventure() {
      if(adventure == null) {
         throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
      }
      return adventure;
   }

   public static int majorMinecraftVersion() {
      return majorMinecraftVersion;
   }

   public void onEnable() {
      instance = this;
      adventure = BukkitAudiences.create(this);

      this.serverPackageName = this.getServer().getClass().getPackage().getName();
      this.serverApiVersion = this.serverPackageName.substring(this.serverPackageName.lastIndexOf('.') + 1);
      majorMinecraftVersion = Integer.parseInt(this.serverApiVersion.split("_")[1]);
      //Logger
      Log.init();
      //Config
      new Config(this);
      new Messages(this);
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

      Audience console = adventure().console();

      console.sendMessage(text(""));
      console.sendMessage(defaultColorize("§6eHideTags §f| §aSuccessfully enabled"));
      console.sendMessage(text(""));
   }

   @Override
   public void onDisable() {
      if(adventure != null) {
         adventure.close();
         adventure = null;
      }
      if (Bukkit.getPluginManager().getPlugin("TAB") == null && !Bukkit.getPluginManager().isPluginEnabled("TAB")) {
         other.removeBoard();
      }
   }
}