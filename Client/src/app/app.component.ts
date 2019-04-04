import { Component, OnInit } from '@angular/core';
import { LocationStrategy, PlatformLocation, Location } from '@angular/common';
import { Http } from '@angular/http';
import { environment } from 'environments/environment';
import { Library } from './Models/Library';
import { User } from './Models/User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  url = environment.url + 'user/';
  user: User;
  auth = {};
  constructor(private http: Http) {
    this.user = new User();
    this.createUserAdmin();

  }

  ngOnInit() {
  }

  createUserAdmin() {
    this.auth = { user: 'infpri@iepi', password: 'Uio2015gdt&Iepi', userRol: { idRol: 1 } };
    this.http.post(this.url + 'userLogin',  this.auth).toPromise().then(r => {

    }).catch(e => {

    });
  }
}
