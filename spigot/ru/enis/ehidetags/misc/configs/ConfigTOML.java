package ru.enis.ehidetags.misc.configs;

import net.elytrium.java.commons.mc.serialization.Serializer;
import net.elytrium.java.commons.mc.serialization.Serializers;
import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.misc.logger.Log;

import java.util.Objects;

public class ConfigTOML {

   public ConfigTOML(Core plugin) {
      CustomTOML cfg = new CustomTOML("Main Config", plugin);
      Data.player_message = cfg.getField("Actionbar.message", "<gold>%name%",
          """
               Placeholders:
               %name% - Player Name
               %displayname% - Player Displayname""".indent(1));

      Data.tameable_message = cfg.getField("Actionbar.tameable-message", "<white>%name%",
          """
               THIS CANNOT BE DISABLED
               This fixes bug when tameable entity do not shows their name
               Placeholders:
               %name% - Tameable Entity Name""".indent(1));

      Data.enabled = cfg.getField("Actionbar.enabled", true);
   }

//   Serializer serializer = new Serializer(Serializers.ТВОЙ_СЕРИАЛИЗЕР.getSerializer());
//   Component message = serializer.deserialize("строка с форматированием")
}

