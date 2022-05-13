package ru.enis.ehidetags.misc.dependencies;

import lombok.Getter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.logger.Log;

public class DependenciesManager {

    @Getter VaultHook vaultHook;
    @Getter PlaceholderAPIHook PAPIHook;
    @Getter private static DependenciesManager instance;

    public DependenciesManager(Core plugin) {
        instance = this;
        final PluginManager pm = Bukkit.getPluginManager();
        if(pm.isPluginEnabled("PlaceholderAPI") && pm.getPlugin("PlaceholderAPI") != null) {
            PAPIHook = new PlaceholderAPIHook();
            Log.info("PlaceholderAPI hooked!");
        }
        if(pm.isPluginEnabled("Vault") && pm.getPlugin("Vault") != null) {
            vaultHook = new VaultHook();
            Log.info("Vault hooked!");
        }
    }
}
