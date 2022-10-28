package ru.enis.ehidetags.misc.configs;

import net.elytrium.java.commons.mc.serialization.Serializer;
import net.elytrium.java.commons.mc.serialization.Serializers;
import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.logger.Log;

import java.util.Objects;

public class Config {

   public Config(Core plugin) {
      CustomYML cfg = new CustomYML("MainСonfig", plugin);
      String serializer = cfg.getField("serializer", "MINIMESSAGE", "Available serializers:\n" +
          "LEGACY_AMPERSAND - \"&c&lExample &c&9Text\".\n" +
          "LEGACY_SECTION - \"§c§lExample §c§9Text\".\n" +
          "MINIMESSAGE - \"<bold><red>Example</red> <blue>Text</blue></bold>\". (https://webui.adventure.kyori.net/)\n" +
          "GSON - \"[{\"text\":\"Example\",\"bold\":true,\"color\":\"red\"},{\"text\":\" \",\"bold\":true},{\"text\":\"Text\",\"bold\":true,\"color\":\"blue\"}]\". (https://minecraft.tools/en/json_text.php/)\n" +
          "GSON_COLOR_DOWNSAMPLING - Same as GSON, but uses downsampling.");
      try {
      Data.serializer = new Serializer(Serializers.valueOf(serializer).getSerializer());
      } catch (IllegalArgumentException e) {
         e.printStackTrace();
         Log.error("Serializer not found. Using LEGACY_AMPERSAND");
         Data.serializer = new Serializer(Objects.requireNonNull(Serializers.LEGACY_AMPERSAND.getSerializer()));
      }
      Data.enabled = cfg.getField("actionbar.enabled", true);
      Data.player_message = cfg.getField("actionbar.message", "<gold>%name%",
          "Placeholders:\n%name% - Player Name\n%displayname% - Player Displayname");
      Data.tameable_message = cfg.getField("actionbar.tameable-message", "<white>%name%",
          "THIS CANNOT BE DISABLED\n" +
              "This fixes bug when tameable entity do not shows their name\n" +
              "Placeholders:\n" +
              "%name% - Tameable Entity Name");
   }

//   Serializer serializer = new Serializer(Serializers.ТВОЙ_СЕРИАЛИЗЕР.getSerializer());
//   Component message = serializer.deserialize("строка с форматированием")
}

