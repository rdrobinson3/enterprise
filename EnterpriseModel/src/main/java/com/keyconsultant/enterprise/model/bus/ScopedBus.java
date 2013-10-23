package com.keyconsultant.enterprise.model.bus;

import com.squareup.otto.Bus;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Trey Robinson on 10/23/13.
 *
 * For objects that need to be attached to the view lifecycle use a scoped bus rather than registering
 * directly with the bus provider
 *
 */
public class ScopedBus {

    private final Bus bus = BusProvider.getInstance();
    private final Set<Object> objects = new HashSet<Object>();
    private boolean active;

    public void register(Object obj) {
        objects.add(obj);
        if (active) {
            bus.register(obj);
        }
    }

    public void unregister(Object obj) {
        objects.remove(obj);
        if (active) {
            bus.unregister(obj);
        }
    }

    public void post(Object event) {
        bus.post(event);
    }

    void paused() {
        active = false;
        for (Object obj : objects) {
            bus.unregister(obj);
        }
    }

    void resumed() {
        active = true;
        for (Object obj : objects) {
            bus.register(obj);
        }
    }
}
