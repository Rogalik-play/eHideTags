package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;

public class Config {
   public static String message;
   private Core plugin;

   public Config(Core pluginA) {
      plugin = pluginA;
      CustomYML config = new CustomYML("MainСonfig", plugin);
      message = config.getConfigField("message", "%player_displayname%");
   }
}
