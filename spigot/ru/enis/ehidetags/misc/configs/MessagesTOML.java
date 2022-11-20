package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;

public class MessagesTOML {
        public static String Reload_Help, Config_Reloaded, Wrong_Usage, NoPermission, Plugin_Prefix;

        public MessagesTOML(Core plugin) {
            CustomTOML msg = new CustomTOML("Messages", plugin);
            Plugin_Prefix = msg.getField("Prefix", " <white>|</white> <gold>eHideTags</gold> <br> <white>|</white> ");
            Wrong_Usage = msg.getField("Wrong-Usage", "<gray>Wrong usage! Please type <gold>/eht help<gray>!");
            NoPermission = msg.getField("NoPermission", "<red>You do not have permission for this!");
            Reload_Help = msg.getField("Help.Reload", "<green>/eht reload - Reloads plugin configuration");
            Config_Reloaded = msg.getField("Reload", "<green>Config successfully reloaded</green>");
        }
    }