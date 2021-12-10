package ru.enis.ehidetags.events;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.utils.Config;

public class onInteract implements Listener {

    public onInteract(Core pluginA){
        Bukkit.getPluginManager().registerEvents(this, pluginA);
    }

    @EventHandler
    public void interact(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked() instanceof Player) {
            System.out.println("onInteract");
            if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders((Player) e.getRightClicked(), Config.message))));
            } else {
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', Config.message).replace("%player_displayname%", ((Player) e.getRightClicked()).getDisplayName())));
            }
        }
    }
}
