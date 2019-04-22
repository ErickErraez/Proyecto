import { Component, OnInit, ViewChild } from '@angular/core';
import { EnterateService } from 'app/services/enterate.service';
import { Enterate } from 'app/Models/Enterate';
import { Adjunto } from 'app/Models/Adjunto';
import { Http } from '@angular/http';
import { environment } from 'environments/environment';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-enterates',
  templateUrl: './enterates.component.html',
  styleUrls: ['./enterates.component.scss']
})
export class EnteratesComponent implements OnInit {

  enterates = [];
  isNewEnterate = false;
  enterate: Enterate;
  idEnterate: Enterate;
  userRol = sessionStorage.getItem('UserRol');
  attached: Adjunto;
  atachHome: Adjunto;
  srcFoto = 'assets/img/iepi.png';
  srcHome = 'assets/img/iepi.png';
  @ViewChild('fileInput') fileInput;
  @ViewChild('fileHome') fileHome;

  constructor(private enterateServices: EnterateService, private http: Http, private toastr: ToastrService) {
    this.getData();
    this.enterate = new Enterate();
    this.attached = new Adjunto();
    this.atachHome = new Adjunto();
    this.idEnterate = new Enterate();
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

  CodificarArchivoHome(event) {
    const reader = new FileReader();
    if (event.target.files && event.target.files.length > 0) {
      const file = event.target.files[0];
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.atachHome.nombreArchivo = file.name;
        this.atachHome.tipoArchivo = file.type;
        this.atachHome.adjuntoArchivo = reader.result.toString().split(',')[1];
        this.srcHome = 'data:' + this.atachHome.tipoArchivo + ';base64,' + this.atachHome.adjuntoArchivo;
      };
    }
  }

  getData() {
    this.enterateServices.getEnterates().then(r => {
      this.enterates = r;
    }).catch(e => {

    });
  }

  typeClass(id) {
    var numero = parseInt(id);
    if (numero % 2 == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  checkRol() {
    if (this.userRol == 'Administrador' || this.userRol == 'Escritura') {
      return true;
    } else {
      return false;
    }
  }

  agregarEnterate() {
    if (this.srcFoto == "assets/img/iepi.png") {
      this.toastr.error('Debe cambiar la imagen!', 'Oops algo ha salido mal!');
    }
    if (this.enterate.titulo === undefined || this.enterate.fecha === undefined) {
      this.toastr.error('Debes completar todos los campos!', 'Oops algo ha salido mal!');
    }
    else {
      this.enterateServices.saveEnterates(this.enterate).then(r => {
        this.enterate = r;
        this.http.post(environment.url + 'adjunto/saveAdjs', this.attached).toPromise().then(res => {
          this.enterate.adjunto = res.json();
          this.http.post(environment.url + 'adjunto/saveAdjs', this.atachHome).toPromise().then(at => {
            this.enterate.home = at.json();
            this.http.put(environment.url + 'enterates/ent/adjs', this.enterate).toPromise().then(re => {
              this.http.put(environment.url + 'enterates/ent/home', this.enterate).toPromise().then(responseAt => {
                this.guardado();
              }).catch(aterror => {

              });

            }).catch(err => {

            });
          }).catch(atE => {

          });
        }).catch(er => {

        });
      }).catch(e => {

      });
    }
  }

  Cancelar() {
    this.isNewEnterate = false;
    this.enterate = new Enterate();
    this.attached = new Adjunto();
    this.srcFoto = 'assets/img/iepi.png';
  }

  guardado() {
    this.toastr.success(' Se han guardado con exito!', 'Todos los Datos!');
    this.Cancelar();
    this.getData();
  }

  getLastId() {
    this.enterateServices.getLastId().then(r => {
      this.idEnterate = r;
    }).catch(e => {

    });
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
}