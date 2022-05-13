package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;

public class Config {

   public Config(Core plugin) {
      CustomYML cfg = new CustomYML("MainСonfig", plugin);
      ActionBar.enabled = cfg.getField("actionbar.enabled", true);
      ActionBar.message = cfg.getField("actionbar.message", "%player%");
   }
}

