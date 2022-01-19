package ru.enis.ehidetags.events;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.TextComponent;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.Color;
import ru.enis.ehidetags.misc.PAPIUtils;
import ru.enis.ehidetags.misc.PluginPlaceholders;
import ru.enis.ehidetags.misc.configs.Config;
import net.kyori.adventure.audience.Audience;

import static ru.enis.ehidetags.Core.adventure;

public class onInteract implements Listener {

    public onInteract(Core plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void interact(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked() instanceof Player) {

            final Audience audience = adventure().player(e.getPlayer());

            Player rc = (Player) e.getRightClicked();

            String placeholders = PluginPlaceholders.replacePlaceholder(Config.message, rc);

            if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                placeholders = String.valueOf(new PAPIUtils(rc,  placeholders, e.getPlayer()).REL);
            }

            TextComponent color = Color.ColorFormat(placeholders);

            audience.sendActionBar(color);
        }
    }
}
