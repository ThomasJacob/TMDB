package framework.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by thomas on 7/31/2016.
 */
public class ApplicationBase extends Application {

    private static ApplicationBase app;

    public ApplicationBase() {
        app = this;
    }

    public static Context getAppContext() {
        return app.getApplicationContext();
    }
}
