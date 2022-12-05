package ru.enis.ehidetags.commands;

import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.commands.subcommands.DebugCommand;
import ru.enis.ehidetags.commands.subcommands.HelpCommand;
import ru.enis.ehidetags.commands.subcommands.ReloadCommand;
import ru.enis.ehidetags.commands.subcommands.TestCommand;
import ru.enis.ehidetags.misc.configs.DATA;

import java.util.*;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Format.colorize;

public class MainCommand implements CommandExecutor, TabCompleter {
    private Core plugin;
    private String cmdname = "eht";
    public MainCommand(Core pluginA){
        plugin = pluginA;
        Map<String, Object> cmdmap = new HashMap<String, Object>();
        Bukkit.getPluginManager().getPlugin(plugin.getName()).getDescription().getCommands().put("eht", cmdmap);
        PluginCommand command = plugin.getCommand(cmdname);
        command.setAliases(Arrays.asList(new String[] { "ehidetags" }));
        command.setDescription("Main Plugin Command");
        command.setUsage("/eht");
        command.setExecutor(this);
        command.setTabCompleter(this);

//        org.bukkit.command.defaults.HelpCommand
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @Nullable String[] args) {
        final Audience audience = adventure().sender(sender);

        if (!sender.hasPermission(cmdname + ".command")) {
            audience.sendMessage(colorize(DATA.MESSAGE.PREFIX + DATA.MESSAGE.ERROR.PERMISSION));
            return true;
        }

        if(args.length == 0){
            audience.sendMessage(colorize(
                " <white>| <gold>eHideTags" +
                "<br> <white>| <green>Author: " + plugin.getDescription().getAuthors() +
                "<br> <white>| <green>Version: " + plugin.getDescription().getVersion())
            );
            return true;
        }

        if (args.length > 1) {
            audience.sendMessage(colorize(DATA.MESSAGE.PREFIX + DATA.MESSAGE.ERROR.USAGE));
            return true;
        }

        if(args[0].equalsIgnoreCase("reload") && sender.hasPermission(cmdname + ".reload")) {
            return new ReloadCommand().execute(sender, cmd, commandLabel, args);
        }

        if(args[0].equalsIgnoreCase("debug") && sender.hasPermission(cmdname + ".debug")) {
            return new DebugCommand().execute(sender, cmd, commandLabel, args);
        }

        if(args[0].equalsIgnoreCase("help") && sender.hasPermission(cmdname + ".help")) {
            return new HelpCommand().execute(sender, cmd, commandLabel, args);
        }

        if(args[0].equalsIgnoreCase("test") && sender.hasPermission(cmdname + ".test")) {
            return new TestCommand().execute(sender, cmd, commandLabel, args);
        }

        audience.sendMessage(colorize(DATA.MESSAGE.PREFIX + DATA.MESSAGE.ERROR.USAGE));
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
        if(commandSender.hasPermission(cmdname + ".test")) {
            completions.add("test");
        }
        Collections.sort(completions);
        return completions;
    }
}