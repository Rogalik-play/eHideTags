package ru.enis.ehidetags.misc;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import ru.enis.ehidetags.Core;

public class Color {
    private static final LegacyComponentSerializer LegacySerializer = LegacyComponentSerializer.legacyAmpersand();
    private static final LegacyComponentSerializer HexSerializer = LegacySerializer.toBuilder().hexColors().useUnusualXRepeatedCharacterHexFormat().build();

    public static TextComponent ColorFormat(String translate){
        if (Core.majorMinecraftVersion() > 15) {
            return HexSerializer.deserialize(translate);
        } else {
            return LegacySerializer.deserialize(translate);

        }
    }
}
