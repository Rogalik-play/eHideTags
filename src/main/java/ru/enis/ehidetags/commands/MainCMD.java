package ru.enis.ehidetags.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.configs.ConfigInit;
import ru.enis.ehidetags.misc.configs.Messages;

public class MainCMD implements CommandExecutor {
    private Core plugin;
    private String cmdname = "eht";
    public MainCMD(Core pluginA){
        plugin = pluginA;
        plugin.getCommand(cmdname).setExecutor(this);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @Nullable String[] args) {
        if (!sender.hasPermission("eht.command")) {
            sender.sendMessage("§6eHideTags §f| " + Messages.NoPermission);
            return true;
        }
        if(args.length == 0){
            sender.sendMessage("§6eHideTags\n" + "§aAuthor: " + Core.getInstance().getDescription().getAuthors() + "\nVersion: " + plugin.getDescription().getVersion());
            return true;
        }
        if (args.length > 1) {
            sender.sendMessage("§6eHideTags §f| " + Messages.Wrong_Usage);
            return true;
        }
        if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("eht.reload")) {
            new ConfigInit(plugin);
            sender.sendMessage("§6eHideTags §f| " + Messages.Plugin_Reloaded);
            return true;
        }
        if(args[0].equalsIgnoreCase("help") && sender.hasPermission("eht.help")) {
            sender.sendMessage("§6eHideTags §f| §a/eht reload - " + Messages.help_Cmd_Reload);
            return true;
        }
        sender.sendMessage("§6eHideTags §f| " + Messages.Wrong_Usage);
        return true;
    }
}
