package framework.utils;

/**
 * Created by Thomas.Jacob on 8/26/2016.
 */
public class NavigateMessage {

    private final Class activityType;
    private final String navigationData;

    public NavigateMessage(Class activityType, String navigationData) {
        this.activityType = activityType;
        this.navigationData = navigationData;
    }

    public Class getActivityType() {
        return activityType;
    }

    public String getNavigationData() {
        return navigationData;
    }
}
