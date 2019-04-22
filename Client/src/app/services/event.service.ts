import { Inject, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { } from 'rxjs';
import { Eventos } from 'app/Models/Events';
import { Http } from '@angular/http';
import { environment } from 'environments/environment';
@Injectable()
export class EventSesrvice {

    data: any;

    constructor(private http: Http) {
    }

    getEvents() {
     return this.http.get(environment.url + 'event/getEvents').toPromise().then(e => {
            this.data = e.json();
            return this.data;
        })
    }

    getEnterateActual() {
        return this.http.get(environment.url + 'event/getActual').toPromise().then(r => {
          return r.json();
        }).catch(e => {
          return e.body;
        });
      }

    saveEvents(evento){
        return this.http.post(environment.url + 'event/saveEvent' , evento).toPromise().then(e => {
            this.data = e.json();
            return this.data;
        })
    }

    updateEvents(evento){
        return this.http.put(environment.url + 'event/updateEvent/' +evento.idEvent , evento).toPromise().then(e => {
            this.data = e.json();
            return this.data;
        })
    }
}
