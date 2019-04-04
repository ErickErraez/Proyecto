import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';
import { CalendarComponent } from 'ng-fullcalendar';
import { Options } from 'fullcalendar';
import { DomSanitizer } from '@angular/platform-browser';
import { Adjunto } from 'app/Models/Adjunto';
import { environment } from 'environments/environment';
import { EventSesrvice } from 'app/services/event.service';

@Component({
  selector: 'app-view-app',
  templateUrl: './view-app.component.html',
  styleUrls: ['./view-app.component.scss']
})
export class ViewAppComponent implements OnInit {
  calendarOptions: Options;
  displayEvent: any;
  prueba:any;
  salida:any;
  titulo:any;
  events = [];
  @ViewChild(CalendarComponent) ucCalendar: CalendarComponent;
  constructor(protected eventService: EventSesrvice) {
  }
  ngOnInit() {
    this.calendarOptions = {
      editable: true,
      eventLimit: false,
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,listMonth'
      },
      events: []
    };
  }
  loadevents() {
    console.log();
    this.eventService.getEvents(this.prueba,this.salida,this.titulo).subscribe(data => {
      this.events = data;
    });
  }
  clickButton(model: any) {
    this.displayEvent = model;
  }
  dayClick(model: any) {
    console.log(model);
  }
  eventClick(model: any) {
    model = {
      event: {
        id: model.event.id,
        start: model.event.start,
        end: model.event.end,
        title: model.event.title,
        allDay: model.event.allDay
        // other params
      },
      duration: {}
    }
    this.displayEvent = model;
  }
  updateEvent(model: any) {
    model = {
      event: {
        id: model.event.id,
        start: model.event.start,
        end: model.event.end,
        title: model.event.title
        // other params
      },
      duration: {
        _data: model.duration._data
      }
    }
    this.displayEvent = model;
  }

}
