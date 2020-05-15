package com.naturalcycles.nativesettings

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.getcapacitor.NativePlugin
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod

@NativePlugin
class NativeSettings : Plugin() {
    @PluginMethod
    fun open(call: PluginCall) {
        val packageUri = Uri.parse("package:" + context.packageName)
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri)
        context.startActivity(intent)
        call.success()
    }
}