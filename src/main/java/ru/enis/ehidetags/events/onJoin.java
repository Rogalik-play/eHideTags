package ru.enis.ehidetags.events;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.enis.ehidetags.*;
import ru.enis.ehidetags.utils.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class onJoin implements Listener{

    public onJoin(Core pluginA){
        Bukkit.getPluginManager().registerEvents(this, pluginA);
    }
    @EventHandler
    public void join(PlayerJoinEvent e) {
        other.hideName(e.getPlayer());
    }
 }

