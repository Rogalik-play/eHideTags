package ru.enis.ehidetags.events;

import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.Nicknames;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Format.colorize;

public class onJoin implements Listener {

    //Регистрация ивента для плагина
    public onJoin(Core plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        //Проверка на право на получение обновлений
        if (e.getPlayer().hasPermission("eht.updatenotify") && Core.OUTDATED){
            //Auidience игрока
            final Audience audience = (Audience) adventure().player(e.getPlayer());

            //Отправка сообщения об обновлении
            audience.sendMessage(colorize(" <white>| <gold>eHideTags <br> <white>| <gray>An update for plugin is available"));
        }
        //Добавление игрока в группу для скрытия ника
        Nicknames.hideName(e.getPlayer());
    }
}

