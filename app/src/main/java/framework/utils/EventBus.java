package framework.utils;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by Thomas.Jacob on 8/24/2016.
 */
public class EventBus {

    private static EventBus instance;

    private Bus bus = new Bus(ThreadEnforcer.MAIN);

    public static EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    public Bus getBus() {
        return bus;
    }
}
