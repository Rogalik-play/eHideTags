package ru.enis.ehidetags.misc;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Color {
    public static Component deserialize(String input) {
        return MiniMessage.miniMessage().deserialize(input);
    }
}
