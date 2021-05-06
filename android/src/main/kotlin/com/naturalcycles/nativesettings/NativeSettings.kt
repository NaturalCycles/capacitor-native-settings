package com.naturalcycles.nativesettings

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.getcapacitor.*

private const val REQUEST_ENABLE_BLUETOOTH = 123

@NativePlugin
class NativeSettings : Plugin() {
  @PluginMethod
  fun open(call: PluginCall) {
    val packageUri = Uri.parse("package:" + context.packageName)
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri)
    context.startActivity(intent)
    call.success()
  }

  @PluginMethod
  fun openNotificationSettings(call: PluginCall) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
      val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
              .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
              .putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)

      context.startActivity(intent)
      call.success()
    } else {
      open(call)
    }
  }

  @PluginMethod
  fun enableBluetooth(call: PluginCall) {
    val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    activity.startActivityForResult(intent, REQUEST_ENABLE_BLUETOOTH)

    call.success()
  }

  fun openInAppSettings() {
    notifyListeners("openInAppSettings", JSObject(), true)
  }
}
