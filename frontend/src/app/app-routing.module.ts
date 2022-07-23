import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule, Routes } from '@angular/router';
import{AutencicacionModuloComponent}from './autencicacion-modulo/autencicacion-modulo.component';
import{RegistroComponenteComponent}from './registro-componente/registro-componente.component';


const rutas: Routes=[
  {
    path :"login",
    component: AutencicacionModuloComponent,

  },
  {
    path:"registro",
    component:RegistroComponenteComponent
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
