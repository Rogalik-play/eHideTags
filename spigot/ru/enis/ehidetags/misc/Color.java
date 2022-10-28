package ru.enis.ehidetags.misc;

import net.elytrium.java.commons.mc.serialization.Serializer;
import net.elytrium.java.commons.mc.serialization.Serializers;
import net.kyori.adventure.text.Component;
import ru.enis.ehidetags.misc.configs.Data;

public class Color {
//    private static final LegacyComponentSerializer LegacySerializer = LegacyComponentSerializer.legacyAmpersand();
//    private static final LegacyComponentSerializer HexSerializer = LegacySerializer.toBuilder().hexColors().useUnusualXRepeatedCharacterHexFormat().build();

    public static Component colorize(String translate){
        return Data.serializer.deserialize(translate);
    }
    public static Component defaultColorize(String translate){
        return new Serializer(Serializers.LEGACY_AMPERSAND.getSerializer()).deserialize(translate);
    }
}

//    Serializer serializer = new Serializer(Serializers.ТВОЙ_СЕРИАЛИЗЕР.getSerializer());
//    Component message = serializer.deserialize("строка с форматированием")
