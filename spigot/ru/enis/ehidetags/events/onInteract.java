package ru.enis.ehidetags.events;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.*;
import net.kyori.adventure.audience.Audience;
import ru.enis.ehidetags.misc.configs.Data;
import ru.enis.ehidetags.misc.dependencies.PlaceholderAPIHook;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Color.deserialize;

public class onInteract implements Listener {

    //Регистрация ивента для плагина
    public onInteract(Core plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void interact(PlayerInteractAtEntityEvent e) {
        returnActionBar(e.getRightClicked(), e.getPlayer());
    }

    public static void returnActionBar(Entity entity, @Nullable Player player) {
        //Проверка на игрока
        if (entity instanceof Player && !entity.hasMetadata("NPC")) {
            //Проверка на включенный ЭкшнБар
            if (Data.enabled) {
                //Берет игрока для Audience
                final Audience audience = adventure().player(player);

                //Берет игрока на ПКМ
                Player rc = (Player) entity;

                //Мои заменители
                String placeholders = Format.playerPlaceholders(Data.player_message, rc);

                //Заменители из PAPI
                placeholders = String.valueOf(new PlaceholderAPIHook(rc, placeholders, player).REL);

                //Форматирование цвета
                Component color = deserialize(placeholders);

                //Отправка ЭкшнБара
                audience.sendActionBar(color);
            }
        }
        if (entity instanceof Tameable && !player.isSneaking() && ((Tameable) entity).isTamed()) {
            //Берет игрока для Audience
            final Audience audience = adventure().player(player);
            //Берет моба на ПКМ
            Tameable tm = (Tameable) entity;
            //Мои заменители
            String placeholders = Format.tameablePlaceholders(Data.tameable_message, tm);
            //Форматирование цвета
            Component color = deserialize(placeholders);
            //Отправка ЭкшнБара
            audience.sendActionBar(color);
        }
    }
}
