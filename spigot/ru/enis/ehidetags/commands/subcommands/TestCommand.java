package ru.enis.ehidetags.commands.subcommands;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.enis.ehidetags.events.onInteract;

import java.util.Objects;

import static ru.enis.ehidetags.Core.adventure;

public class TestCommand implements ISubCommand{
  @Override
  public Boolean execute(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @Nullable String[] args) {
    final Audience audience = adventure().sender(sender);
    if (sender instanceof Player) {
      //Отправка ЭкшнБара
      audience.sendActionBar(onInteract.returnFormated(((Player) sender).getPlayer(), ((Player) sender).getPlayer()) != null ? Objects.requireNonNull(onInteract.returnFormated(((Player) sender).getPlayer(), ((Player) sender).getPlayer())) : Component.text("null"));
      return true;
    }
    return true;
  }
}
