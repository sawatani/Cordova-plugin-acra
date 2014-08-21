package org.fathens.cordova.acra;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.EmailIntentSender;

import android.app.Application;

@ReportsCrashes(formKey = "",
	mailTo = "",
	mode = ReportingInteractionMode.TOAST,
	resToastText = R.string.acra_toast_text)
public class AcraApplication extends Application {

    @Override
    public void onCreate() {
	super.onCreate();

	// The following line triggers the initialization of ACRA
	ACRA.init(this);
	ACRA.getConfig().setMailTo(getResources().getString(R.string.acra_mailto));
	ACRA.getErrorReporter().setReportSender(new EmailIntentSender(getApplicationContext()));
    }
}
