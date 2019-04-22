import { Component, OnInit, ViewChild, ɵConsole } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';
import { CalendarComponent } from 'ng-fullcalendar';
import { Options } from 'fullcalendar';
import { DomSanitizer } from '@angular/platform-browser';
import { Adjunto } from 'app/Models/Adjunto';
import { environment } from 'environments/environment';
import { EventSesrvice } from 'app/services/event.service';
import { Eventos } from 'app/Models/Events';
import { type } from 'os';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-view-app',
  templateUrl: './view-app.component.html',
  styleUrls: ['./view-app.component.scss']
})
export class ViewAppComponent implements OnInit {
  calendarOptions: Options;
  displayEvent: any;
  isNewEvent = false;
  evento: Eventos;
  updateEvent: any;
  userRol = sessionStorage.getItem('UserRol');
  events = null;
  @ViewChild(CalendarComponent) ucCalendar: CalendarComponent;
  constructor(protected eventService: EventSesrvice, private toastr: ToastrService) {

    this.calendarOptions = {
      editable: true,
      eventLimit: true,
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,listMonth'
      },
      events: []
    };
    this.evento = new Eventos();
  }
  ngOnInit() {
    this.loadevents();
  }
  loadevents() {
    this.eventService.getEvents().then(data => {
      this.events = data;
    });

  }
  saveEvent() {
    if (this.evento.tipo === 'cumpleanos') {
      this.evento.backgroundColor = 'rgba(248,80,50,1)';
    }
    if (this.evento.tipo === 'evento') {
      this.evento.backgroundColor = 'rgba(72,156,234,1)';
    }
    if (this.evento.idEvent == undefined) {

      this.evento.start = this.evento.start + ' 00:00:00'
      this.evento.end = this.evento.end + ' 23:00:00';
      this.eventService.saveEvents(this.evento).then(data => {
        this.guardado();
      }).catch(e => {
        this.toastr.error('Intentalo de nuevo!', 'Oops algo ha salido mal!');
      });
    } else {

      if (this.updateEvent.event.start._i !== this.evento.start || this.updateEvent.event.end._i !== this.evento.end) {
        this.evento.start = this.evento.start + ' 00:00:00'
        this.evento.end = this.evento.end + ' 23:00:00';
      }
      this.eventService.updateEvents(this.evento).then(event => {
        this.guardado();
      }).catch(r => {
        this.toastr.error('Intentalo de nuevo!', 'Oops algo ha salido mal!');
      });
    }

  }

  isNewSaveEvent() {
    this.isNewEvent = true;
  }

  checkRol() {
    if (this.userRol == 'Administrador' || this.userRol == 'Escritura') {
      return true;
    } else {
      return false;
    }
  }

  cancel() {
    this.evento = new Eventos();
    this.isNewEvent = false;
  }

  eventClick(model: any) {
    this.updateEvent = model;
    this.isNewEvent = true;
    this.evento.start = model.event.start._i;
    this.evento.end = model.event.end._i;
    this.evento.title = model.event.title;
    this.evento.idEvent = model.event.idEvent;
  }

  guardado() {
    this.toastr.success(' Se han guardado con exito!', 'Todos los Datos!');
    this.cancel();
    this.loadevents();
  }

}
