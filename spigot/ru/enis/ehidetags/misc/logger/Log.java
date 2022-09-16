package ru.enis.ehidetags.misc.logger;

import ru.enis.ehidetags.Core;

import java.util.logging.Logger;

public class Log {

    private static Logger log;

    public static void init() {
        log = Core.getInstance().getLogger();
    }

    public static void info(String info) {
        log.info(info);
    }

    public static void warn(String warn) {
        log.warning(warn);
    }

    public static void error(String error) {
        log.severe(error);
    }

}
