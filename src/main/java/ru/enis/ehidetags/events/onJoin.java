package ru.enis.ehidetags.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class onJoin implements Listener {

    public onJoin(Core pluginA) {
        Bukkit.getPluginManager().registerEvents(this, pluginA);
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        if (e.getPlayer().hasPermission("eht.updatenotify") && Core.OUTDATED){
            e.getPlayer().sendMessage(Color.ColorFormat("§6eHideTags §f| &7An update for plugin is available"));
        }
        other.hideName(e.getPlayer());
    }
}

