import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;

import android.app.Application;

@ReportsCrashes(formKey = "")
public class MyApplication extends Application {

    @Override
    public void onCreate() {
	super.onCreate();

	// The following line triggers the initialization of ACRA
	ACRA.init(this);
    }
}
