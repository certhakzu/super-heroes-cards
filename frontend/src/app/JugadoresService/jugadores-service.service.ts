import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import  {Jugador} from '../models/Jugadores'
@Injectable({
  providedIn: 'root'
})
export class JugadoresServiceService {
  API_URI='http://localhost:3000/api';

  constructor(private http: HttpClient) { }

  getJugadores(){
    return this.http.get(`${this.API_URI}/listarjugadores`);

  }
  getJugador(id:string){
    return this.http.get(`${this.API_URI}/jugador/${id}`);

  }

  deleteJugador(id:string){
    return this.http.delete(`${this.API_URI}/jugador/${id}`);


  }
  
  savejugador(jugador:Jugador){
    return this.http.post(`${this.API_URI}/jugador/crear`,jugador);

  }
  updateJugador(id: string|number,updatedJugador:Jugador) {
    return this.http.put(`${this.API_URI}/jugador/${id}`,updatedJugador);

  }
}
