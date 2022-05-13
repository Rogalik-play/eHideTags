package ru.enis.ehidetags.misc.dependencies;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.RegisteredServiceProvider;

import static org.bukkit.Bukkit.getServer;

public class VaultHook {
    private Chat chat;
    public VaultHook() {
        setupChat();
    }
    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
    public Chat getChat() {
        return chat;
    }
}
