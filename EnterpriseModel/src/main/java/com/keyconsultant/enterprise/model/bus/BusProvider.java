package com.keyconsultant.enterprise.model.bus;

import com.squareup.otto.Bus;

/**
 * Created by Trey Robinson on 10/23/13.
 *
 * Basic bus provider singleton. Provides the instance of the bus used by the majority of the
 * application. Additional buses can be created for other uses.
 *
 */
public class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // No instances.
    }
}
