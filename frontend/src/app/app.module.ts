import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'

import { AppComponent } from './app.component';
import { AutencicacionModuloComponent } from './autencicacion-modulo/autencicacion-modulo.component';
import { RegistroComponenteComponent } from './registro-componente/registro-componente.component';
import { AppRoutingModule } from './app-routing.module';
import { AngularFireModule } from '@angular/fire/compat';
import{environment}from '../environments/environment';
import { AngularFireAuthModule } from '@angular/fire/compat/auth';
import { AngularFirestoreModule } from '@angular/fire/compat/firestore';
import { NavegacionComponent } from './navegacion/navegacion.component';
import { TarjetasListComponent } from './components/tarjetas-list/tarjetas-list.component';
import { JugadorListComponent } from './components/jugador-list/jugador-list.component';
import { JuegoComponent } from './components/juego/juego.component';
import { TarjetasServiceService } from './TarjetasService/tarjetas-service.service';
import{JugadoresServiceService }  from './JugadoresService/jugadores-service.service';
import { DashboardComponent } from './components/dashboard/dashboard.component'



@NgModule({
  declarations: [
    AppComponent,
    AutencicacionModuloComponent,
    RegistroComponenteComponent,
    NavegacionComponent,
    TarjetasListComponent,
    JugadorListComponent,
    JuegoComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireAuthModule ,
    AngularFirestoreModule,
    HttpClientModule
  ],
  providers: [
    TarjetasServiceService,
    JugadoresServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
