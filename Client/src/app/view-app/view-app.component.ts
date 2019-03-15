import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';
import { DomSanitizer } from '@angular/platform-browser';
import { Adjunto } from 'app/Models/Adjunto';
import { environment } from 'environments/environment';

@Component({
  selector: 'app-view-app',
  templateUrl: './view-app.component.html',
  styleUrls: ['./view-app.component.scss']
})
export class ViewAppComponent implements OnInit {
  id: any = null;
  url: any;

  adjunto: Adjunto;
  srcFoto = '';
  @ViewChild('fileInput') fileInput;

  constructor(private router: Router, private root: ActivatedRoute, private http: Http, private sanitizer: DomSanitizer
  ) {

    this.adjunto = new Adjunto();

  }

  ngOnInit() {
  }

  CodificarArchivo(event) {
    const reader = new FileReader();
    if (event.target.files && event.target.files.length > 0) {
      const file = event.target.files[0];
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.adjunto.nombreArchivo = file.name;
        this.adjunto.tipoArchivo = file.type;
        this.adjunto.adjuntoArchivo = reader.result.toString().split(',')[1];
        this.srcFoto = 'data:' + this.adjunto.tipoArchivo + ';base64,' + this.adjunto.adjuntoArchivo;
        this.savePicture();
      };
    }
  }

  savePicture() {
    this.http.post(environment.url + 'adjunto/saveAdjs', this.adjunto).toPromise().then(r => {
      console.log(r);
    }).catch(e => {
      console.log(e);
    });


  }

}
