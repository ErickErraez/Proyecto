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
