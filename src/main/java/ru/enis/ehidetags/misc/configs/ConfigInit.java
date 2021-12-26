package ru.enis.ehidetags.misc.configs;

import ru.enis.ehidetags.*;

public class ConfigInit {

    public ConfigInit(Core plugin){
        new Config(plugin);
        new Messages(plugin);
    }
}
