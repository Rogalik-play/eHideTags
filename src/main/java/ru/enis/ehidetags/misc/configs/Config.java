package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.Color;

public class Config {
   public static String message;
   private Core plugin;

   public Config(Core pluginA) {
      plugin = pluginA;
      CustomYML config = new CustomYML("MainСonfig", plugin);
      message = Color.ColorFormat(config.getConfigField("message", "%player_displayname%"));
   }
}
