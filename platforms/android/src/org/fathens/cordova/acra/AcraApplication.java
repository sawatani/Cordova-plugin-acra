package org.fathens.cordova.acra;

import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ACRAConfigurationException;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.EmailIntentSender;

import android.app.Application;
import android.util.Log;

@ReportsCrashes(formKey = "")
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
        final ReportingInteractionMode mode = ReportingInteractionMode.TOAST;
        final int toastText = getId("toast_text");
        final String url = getText("url");
        final String username = getText("username");
        final String password = getText("password");
        Log.d(TAG, String.format("Configuration Setup: MODE=%s, TOAST_TEXT=%x, PUT_URI='%s'", mode, toastText, url));
        try {
            final ACRAConfiguration config = ACRA.getNewDefaultConfig(this);
            config.setMode(mode);
            config.setResToastText(toastText);
            config.setHttpMethod(org.acra.sender.HttpSender.Method.PUT);
            config.setReportType(org.acra.sender.HttpSender.Type.JSON);
            config.setFormUri(url);
            config.setFormUriBasicAuthLogin(username);
            config.setFormUriBasicAuthPassword(password);
            ACRA.setConfig(config);
            ACRA.init(this);
        } catch (ACRAConfigurationException ex) {
            throw new RuntimeException(ex);
        }
    }
}
