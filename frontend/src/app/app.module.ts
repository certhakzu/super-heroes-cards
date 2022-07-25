import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AutencicacionModuloComponent } from './autencicacion-modulo/autencicacion-modulo.component';
import { RegistroComponenteComponent } from './registro-componente/registro-componente.component';
import { AppRoutingModule } from './app-routing.module';
import { AngularFireModule } from '@angular/fire/compat';
import{environment}from '../environments/environment';
import { AngularFireAuthModule } from '@angular/fire/compat/auth';
import { AngularFirestoreModule } from '@angular/fire/compat/firestore';
import { NavegacionComponent } from './navegacion/navegacion.component';



@NgModule({
  declarations: [
    AppComponent,
    AutencicacionModuloComponent,
    RegistroComponenteComponent,
    NavegacionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireAuthModule ,
    AngularFirestoreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
