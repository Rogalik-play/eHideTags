package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;

public class Config {

   public Config(Core plugin) {
      CustomYML cfg = new CustomYML("MainСonfig", plugin);
      ActionBar.enabled = cfg.getField("actionbar.enabled", true);
      ActionBar.player_message = cfg.getField("actionbar.message", "&6%name%",
          "Placeholders:\n%name% - Player Name\n%displayname% - Player Displayname");
      ActionBar.tameable_message = cfg.getField("actionbar.tameable-message", "&f%name%",
          "THIS CANNOT BE DISABLED\n" +
              "This fixes bug when tameable entity do not shows their name\n" +
              "Placeholders:\n" +
              "%name% - Tameable Entity Name");
   }
}

