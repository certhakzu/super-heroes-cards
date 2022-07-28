import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import  {Tarjeta} from '../models/Tarjetas'

@Injectable({
  providedIn: 'root'
})
export class TarjetasServiceService {
  //API_URI='http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getTarjetas(){
    return this.http.get(`api/listartarjetas`);

  }
  getTarjeta(id:string){
    return this.http.get(`api/tarjeta/${id}`);

  }

  deleteTarjeta(id:string){
    return this.http.delete(`api/tarjetas/${id}`);


  }

  saveTarjeta(tarjeta:Tarjeta){
    return this.http.post(`api/tarjeta`,tarjeta);

  }
  updateTarjeta(id: string|number,updateTarjeta:Tarjeta) {
    return this.http.put(`api/Tarjetas/${id}`,updateTarjeta);

  }


}
