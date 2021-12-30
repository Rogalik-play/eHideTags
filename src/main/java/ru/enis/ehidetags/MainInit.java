package ru.enis.ehidetags;

import org.bukkit.Bukkit;
import ru.enis.ehidetags.commands.cmdInit;
import ru.enis.ehidetags.events.EventInit;
import ru.enis.ehidetags.misc.UpdateChecker;
import ru.enis.ehidetags.misc.bStatsMetrics;
import ru.enis.ehidetags.misc.configs.ConfigInit;
import ru.enis.ehidetags.misc.logger.Log;
import ru.enis.ehidetags.misc.other;

public class MainInit {

    public MainInit(Core plugin){
        Log.init();
        new ConfigInit(plugin);
        other.boardSettings();
        new EventInit(plugin);
        new cmdInit(plugin);

        new UpdateChecker(plugin, 97904).getVersion(version -> {
            if (!plugin.getDescription().getVersion().equals(version)) {
                Log.info("There is a new update available.");
                Core.OUTDATED = true;
            }
        });

        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            Bukkit.getOnlinePlayers().forEach(other::hideName);
        }

        int pluginId = 	13770;
        bStatsMetrics metrics = new bStatsMetrics(plugin, pluginId);

        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§6eHideTags §f| §aSuccessfully enabled");
        Bukkit.getConsoleSender().sendMessage("§6eHideTags §f| §aBy: §fvk.com/rogablik");
        Bukkit.getConsoleSender().sendMessage("");
    }
}
