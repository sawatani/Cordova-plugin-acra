package org.fathens.cordova.acra;

import org.acra.ACRA;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;

import android.util.Log;

public class Reporter extends CordovaPlugin {
    static final String TAG = "ACRA_Application";

    @Override
    public void initialize(final CordovaInterface cordova, final CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "Initialized");
    }

    @Override
    public boolean execute(final String action, final CordovaArgs args, final CallbackContext callback) throws JSONException {
        final String msg = args.optString(0);
        final Exception e = new RuntimeException(msg);
        if (action.equals("handleSilentException")) {
            ACRA.getErrorReporter().handleSilentException(e);
            return true;
        } else if (action.equals("handleException")) {
            ACRA.getErrorReporter().handleException(e);
            return true;
        } else {
            return false;
        }
    }
}
