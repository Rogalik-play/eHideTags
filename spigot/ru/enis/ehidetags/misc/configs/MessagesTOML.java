package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.Core;

public class MessagesTOML {

        public MessagesTOML(Core plugin) {
            CustomTOML msg = new CustomTOML("Messages", plugin);
            DATA.MESSAGE.PREFIX = msg.getField("Prefix", " <white>|</white> <gold>eHideTags</gold> <br> <white>|</white> ");
            DATA.MESSAGE.ERROR.USAGE = msg.getField("Error.Wrong Usage", "<gray>Wrong usage! Please type <gold>/eht help<gray>!");
            DATA.MESSAGE.HELP.RELOAD = msg.getField("Help.Reload", "<green>/eht reload - Reloads plugin configuration");
            DATA.MESSAGE.SUCCESS.RELOAD = msg.getField("Success.Reload", "<green>Config successfully reloaded</green>");
            DATA.MESSAGE.ERROR.PERMISSION = msg.getField("Error.No Permission", "<red>You do not have permission for this!");
        }
    }