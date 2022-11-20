package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.Core;

public class ConfigTOML {

   public ConfigTOML(Core plugin) {
      CustomTOML cfg = new CustomTOML("Main Config", plugin);
      Data.player_message = cfg.getField("Actionbar.message", "<gold>%name%",
          " Placeholders:\n" +
              " %name% - Player Name\n" +
              " %displayname% - Player Displayname");
      Data.tameable_message = cfg.getField("Actionbar.tameable-message", "<white>%name%",
          " THIS CANNOT BE DISABLED\n" +
              " This fixes bug when tameable entity do not shows their name\n" +
              " Placeholders:\n" +
              " %name% - Tameable Entity Name");
      Data.enabled = cfg.getField("Actionbar.enabled", true);
   }

//   Serializer serializer = new Serializer(Serializers.ТВОЙ_СЕРИАЛИЗЕР.getSerializer());
//   Component message = serializer.deserialize("строка с форматированием")
}

