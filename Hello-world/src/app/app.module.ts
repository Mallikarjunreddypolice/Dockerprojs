import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AppHelloWorldComponent } from './app-hello-world/app-hello-world.component';


@NgModule({
  declarations: [
    AppComponent,
    AppHelloWorldComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
