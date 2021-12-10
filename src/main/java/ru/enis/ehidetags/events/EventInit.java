package ru.enis.ehidetags.events;

import ru.enis.ehidetags.Core;

public class EventInit {

    public EventInit(Core core) {
        new onJoin(core);
        new onInteract(core);
    }
}
