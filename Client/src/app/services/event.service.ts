import { Inject, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {  } from 'rxjs';
@Injectable()
export class EventSesrvice {
    public getEvents(fecharecibida,fechasalida,titulo): Observable<any> {
        
        const dateObj = new Date();
        const yearMonth = dateObj.getUTCFullYear() + '-' + (dateObj.getUTCMonth() + 1);
        let data: any = [
        {
            title: titulo,
            start: fecharecibida,
            end: fechasalida
        },
       
        {
            title: 'Click for Google',
            url: 'http://google.com/',
            start: yearMonth + '-28'
        }];
        return of(data);
    }
}
