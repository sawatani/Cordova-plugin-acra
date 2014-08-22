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

    @Override
    public void onCreate() {
	super.onCreate();

	// Initialization of ACRA
	final ReportingInteractionMode mode = ReportingInteractionMode.TOAST;
	final int toastText = getResources().getIdentifier("acra_toast_text", "string", getPackageName());
	final String mailTo = getResources().getString(
		getResources().getIdentifier("acra_mail_to", "string", getPackageName()));
	Log.d(TAG, String.format("Configuration Setup: MODE=%s, TOAST_TEXT=%x, MAIL_TO='%s'", mode, toastText, mailTo));
	try {
	    final ACRAConfiguration config = ACRA.getNewDefaultConfig(this);
	    config.setMode(mode);
	    config.setResToastText(toastText);
	    config.setMailTo(mailTo);
	    ACRA.setConfig(config);
	    ACRA.init(this);
	    ACRA.getErrorReporter().setReportSender(new EmailIntentSender(getApplicationContext()));
	} catch (ACRAConfigurationException ex) {
	    throw new RuntimeException(ex);
	}
    }
}
