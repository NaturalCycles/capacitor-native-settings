declare module "@capacitor/core" {
  interface PluginRegistry {
    NativeSettings: NativeSettingsPlugin;
  }
}

export interface NativeSettingsPlugin {
  open(): void;
}
