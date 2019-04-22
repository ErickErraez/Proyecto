import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { EnterateService } from 'app/services/enterate.service';
import { Enterate } from 'app/Models/Enterate';
import { EventSesrvice } from 'app/services/event.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  enterates = [];
  cumpleanos = [];
  eventos = [];
  indice = [];

  constructor(private enterateServices: EnterateService, protected eventService: EventSesrvice,
    private root: Router) {
    this.getActual();

  }

  ngOnInit() {
  }

  getActual() {
    this.enterateServices.getEnterateActual().then(r => {
      for (var i = 0; i < r.length; i++) {
        this.enterates.push(r[i]);
      }
    }).catch(e => {

    });
    this.eventService.getEnterateActual().then(response => {
      for (var j = 0; j < response.length; j++) {
        this.enterates.push(response[j]);
      }
    }).catch(error => {

    });
    console.log(this.enterates);
  }
  typeClass(i) {
    if (i == 0) {
      return true;
    }
    return false;
  }

  showEnterate(nombreArchivo, archivoAdjunto) {

    var objbuilder = '';
    objbuilder += ('<img width="600px" height="auto"  src="data:image/*;base64,');
    objbuilder += (archivoAdjunto);
    objbuilder += ('"type="image/*">');

    var win = window.open();
    var title = nombreArchivo;
    win.document.write('<html><title>' + title + '</title><body style="text-align:center;">');
    win.document.write(objbuilder);
    win.document.write('</body></html>');

  }

  irCalendario() {
this.root.navigate(['/view']);
  }

}
