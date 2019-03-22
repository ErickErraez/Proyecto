import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'environments/environment.prod';
import { Adjunto } from 'app/Models/Adjunto';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.scss']
})
export class LibraryComponent implements OnInit {

  showMenu: any;
  libraries: any = [];
  url: any;
  pdfShow = false;
  linkSource: any = 'null';

  constructor(private http: Http, private domSanitizer: DomSanitizer) {

    this.getData();
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

  getData() {
    this.http.get(environment.url + 'biblioteca/getBib').toPromise().then(r => {
      this.libraries = r.json();
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

  typeClass(id) {
    var numero = parseInt(id);
    if (numero % 2 == 0) {
      return false;
    }
    else {
      return true;
    }
  }

}
