package ru.enis.ehidetags.commands;

import net.kyori.adventure.audience.Audience;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.configs.Data;

import java.util.*;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Format.colorize;

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
        final Audience audience = adventure().sender(sender);

        if (!sender.hasPermission(cmdname + ".command")) {
            audience.sendMessage(colorize(Data.MESSAGE.PREFIX + Data.MESSAGE.ERROR.PERMISSION));
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
            audience.sendMessage(colorize(Data.MESSAGE.PREFIX + Data.MESSAGE.ERROR.USAGE));
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "reload":
                return new ReloadSubCommand().execute(sender, cmd, commandLabel, args);
            case "debug":
                return new DebugSubCommand().execute(sender, cmd, commandLabel, args);
            case "help":
                return new HelpSubCommand().execute(sender, cmd, commandLabel, args);
            case "test":
                return new TestSubCommand().execute(sender, cmd, commandLabel, args);
        }

        audience.sendMessage(colorize(Data.MESSAGE.PREFIX + Data.MESSAGE.ERROR.USAGE));
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command,
                                      @NotNull String s, @NotNull String[] args) {
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