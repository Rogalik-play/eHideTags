package ru.enis.ehidetags.commands;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.events.onInteract;
import ru.enis.ehidetags.misc.configs.Data;

import java.util.Objects;

import static ru.enis.ehidetags.Core.adventure;
import static ru.enis.ehidetags.misc.Format.colorize;

public class TestSubCommand implements ISubCommand {
  @Override
  public Boolean execute(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @Nullable String[] args) {
    final Audience audience = adventure().sender(sender);
    if (sender.hasPermission("eht.test")) {
      if (sender instanceof Player) {
        //Отправка ЭкшнБара
        audience.sendActionBar(onInteract.returnFormatted(((Player) sender).getPlayer(), ((Player) sender).getPlayer(), true) != null ? Objects.requireNonNull(onInteract.returnFormatted(((Player) sender).getPlayer(), ((Player) sender).getPlayer(), true)) : Component.text("null"));
      }
      return true;
    }
    audience.sendMessage(colorize(Data.MESSAGE.PREFIX + Data.MESSAGE.ERROR.PERMISSION));
    return true;
  }
}
