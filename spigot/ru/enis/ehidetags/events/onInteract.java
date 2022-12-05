package ru.enis.ehidetags.events;

import net.kyori.adventure.audience.Audience;
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
import ru.enis.ehidetags.misc.Format;
import ru.enis.ehidetags.misc.configs.DATA;
import ru.enis.ehidetags.dependencies.PlaceholderAPIHook;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Format.colorize;

public class onInteract implements Listener {

    //Регистрация ивента для плагина
    public onInteract(Core plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void interact(PlayerInteractAtEntityEvent e) {
        //Берет игрока для Audience
        final Audience audience = adventure().player(e.getPlayer());
        //Отправка ЭкшнБара
        audience.sendActionBar(returnFormated(e.getRightClicked(), e.getPlayer()) != null ? returnFormated(e.getRightClicked(), e.getPlayer()) : Component.text("null"));
    }

    public static Component returnFormated(Entity entity, @Nullable Player player) {
        //Проверка на игрока
        if (entity instanceof Player && !entity.hasMetadata("NPC")) {
            //Проверка на включенный ЭкшнБар
            if (DATA.ACTIONBAR.ENABLE) {
                //Берет игрока на ПКМ
                Player rc = (Player) entity;

                //Мои заменители
                String placeholders = Format.playerPlaceholders(DATA.ACTIONBAR.MESSAGE, rc);

                //Заменители из PAPI
                placeholders = String.valueOf(new PlaceholderAPIHook(rc, placeholders, player).REL);

                //Форматирование цвета
                Component color = colorize(placeholders);

                //Возврат форматированного
                return color;
            }
        }
        if (entity instanceof Tameable && !player.isSneaking() && ((Tameable) entity).isTamed()) {
            //Берет моба на ПКМ
            Tameable tm = (Tameable) entity;
            //Форматирование цвета
            Component color = colorize("<white>" + tm.getName());
            //Возврат форматированного
            return color;
        }
        return null;
    }
}
