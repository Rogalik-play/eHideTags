package ru.enis.ehidetags;

import java.util.Objects;
import java.util.logging.Logger;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;
import ru.enis.ehidetags.events.*;
import ru.enis.ehidetags.utils.*;
import ru.enis.ehidetags.commands.*;
import static java.util.Objects.*;

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
         Bukkit.getPluginManager().registerEvents(this, this);
      }
      instance = this;
      new MainInit(this);
   }
}