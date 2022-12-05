package ru.enis.ehidetags.commands.subcommands;

import net.kyori.adventure.audience.Audience;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.configs.ConfigTOML;
import ru.enis.ehidetags.misc.configs.DATA;
import ru.enis.ehidetags.misc.configs.MessagesTOML;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Format.colorize;

public class ReloadCommand implements ISubCommand {
  @Override
  public Boolean execute(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @Nullable String[] args) {
    final Audience audience = adventure().sender(sender);
    if (sender.hasPermission("eht.reload")) {
      Core plugin = Core.getInstance();

      new ConfigTOML(plugin);
      new MessagesTOML(plugin);

      audience.sendMessage(colorize( DATA.MESSAGE.PREFIX + DATA.MESSAGE.SUCCESS.RELOAD));
    }
    audience.sendMessage(colorize(DATA.MESSAGE.PREFIX + DATA.MESSAGE.ERROR.PERMISSION));
    return true;
  }
}
