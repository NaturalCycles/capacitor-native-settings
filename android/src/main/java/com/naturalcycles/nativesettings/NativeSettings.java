package com.naturalcycles.nativesettings;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

@NativePlugin()
public class NativeSettings extends Plugin {

    @PluginMethod()
    public void open(PluginCall call) {
        Uri packageUri = Uri.parse("package:" + getPackageName());
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri);
        startActivity(intent);
        call.success();
    }
}
