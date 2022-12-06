package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.Core;

public class MessagesTOML {

        public MessagesTOML(Core plugin) {
            CustomTOML msg = new CustomTOML("Messages", plugin);
            Data.MESSAGE.PREFIX = msg.getField("Prefix", " <white>|</white> <gold>eHideTags</gold> <br> <white>|</white> ");
            Data.MESSAGE.ERROR.USAGE = msg.getField("Error.Wrong Usage", "<gray>Wrong usage! Please type <gold>/eht help<gray>!");
            Data.MESSAGE.HELP.RELOAD = msg.getField("Help.Reload", "<green>/eht reload - Reloads plugin configuration");
            Data.MESSAGE.SUCCESS.RELOAD = msg.getField("Success.Reload", "<green>Config successfully reloaded</green>");
            Data.MESSAGE.ERROR.PERMISSION = msg.getField("Error.No Permission", "<red>You do not have permission for this!");
        }
    }