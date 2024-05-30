// app.module.ts

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { HttpClientModule } from '@angular/common/http';

import { LoginComponent } from './login/login.component'; // Import LoginComponent
import { DashBoardComponent } from './dashboard/dash-board.component';
import { RegisterComponent } from './register/register.component';

import { ConfigService } from './service/service' 
import { RouterModule } from '@angular/router';
import { routes } from './app.routes';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule, // Import FormsModule here
    HttpClientModule,
    RouterModule.forRoot(
      routes
    )
    // Other modules you might need
  ],
  declarations: [
    LoginComponent, // Declare your LoginComponent here
    DashBoardComponent,
    RegisterComponent
  ],
  exports: [RouterModule],
  providers: [ConfigService,],
  bootstrap: [LoginComponent],
})
export class AppModule { }
