package ru.enis.ehidetags.commands;

import ru.enis.ehidetags.Core;
import ru.enis.ehidetags.commands.tabcompleter.*;

public class cmdInit {
    public cmdInit(Core core) {
        new MainCMD(core);
        new TabCompleterInit(core);
    }
}
