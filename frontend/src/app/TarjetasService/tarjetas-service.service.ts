import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import  {Tarjeta} from '../models/Tarjetas'

@Injectable({
  providedIn: 'root'
})
export class TarjetasServiceService {
  API_URI='http://localhost:3000/api';

  constructor(private http: HttpClient) { }

  getTarjetas(){
    return this.http.get(`${this.API_URI}/tarjetas`);

  }
  getTarjeta(id:string){
    return this.http.get(`${this.API_URI}/tarjeta/${id}`);

  }

  deleteTarjeta(id:string){
    return this.http.delete(`${this.API_URI}/tarjetas/${id}`);


  }
  
  saveTarjeta(tarjeta:Tarjeta){
    return this.http.post(`${this.API_URI}/tarjeta`,tarjeta);

  }
  updateTarjeta(id: string|number,updateTarjeta:Tarjeta) {
    return this.http.put(`${this.API_URI}/Tarjetas/${id}`,updateTarjeta);

  }


}
