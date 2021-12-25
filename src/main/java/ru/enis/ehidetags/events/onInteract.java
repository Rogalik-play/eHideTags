package ru.enis.ehidetags.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.*;
import ru.enis.ehidetags.misc.configs.Config;

public class onInteract implements Listener {

    public onInteract(Core pluginA){
        Bukkit.getPluginManager().registerEvents(this, pluginA);
    }

    @EventHandler
    public void interact(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked() instanceof Player) {
            if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(PluginPlaceholders.replacePlaceholder(String.valueOf(new PAPIUtils( (Player) e.getRightClicked(), (String) Config.message,(Player) e.getPlayer()).REL), (Player) e.getRightClicked())));
            } else {
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(PluginPlaceholders.replacePlaceholder(Config.message, (Player) e.getRightClicked())));
            }
        }
    }
}
