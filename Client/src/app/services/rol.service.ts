import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class RolService {

  users: any = [];
  url = environment.url + 'user/';

  constructor(private http: Http) {

  }

  getUsers() {
    return this.http.get(this.url + 'getUsers').toPromise().then(r => {
      return r.json();
    }).catch(e => {
      return e.body;
    });;

  }

  getRol() {
    return this.http.get(environment.url + 'userRol' + '/getRol').toPromise().then(r => {
      return r.json();
    }).catch(e => {
      return e.body;
    });;
  }

  changeRol(userRol) {
    return this.http.put(this.url + 'userChangeRol', userRol).toPromise().then(r => {
      return r.json();
    }).catch(e => {
      return e.body;
    });;
  }

}
