package ru.enis.ehidetags.misc;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import ru.enis.ehidetags.Core;

public class Color {
    private static final LegacyComponentSerializer HexSerializer = LegacyComponentSerializer.builder().hexColors().useUnusualXRepeatedCharacterHexFormat().build();
    private static final LegacyComponentSerializer AmpersandSerializer = LegacyComponentSerializer.builder().character('&').build();

    public static TextComponent ColorFormat(String translate){
        if (Core.majorMinecraftVersion() > 15) {
            return HexSerializer.deserialize(translate);
        } else {
            return AmpersandSerializer.deserialize(translate);

        }
    }
    /*
     * Здесь будет поддержка HEX цветов
     */
}
