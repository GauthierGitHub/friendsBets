import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

// https://stackoverflow.com/questions/60183056/ionic-5-with-angular-9-angular-jit-compilation-failed-angular-compiler-not
// import '@angular/compiler'

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
