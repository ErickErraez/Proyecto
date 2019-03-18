import { Component, OnInit, ViewChild } from '@angular/core';
import { LocationStrategy, PlatformLocation, Location } from '@angular/common';
import { Adjunto } from 'app/Models/Adjunto';
import { Http } from '@angular/http';
import { environment } from 'environments/environment';
import { Aplicacion } from 'app/Models/Aplicacion';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  app: Aplicacion;
  adj: Adjunto;
  appInternas = [];
  appExternas = [];
  isNewApp = false;
  adjs: any = [];
  apps: any = [];
  appImage = {};

  attached: Adjunto;
  srcFoto = 'assets/img/iepi.png';
  @ViewChild('fileInput') fileInput;

  constructor(private modalService: NgbModal, private http: Http, private toastr: ToastrService) {
    this.app = new Aplicacion();
    this.adj = new Adjunto();
    this.attached = new Adjunto();
    this.getData();
  }

  ngOnInit() {

  }

  CodificarArchivo(event) {
    const reader = new FileReader();
    if (event.target.files && event.target.files.length > 0) {
      const file = event.target.files[0];
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.attached.nombreArchivo = file.name;
        this.attached.tipoArchivo = file.type;
        this.attached.adjuntoArchivo = reader.result.toString().split(',')[1];
        this.srcFoto = 'data:' + this.attached.tipoArchivo + ';base64,' + this.attached.adjuntoArchivo;
      };
    }
  }

  saveApps() {
    if (this.srcFoto == "assets/img/iepi.png") {
      this.toastr.error('Debe cambiar la imagen!', 'Oops algo ha salido mal!');
    }
    if (this.app.nombre === undefined || this.app.tipo === undefined || this.app.link === undefined || this.app.tipo  === 'Seleccione') {
      this.toastr.error('Debes completar todos los campos!', 'Oops algo ha salido mal!');
    } else {
      this.http.post(environment.url + 'adjunto/saveAdjs', this.attached).toPromise().then(image => {
        this.http.post(environment.url + 'aplications/saveApp', this.app).toPromise().then(app => {
          this.appImage = {
            idApp: app.json().idApp, adjunto: { idAdj: image.json().idAdj }
          }
          this.http.put(environment.url + 'aplications/apps/adjs', this.appImage).toPromise().then(res => {
            this.toastr.success('La Aplicacion!', 'Se ha guardado con exito!');
            this.appExternas = [];
            this.appInternas = [];
            this.getData();
            this.Cancelar();
          }).catch(err => {
            console.log(err.json());
          });
        }).catch(errorA => {

        });
      }).catch(errorI => {
        console.log();
      });

    }
  }

  Cancelar() {
    this.isNewApp = false;
    if (this.app.nombre !== undefined || this.app.tipo !== undefined || this.app.link !== undefined || this.srcFoto !== "assets/img/iepi.png") {
      this.app.nombre = "";
      this.app.link = "";
      this.app.tipo = "Seleccione";
      this.srcFoto = "assets/img/iepi.png";
    }
  }

  getData() {

    this.http.get(environment.url + 'adjunto/getAdjs').toPromise().then(r => {
      this.adjs = r.json();
    }).catch(e => {
      console.log(e);
    });

    this.http.get(environment.url + 'aplications/getApps').toPromise().then(r => {

      for (var i = 0; i < r.json().length; i++) {
        if (r.json()[i].tipo == 'Interna') {
          this.appInternas.push(r.json()[i]);
        } else {
          this.appExternas.push(r.json()[i]);
        }
      }
    }).catch(e => {
      console.log(e);
    });
  }

}
