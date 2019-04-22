import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class EnterateService {

  constructor(private http: Http) {

  }

  getEnterates() {
    return this.http.get(environment.url + 'enterates/getEnterates').toPromise().then(r => {
      return r.json();
    }).catch(e => {
      return e.body;
    });
  }

  saveEnterates(enterate) {
    return this.http.post(environment.url + 'enterates/saveEnterates', enterate).toPromise().then(r => {
      return r.json();
    }).catch(e => {
      return e.body;
    });
  }

  assignImage(image) {
    return this.http.put(environment.url + 'enterates/adjs', image).toPromise().then(r => {
      return r.json();
    }).catch(e => {
      return e.body;
    });
  }

  getEnterateActual() {
    return this.http.get(environment.url + 'enterates/getActual').toPromise().then(r => {
      return r.json();
    }).catch(e => {
      return e.body;
    });
  }

  getLastId() {
    return this.http.get(environment.url + 'enterates/getLastId').toPromise().then(r => {
      return r.json();
    }).catch(e => {
      return e.body;
    });
  }

}
