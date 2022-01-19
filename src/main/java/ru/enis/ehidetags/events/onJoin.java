package ru.enis.ehidetags.events;

import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import static ru.enis.ehidetags.Core.adventure;

public class onJoin implements Listener {

    public onJoin(Core plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        if (e.getPlayer().hasPermission("eht.updatenotify") && Core.OUTDATED){
            final Audience audience = (Audience) adventure().player(e.getPlayer());
            audience.sendMessage(Color.ColorFormat("§6eHideTags §f| &7An update for plugin is available"));
        }
        other.hideName(e.getPlayer());
    }
}

