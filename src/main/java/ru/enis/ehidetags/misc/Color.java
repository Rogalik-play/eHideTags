package ru.enis.ehidetags.misc;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import ru.enis.ehidetags.Core;

public class Color {
    private static final LegacyComponentSerializer HexSerializer = LegacyComponentSerializer.builder().hexColors().useUnusualXRepeatedCharacterHexFormat().build();

    public static TextComponent ColorFormat(String translate){
        if (Core.majorMinecraftVersion() > 15) {
            return HexSerializer.deserialize(translate);
        } else {
            return LegacyComponentSerializer.legacyAmpersand().deserialize(translate);
        }
    }
    /*
     * Здесь будет поддержка HEX цветов
     */
}
