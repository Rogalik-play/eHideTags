package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.Core;

public class ConfigTOML {

   public ConfigTOML(Core plugin) {
      CustomTOML cfg = new CustomTOML("Main Config", plugin);
      DATA.ACTIONBAR.MESSAGE = cfg.getField("Display Types.Actionbar.Message", "<gold>%name%",
          " Placeholders:\n" +
              " %name% - Player Name\n" +
              " %displayname% - Player Displayname");
      DATA.ACTIONBAR.ENABLE = cfg.getField("Display Types.Actionbar.Enabled", true);
   }

//   Serializer serializer = new Serializer(Serializers.ТВОЙ_СЕРИАЛИЗЕР.getSerializer());
//   Component message = serializer.deserialize("строка с форматированием")
}

