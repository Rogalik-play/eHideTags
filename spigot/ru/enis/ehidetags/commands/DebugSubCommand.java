package ru.enis.ehidetags.commands;

import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.Nicknames;
import ru.enis.ehidetags.misc.configs.Data;

import java.util.ArrayList;
import java.util.Objects;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Format.colorize;

public class DebugSubCommand implements ISubCommand {
  @Override
  public Boolean execute(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @Nullable String[] args) {
    final Audience audience = adventure().sender(sender);
    if (sender.hasPermission("eht.debug")) {
      ArrayList<String> players = new ArrayList<>();
      Bukkit.getServer().getOnlinePlayers().forEach(p -> players.add(p.getName()));
      audience.sendMessage(colorize(" <white>| <gold>eHideTags" +
          "\n <white>| <green>Team Members: " + Objects.requireNonNull(Nicknames.getScoreBoard().getTeam("eHideTags")).getEntries() +
          "\n <white>| <green>Player List: " + players +
          "\n <white>| <green>Plugin Version: " + Core.getInstance().getDescription().getVersion() +
          "\n <white>| <green>Server Version: " + Bukkit.getServer().getVersion()));
      return true;
    }
    audience.sendMessage(colorize(Data.MESSAGE.PREFIX + Data.MESSAGE.ERROR.PERMISSION));
    return true;
  }
}
