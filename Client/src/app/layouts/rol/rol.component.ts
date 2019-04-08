import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { RolService } from 'app/services/rol.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rol',
  templateUrl: './rol.component.html',
  styleUrls: ['./rol.component.scss']
})
export class RolComponent implements OnInit {

  roles: any = [];
  users: any = [];
  userSelected: any = {};
  isEdit = true;
  idRol: any;
  user: any = sessionStorage.getItem('UserRol');
  view: boolean;

  constructor(private rolServices: RolService, private root: Router) {
    if (this.user === 'Administrador') {
      this.view = true;
      this.getUsers();
      this.getRol();
    } else {
      this.root.navigate(['/dashboard']);;
    }

  }

  ngOnInit() {
  }

  getUsers() {
    this.rolServices.getUsers().then(r => {
      this.users = r;
    }).catch(e => {
      console.log(e);
    });
  }

  estaSeleccionado(porVerificar): boolean {
    if (this.userSelected == null) {
      return false;
    }
    return porVerificar.idUser === this.userSelected.idUser;


  }

  onSelect(actual): void {
    this.userSelected = actual;
    if (this.userSelected !== null) {
      this.isEdit = false;
    }
  }

  refresh() {

    this.getUsers();

  }

  getRol() {
    this.rolServices.getRol().then(r => {
      this.roles = r;
    }).catch(e => {
      console.log(e);
    });
  }

  saveRol() {
    this.rolServices.changeRol(this.userSelected).then(r => {
      this.isEdit = true;
      this.refresh();
      sessionStorage.setItem('UserRol', r.userRol.descripcion);
    }).catch(e => {
      console.log(e);
    });
  }

  cancel() {
    this.isEdit = true;
  }
}
