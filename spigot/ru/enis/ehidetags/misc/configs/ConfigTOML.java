package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.Core;

public class ConfigTOML {

   public ConfigTOML(Core plugin) {
      CustomTOML cfg = new CustomTOML("Main Config", plugin);
      Data.ACTIONBAR.MESSAGE = cfg.getField("Actionbar.Message", "<gold>%name%",
          " Placeholders:\n" +
              " %name% - Player Name\n" +
              " %displayname% - Player Displayname");
      Data.ACTIONBAR.ENABLE = cfg.getField("Actionbar.Enabled", true);
   }

//   Serializer serializer = new Serializer(Serializers.ТВОЙ_СЕРИАЛИЗЕР.getSerializer());
//   Component message = serializer.deserialize("строка с форматированием")
}

