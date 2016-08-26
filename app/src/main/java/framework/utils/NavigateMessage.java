package framework.utils;

import android.os.Bundle;

/**
 * Created by Thomas.Jacob on 8/26/2016.
 */
public class NavigateMessage {

    private final Class activityType;
    private final Bundle bundle;

    public NavigateMessage(Class activityType, Bundle bundle) {
        this.activityType = activityType;
        this.bundle = bundle;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public Class getActivityType() {
        return activityType;
    }
}
