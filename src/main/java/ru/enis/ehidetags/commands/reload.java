package ru.enis.ehidetags.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import ru.enis.ehidetags.utils.*;
import ru.enis.ehidetags.*;

import java.util.Objects;

public class reload implements CommandExecutor {
    private Core plugin;
    private String cmdname = "ehtreload";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @NotNull String[] strings) {
        new Config(Core.getInstance());
        sender.sendMessage("§6eHideTags §f| §aSuccessfully reloaded");
        return true;
    }
    public reload(Core pluginA){
        plugin = pluginA;
        Objects.requireNonNull(plugin.getCommand(cmdname)).setExecutor(this);
    }
}
