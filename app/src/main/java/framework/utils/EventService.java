package framework.utils;

import android.os.Bundle;

import com.google.common.eventbus.EventBus;

/**
 * Created by Thomas.Jacob on 8/24/2016.
 */
public class EventService {

    private static EventService instance;

    private EventBus bus = new EventBus();

    public static EventService getInstance() {
        if (instance == null) {
            instance = new EventService();
        }
        return instance;
    }

    public EventBus getBus() {
        return bus;
    }

    public void navigate(Class activityType, Bundle bundle) {
        getBus().post(new NavigateMessage(activityType, bundle));
    }
}
