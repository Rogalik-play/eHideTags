package ru.enis.ehidetags.commands;

import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.configs.Config;
import ru.enis.ehidetags.misc.configs.Messages;
import ru.enis.ehidetags.misc.other;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Color.ColorFormat;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.kyori.adventure.text.Component.text;
import static ru.enis.ehidetags.misc.configs.Messages.Plugin_Prefix;

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
        if (!sender.hasPermission(cmdname + ".command")) {
            audience.sendMessage(ColorFormat(Plugin_Prefix + " §f| " + Messages.NoPermission));
            return true;
        }
        if(args.length == 0){
            audience.sendMessage(ColorFormat(" §f| " + Plugin_Prefix +
                "\n &f| &aAuthor: " + Core.getInstance().getDescription().getAuthors() +
                "\n &f| &aVersion: " + plugin.getDescription().getVersion()));
            return true;
        }
        if (args.length > 1) {
            audience.sendMessage(ColorFormat(Plugin_Prefix + " §f| " + Messages.Wrong_Usage));
            return true;
        }
        if(args[0].equalsIgnoreCase("reload") && sender.hasPermission(cmdname + ".reload")) {
            new Config(plugin);
            new Messages(plugin);
            audience.sendMessage(ColorFormat( Plugin_Prefix + " §f| " + Messages.Config_Reloaded));
            return true;
        }
        if(args[0].equalsIgnoreCase("debug") && sender.hasPermission(cmdname + ".debug")) {
            ArrayList playerlist = new ArrayList();
            Bukkit.getServer().getOnlinePlayers().forEach(p -> playerlist.add(p.getName()));
            audience.sendMessage(ColorFormat(" §f| " + Plugin_Prefix +
                "\n &f| &aTeam Members: " + other.getScoreBoard().getTeam("eHideTags").getEntries().toString() +
                "\n &f| &aPlayer List: " + playerlist +
                "\n &f| &aPlugin Version: " + Core.getInstance().getDescription().getVersion() +
                "\n &f| &aServer Version: " + Bukkit.getServer().getVersion()));
            return true;
        }
        if(args[0].equalsIgnoreCase("help") && sender.hasPermission(cmdname + ".help")) {
            audience.sendMessage(ColorFormat(" §f| " + Plugin_Prefix +
                "\n §f| §a/" + cmdname + " reload - " + Messages.Reload_Help ));
            return true;
        }
        audience.sendMessage(ColorFormat(Plugin_Prefix + " §f| " + Messages.Wrong_Usage));
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        final List<String> completions = new ArrayList<>();

        if(commandSender.hasPermission(cmdname + ".reload")) {
            completions.add("reload");
        }
        if(commandSender.hasPermission(cmdname + ".help")) {
            completions.add("help");
        }
        if(commandSender.hasPermission(cmdname + ".debug")) {
            completions.add("debug");
        }
        Collections.sort(completions);
        return completions;
    }
}
