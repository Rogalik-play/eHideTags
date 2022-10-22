package ru.enis.ehidetags.events;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.*;
import net.kyori.adventure.audience.Audience;
import ru.enis.ehidetags.misc.configs.ActionBar;
import ru.enis.ehidetags.misc.dependencies.PlaceholderAPIHook;

import static ru.enis.ehidetags.Core.adventure;

public class onInteract implements Listener {

    //Регистрация ивента для плагина
    public onInteract(Core plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void interact(PlayerInteractAtEntityEvent e) {
        //Проверка на игрока
        if (e.getRightClicked() instanceof Player && !e.getRightClicked().hasMetadata("NPC")) {
            //Проверка на включенный ЭкшнБар
            if (ActionBar.enabled) {
                //Берет игрока для Audience
                final Audience audience = adventure().player(e.getPlayer());

                //Берет игрока на ПКМ
                Player rc = (Player) e.getRightClicked();

                //Мои заменители
                String placeholders = Format.playerPlaceholders(ActionBar.player_message, rc);

                //Заменители из PAPI
                placeholders = String.valueOf(new PlaceholderAPIHook(rc, placeholders, e.getPlayer()).REL);

                //Форматирование цвета
                TextComponent color = Color.ColorFormat(placeholders);

                //Отправка ЭкшнБара
                audience.sendActionBar(color);
            }
        }
        if (e.getRightClicked() instanceof Tameable && !e.getPlayer().isSneaking() && ((Tameable) e.getRightClicked()).isTamed()) {
            //Берет игрока для Audience
            final Audience audience = adventure().player(e.getPlayer());
            //Берет моба на ПКМ
            Tameable tm = (Tameable) e.getRightClicked();
            //Мои заменители
            String placeholders = Format.tameablePlaceholders(ActionBar.tameable_message, tm);
            //Форматирование цвета
            TextComponent color = Color.ColorFormat(placeholders);
            //Отправка ЭкшнБара
            audience.sendActionBar(color);
        }
    }
}
