package ru.enis.ehidetags.commands;

import net.kyori.adventure.audience.Audience;
import org.bukkit.command.*;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.Color;
import ru.enis.ehidetags.misc.configs.ConfigInit;
import ru.enis.ehidetags.misc.configs.Messages;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Color.ColorFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.kyori.adventure.text.Component.text;

public class MainCommand implements CommandExecutor, TabCompleter {
    private Core plugin;
    private String cmdname = "eht";
    public MainCommand(Core pluginA){
        plugin = pluginA;
        PluginCommand command = plugin.getCommand(cmdname);
        command.setExecutor(this);
        command.setTabCompleter(this);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @Nullable String[] args) {
        final Audience audience = (Audience) adventure().sender(sender);
        if (!sender.hasPermission("eht.command")) {
            audience.sendMessage(ColorFormat("§6eHideTags §f| " + Messages.NoPermission));
            return true;
        }
        if(args.length == 0){
            audience.sendMessage(ColorFormat("§6eHideTags\n" + "§aAuthor: " + Core.getInstance().getDescription().getAuthors() + "\nVersion: " + plugin.getDescription().getVersion()));
            return true;
        }
        if (args.length > 1) {
            audience.sendMessage(ColorFormat("§6eHideTags §f| " + Messages.Wrong_Usage));
            return true;
        }
        if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("eht.reload")) {
            new ConfigInit(plugin);
            audience.sendMessage(ColorFormat("§6eHideTags §f| " + Messages.Plugin_Reloaded));
            return true;
        }
        if(args[0].equalsIgnoreCase("help") && sender.hasPermission("eht.help")) {
            audience.sendMessage(ColorFormat("§6eHideTags §f| §a/eht reload - " + Messages.help_Cmd_Reload));
            return true;
        }
        audience.sendMessage(ColorFormat("§6eHideTags §f| " + Messages.Wrong_Usage));
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        final List<String> completions = new ArrayList<>();

        if(commandSender.hasPermission("eht.reload")) {
            completions.add("reload");
        }
        if(commandSender.hasPermission("eht.help")) {
            completions.add("help");
        }
        Collections.sort(completions);
        return completions;
    }
}
