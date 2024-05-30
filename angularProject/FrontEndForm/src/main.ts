import { bootstrapApplication } from '@angular/platform-browser';
import { AppModule } from './app/app.module';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

// bootstrapApplication(LoginComponent, appConfig)
//   .catch((err) => console.error(err));

  platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));