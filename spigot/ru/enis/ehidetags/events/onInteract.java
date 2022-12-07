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
import ru.enis.ehidetags.misc.configs.Data;
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
        if (Data.ACTIONBAR.ENABLE && returnFormatted(Data.ACTIONBAR.MESSAGE, Data.ACTIONBAR.USE_TAME,
            e.getRightClicked(), e.getPlayer()) != null) {
                audience.sendActionBar(returnFormatted(Data.ACTIONBAR.MESSAGE, Data.ACTIONBAR.USE_TAME,
                    e.getRightClicked(), e.getPlayer()));
        }

    }

    public static Component returnFormatted(String toFormat, Boolean sendTame, Entity entity, @Nullable Player player) {
        //Проверка на игрока
        if (entity instanceof Player && !entity.hasMetadata("NPC")) {
            //Мои заменители
            String placeholders = Format.playerPlaceholders(Data.ACTIONBAR.MESSAGE, ((Player) entity).getPlayer());
            //Заменители из PAPI
            placeholders = String.valueOf(new PlaceholderAPIHook(((Player) entity).getPlayer(), placeholders, player).REL);
            //Возврат форматированного
            return colorize(placeholders);
        }
        if (player != null && entity instanceof Tameable && !player.isSneaking() && ((Tameable) entity).isTamed() && sendTame) {
            if (entity.getCustomName() != null) {
                return colorize("<white>" + entity.getCustomName());
            } else {
                return null;
            }
        }
        return null;
    }
}
