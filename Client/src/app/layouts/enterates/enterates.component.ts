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
  userRol = sessionStorage.getItem('UserRol');
  attached: Adjunto;
  srcFoto = 'assets/img/iepi.png';
  @ViewChild('fileInput') fileInput;

  constructor(private enterateServices: EnterateService, private http: Http, private toastr: ToastrService) {
    this.getData();
    this.enterate = new Enterate();
    this.attached = new Adjunto();
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
          this.http.put(environment.url + 'enterates/ent/adjs', this.enterate).toPromise().then(re => {
            this.guardado();
          }).catch(err => {

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


}
