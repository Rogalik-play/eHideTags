package ru.enis.ehidetags.misc;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.entity.Player;
import ru.enis.ehidetags.misc.dependencies.DependenciesManager;
import ru.enis.ehidetags.misc.dependencies.VaultHook;

public class Format {
    private static Chat chat;
    public static String replacePlaceholder(String s, Player p){
        VaultHook vaultHook = DependenciesManager.getInstance().getVaultHook();
        if (vaultHook != null){
            s
                .replaceAll("%prefix%", vaultHook.getChat().getPlayerSuffix(p))
                .replaceAll("suffix", vaultHook.getChat().getPlayerSuffix(p));
        } else {
            s
                .replaceAll("%prefix%", "")
                .replaceAll("suffix", "");
        }
        return s.replaceAll("%player%", p.getDisplayName());
    }
}
