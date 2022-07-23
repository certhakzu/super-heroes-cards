import { Component, OnInit } from '@angular/core';
import { ServiceAuthService } from '../auth/service-auth.service';

@Component({
  selector: 'app-autencicacion-modulo',
  templateUrl: './autencicacion-modulo.component.html',
  styleUrls: ['./autencicacion-modulo.component.css']
})
export class AutencicacionModuloComponent implements OnInit {

  constructor(public authenticationService:ServiceAuthService) { }

  ngOnInit(): void {
  }

}
