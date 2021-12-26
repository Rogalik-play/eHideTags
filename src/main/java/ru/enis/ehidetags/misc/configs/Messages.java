package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;
import ru.enis.ehidetags.misc.Color;

public class Messages {
        public static String help_Cmd_Reload;
        public static String Plugin_Reloaded;
        public static String Wrong_Usage;
        public static String NoPermission;
        private Core plugin;

        public Messages(Core pluginA) {
            plugin = pluginA;
            CustomYML messages = new CustomYML("Messages", plugin);
            help_Cmd_Reload = Color.ColorFormat(messages.getConfigField("Help.Reload", "&aReloads plugin configuration"));
            Plugin_Reloaded = Color.ColorFormat(messages.getConfigField("Reload", "&aSuccessfully reloaded"));
            //Wrong_Usage = Color.ColorFormat(messages.getConfigField("Wrong-Usage", "&7Wrong usage! Please type &6/eht help&7!"));
            NoPermission = Color.ColorFormat(messages.getConfigField("NoPermission", "&cYou do not have permission for this!"));
        }
    }