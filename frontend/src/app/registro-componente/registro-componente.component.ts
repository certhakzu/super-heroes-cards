import { Component, OnInit } from '@angular/core';
import { ServiceAuthService } from '../auth/service-auth.service';

@Component({
  selector: 'app-registro-componente',
  templateUrl: './registro-componente.component.html',
  styleUrls: ['./registro-componente.component.css']
})
export class RegistroComponenteComponent implements OnInit {

  constructor(public authenticationService: ServiceAuthService) { }

  ngOnInit(): void {
  }

}
