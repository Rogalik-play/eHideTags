package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;

public class Messages {
        public static String help_Cmd_Reload, Config_Reloaded, Wrong_Usage, NoPermission, Plugin_Prefix;

        public Messages(Core plugin) {
            CustomYML msg = new CustomYML("Messages", plugin);
            help_Cmd_Reload = msg.getField("Help.Reload", "&aReloads plugin configuration");
            Config_Reloaded = msg.getField("Reload", "&aConfig successfully reloaded");
            Wrong_Usage = msg.getField("Wrong-Usage", "&7Wrong usage! Please type &6/eht help&7!");
            NoPermission = msg.getField("NoPermission", "&cYou do not have permission for this!");
            Plugin_Prefix = msg.getField("Prefix", "§6eHideTags");
        }
    }