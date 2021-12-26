package ru.enis.ehidetags.commands.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.Core;

import java.util.*;

public class MainTab implements TabCompleter {
    private Core plugin;
    private String cmdname = "eht";
    public MainTab(Core pluginA){
        plugin = pluginA;
        plugin.getCommand(cmdname).setTabCompleter(this);
    }

    @Nullable
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
