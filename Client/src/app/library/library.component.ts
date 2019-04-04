import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'environments/environment.prod';
import { Adjunto } from 'app/Models/Adjunto';
import { DomSanitizer } from '@angular/platform-browser';
import { Library } from 'app/Models/Library';
import { Catalogo } from 'app/Models/Catalogo';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.scss']
})
export class LibraryComponent implements OnInit {

  showMenu: any = '';
  libraries: any = [];
  catalogo: any = [];
  isNewBib = false;
  showBar = false;
  verificador = false;
  userRol = sessionStorage.getItem('UserRol');
  isNewName = false;
  width: any = 0;
  isExists = false;
  isExistsBib = false;
  url: any;
  activarBoton = false;
  percent: any = 0;
  attached: Adjunto;
  library: Library;
  cat: Catalogo;
  srcFoto = 'assets/img/adjunto.png';
  pdfShow = false;
  linkSource: any = 'null';

  constructor(private http: Http, private domSanitizer: DomSanitizer, private toastr: ToastrService) {
    this.getData();
    this.attached = new Adjunto();
    this.cat = new Catalogo();
    this.library = new Library();

  }

  ngOnInit() {
  }

  addExpandClass(element: any) {
    if (element === this.showMenu) {
      this.showMenu = '0';
    } else {
      this.showMenu = element;
    }
  }

  getLibrary() {
    if (this.library.idBib !== undefined) {
      this.http.get(environment.url + 'biblioteca/getBiblioteca/' + this.library.idBib).toPromise().then(r => {
        this.library = r.json();
      }).catch(e => {

      });
    }
  }

  getData() {
    this.http.get(environment.url + 'biblioteca/getBib').toPromise().then(r => {
      this.libraries = r.json();
    }).catch(e => {
      console.log(e.json());
    });
    this.http.get(environment.url + 'catalogo/getCat').toPromise().then(r => {
      this.catalogo = r.json();
    }).catch(e => {
      console.log(e.json());
    });
  }
  showPdf(nombreArchivo, archivoAdjunto) {

    var objbuilder = '';
    objbuilder += ('<embed width="100%" height="100%" src="data:application/pdf;base64,');
    objbuilder += (archivoAdjunto);
    objbuilder += ('" type="application/pdf"  >');

    var win = window.open("#", "_blank");
    var title = nombreArchivo;
    win.document.write('<html><title>' + title + '</title><body style="margin-top:0px; margin-left: 0px; margin-right: 0px; margin-bottom: 0px;">');
    win.document.write(objbuilder);
    win.document.write('</body></html>');

  }

  downloadPdf(nombreArchivo, tipoarchivo, archivoAdjunto) {
    this.pdfShow = true;
    this.linkSource = 'data:' + tipoarchivo + ';base64,' + archivoAdjunto;
    this.url = this.domSanitizer
      .bypassSecurityTrustResourceUrl(this.linkSource);

    console.log(this.linkSource);
    const downloadLink = document.createElement("a");
    const fileName = nombreArchivo;

    downloadLink.href = this.linkSource;
    downloadLink.download = fileName;
    downloadLink.click();
  }

  CodificarArchivo(event) {
    this.showBar = true;
    this.srcFoto = 'assets/img/adjunto.png';
    this.progress();
    const reader = new FileReader();
    if (event.target.files && event.target.files.length > 0) {
      const file = event.target.files[0];
      reader.readAsDataURL(file);
      reader.onload = () => {
        console.log(file);
        this.attached.nombreArchivo = file.name;
        this.attached.tipoArchivo = file.type;
        this.attached.adjuntoArchivo = reader.result.toString().split(',')[1];

      };
    }
  }

  progress() {
    if (this.width === 100) {
      this.activarBoton = true;
    }
    if (this.width < 100) {
      this.width++;
      var timer = setTimeout(() => {
        this.progress()
      }, 50);

    } else {
      clearTimeout(timer);
      this.srcFoto = 'assets/img/adjuntado.png';
      this.activarBoton = true;
      this.width = 0;
      this.showBar = false;
    }
  }

  typeClass(id) {
    var numero = parseInt(id);
    if (numero % 2 == 0) {
      return false;
    }
    else {
      return true;
    }
  }

  agregarBiblioteca() {
    this.isNewBib = true;
    this.isExists = true;
    this.isNewName = true;
    this.verificador = true;
  }

  agregarArchivo() {
    this.isExists = true;
    this.isNewBib = true;
    this.isNewName = true;
    this.isExistsBib = true;
    this.verificador = false;
  }

  save() {
    if (this.verificador) {
      this.saveNewBib();
    }
    if (!this.verificador) {
      this.saveExistsBib();
    }

  }

  Cancelar() {
    this.isNewBib = false;
    this.library = new Library();
    this.attached = new Adjunto();
    this.cat = new Catalogo()
  }

  saveNewBib() {
    if (this.library.nombre === undefined || this.cat.nombre === undefined || this.attached.adjuntoArchivo === undefined) {
      this.toastr.error('Debes completar todos los campos!', 'Oops algo ha salido mal!');
    } else {

      this.http.post(environment.url + 'biblioteca/saveBib', this.library).toPromise().then(bib => {
        this.library = bib.json();
        this.http.post(environment.url + 'adjunto/saveAdjs', this.attached).toPromise().then(img => {

          this.http.post(environment.url + 'catalogo/saveCat', this.cat).toPromise().then(catalogo => {
            this.cat.adjunto = img.json();
            this.cat.biblioteca = this.library;
            this.cat.idCat = catalogo.json().idCat;
            this.http.put(environment.url + 'catalogo/cats/adjs', this.cat).toPromise().then(cat => {
              this.toastr.success('Todos los Datos!', 'Se han guardado con exito!');
              this.getData();
              this.Cancelar();
            }).catch(catError => {
              console.log(catError);
            });
          }).catch(e => {
            console.log(e);
          });
        }).catch(er => {
          console.log(er);
        });
      }).catch(error => {
        if (error.body = 'Ya existe') {
          this.toastr.error('No se pudo crear ' + this.library.nombre + ' porque ya existe!', 'Oops algo ha salido mal!');
        }
      });
    }

  }
  checkRol(){
    if(this.userRol == 'Administrador' || this.userRol == 'Escritura'){
      return true;
    }else{
      return false;
    }
  }

  saveExistsBib() {
    if (this.library.nombre === undefined || this.cat.nombre === undefined || this.attached.adjuntoArchivo === undefined) {
      this.toastr.error('Debes completar todos los campos!', 'Oops algo ha salido mal!');
    } else {
      this.http.post(environment.url + 'adjunto/saveAdjs', this.attached).toPromise().then(image => {
        this.http.post(environment.url + 'catalogo/saveCat', this.cat).toPromise().then(catalogo => {
          this.cat.adjunto = image.json();
          this.cat.biblioteca = this.library;
          this.cat.idCat = catalogo.json().idCat;
          this.http.put(environment.url + 'catalogo/cats/adjs', this.cat).toPromise().then(cat => {

          }).catch(catError => {
            console.log(catError);
          });
        }).catch(e => {
          console.log(e);
          if (e.body = 'Ya existe') {
            this.toastr.error('No se pudo crear ' + this.cat.nombre + ' porque ya existe!', 'Oops algo ha salido mal!');
          }
        });
      }).catch(error => {
        console.log(error);
      });
    }
  }

}
