package ru.enis.ehidetags.commands.subcommands;

import net.kyori.adventure.audience.Audience;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.misc.configs.DATA;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Format.colorize;

public class HelpCommand implements ISubCommand {
  @Override
  public Boolean execute(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @Nullable String[] args) {
    final Audience audience = adventure().sender(sender);
    if (sender.hasPermission("eht.reload")) {
    audience.sendMessage(colorize(DATA.MESSAGE.PREFIX + DATA.MESSAGE.HELP.RELOAD));
    }
    audience.sendMessage(colorize(DATA.MESSAGE.PREFIX + DATA.MESSAGE.ERROR.PERMISSION));
    return true;
  }
}
