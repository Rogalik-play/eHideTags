package ru.enis.ehidetags;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
import org.jetbrains.annotations.NotNull;
import ru.enis.ehidetags.utils.*;

public final class Core extends JavaPlugin implements Listener {
   private Scoreboard board;
   private Team team;
   Logger log = this.getLogger();
   Config conf = new Config();

   public void onEnable() {
      if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
         Bukkit.getPluginManager().registerEvents(this, this);
      } else {
         log.warning("Could not find PlaceholderAPI!.");
      }

      conf.loadConfig();
      boardSettings();
      Bukkit.getPluginManager().registerEvents(this, this);
      if (!Bukkit.getOnlinePlayers().isEmpty()) {
         Bukkit.getOnlinePlayers().forEach(this::hideName);
      }

      Bukkit.getConsoleSender().sendMessage("");
      Bukkit.getConsoleSender().sendMessage("§6eHideTags §f| §aSuccessfully enabled");
      Bukkit.getConsoleSender().sendMessage("§6eHideTags §f| §aBy: §fvk.com/rogablik");
      Bukkit.getConsoleSender().sendMessage("");
   }

   @EventHandler
   public void onJoin(PlayerJoinEvent e) {
      this.hideName(e.getPlayer());
   }

   @EventHandler
   public void onInteract(PlayerInteractAtEntityEvent e) {
      if (e.getRightClicked() instanceof Player) {
         if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders((Player) e.getRightClicked(), Config.message))));
         } else {
            e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', Config.message).replace("%player_displayname%", ((Player) e.getRightClicked()).getDisplayName())));
         }
      }
   }

   private void hideName(Player p) {
      this.team.addEntry(p.getName());
      p.setScoreboard(this.board);
   }

   private void boardSettings() {
      this.board = ((ScoreboardManager)Objects.requireNonNull(Bukkit.getScoreboardManager())).getNewScoreboard();
      this.board.registerNewTeam("eHideTags");
      this.team = this.board.getTeam("eHideTags");
      ((Team)Objects.requireNonNull(this.team)).setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
      this.team.setCanSeeFriendlyInvisibles(false);
   }

   public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("ehtreload")) {
         conf.loadConfig();
         sender.sendMessage("§6eHideTags §f| §aSuccessfully reloaded");
         return true;
      } else {
         return false;
      }
   }
}
