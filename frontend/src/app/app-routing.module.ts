import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule, Routes } from '@angular/router';
import{AutencicacionModuloComponent}from './autencicacion-modulo/autencicacion-modulo.component';
import{RegistroComponenteComponent}from './registro-componente/registro-componente.component';
import { JuegoComponent } from './components/juego/juego.component';

const rutas: Routes=[
  {
    path:'',
    redirectTo:'/login',
    pathMatch:'full'
  },
  {
    path :"login",
    component: AutencicacionModuloComponent,

  },
  {
    path:"registro",
    component:RegistroComponenteComponent
  },
  {
    path:"juego",
    component: JuegoComponent
  }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(rutas)
  ],
  exports:[
    RouterModule
  ]
})
export class AppRoutingModule { }
