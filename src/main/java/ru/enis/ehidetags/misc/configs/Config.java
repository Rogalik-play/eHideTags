package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;

public class Config {
   private Core plugin;

   public Config(Core pluginA) {
      plugin = pluginA;
      CustomYML config = new CustomYML("MainСonfig", plugin);
      ActionBar.enabled = config.getConfigField("actionbar.enabled", true);
      ActionBar.message = config.getConfigField("actionbar.message", "%player_displayname%");
   }
}

