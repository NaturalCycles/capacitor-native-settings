import { WebPlugin } from '@capacitor/core';
import { NativeSettingsPlugin } from './definitions';

export class NativeSettingsWeb extends WebPlugin implements NativeSettingsPlugin {
  constructor() {
    super({
      name: 'NativeSettings',
      platforms: ['web']
    });
  }

  open(): void {}
}

const NativeSettings = new NativeSettingsWeb();

export { NativeSettings };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(NativeSettings);
