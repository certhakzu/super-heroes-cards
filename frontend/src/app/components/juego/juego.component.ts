import { Component, OnInit } from '@angular/core';
import { TarjetasServiceService } from 'src/app/TarjetasService/tarjetas-service.service';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})
export class JuegoComponent implements OnInit {

  constructor( private tarjetasService :TarjetasServiceService) { }

  ngOnInit(): void {
  this.tarjetasService.getTarjetas().subscribe(
    res=>console.log(res),
    err=>console.log(err)
  )
  }

}
