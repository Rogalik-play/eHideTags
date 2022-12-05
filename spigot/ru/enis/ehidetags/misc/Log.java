package ru.enis.ehidetags.misc;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Log {

    private static Logger log;

    public Log(JavaPlugin jp) {
        log = jp.getLogger();
    }

    public void info(String info) {
        log.info(info);
    }

    public void warn(String warn) {
        log.warning(warn);
    }

    public void error(String error) {
        log.severe(error);
    }

}
