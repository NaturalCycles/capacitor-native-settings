import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitor.ionicframework.com/docs/plugins/ios
 */
@objc(NativeSettings)
public class NativeSettings: CAPPlugin {
    
    @objc func open(_ call: CAPPluginCall) {
        UIApplication.shared.open(URL(string: UIApplication.openSettingsURLString)!, completionHandler: nil)
        call.success()
    }
}
