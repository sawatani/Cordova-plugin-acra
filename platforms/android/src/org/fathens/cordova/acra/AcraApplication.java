package org.fathens.cordova.acra;

import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ACRAConfigurationException;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import android.app.Application;
import android.util.Log;

@ReportsCrashes(
        mode = ReportingInteractionMode.TOAST,
        httpMethod = org.acra.sender.HttpSender.Method.PUT,
        reportType = org.acra.sender.HttpSender.Type.JSON,
        formKey = "")
public class AcraApplication extends Application {
    static final String TAG = "ACRA_Application";

    private int getId(String name) {
        return getResources().getIdentifier("acra_" + name, "string", getPackageName());
    }

    private String getText(String name) {
        return getResources().getString(getId(name));
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialization of ACRA
        final int toastText = getId("toast_text");
        final String url = getText("url");
        final String username = getText("username");
        final String password = getText("password");
        Log.d(TAG, String.format("Configuration Setup: PUT_URI='%s'", url));
        final ACRAConfiguration config = ACRA.getNewDefaultConfig(this);
        config.setResToastText(toastText);
        config.setFormUri(url);
        config.setFormUriBasicAuthLogin(username);
        config.setFormUriBasicAuthPassword(password);
        ACRA.setConfig(config);
        ACRA.init(this);
    }
}
