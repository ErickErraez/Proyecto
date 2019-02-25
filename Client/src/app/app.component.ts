import { Component } from "@angular/core";
import { Http } from "@angular/http";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  array: any = [];
  data = { nombre: '', apellido: '', cedula: '' };
  constructor(private http: Http) {
    this.http.get("http://localhost:8080/user/getUser").toPromise()
      .then(r => {
        this.array = r.json();
      })
      .catch(e => { });
  }

  guardarPerson() {
    this.data.nombre = 'lolo';
    this.data.apellido = 'lopez';
    this.data.cedula = '1111111';
    this.http.post("http://localhost:8080/user/postUser", this.data).toPromise()
      .then(r => {
        this.buscar();
      })
      .catch(e => { });
  }
  buscar(){
    this.http.get("http://localhost:8080/user/getUser").toPromise()
    .then(r => {
      this.array = r.json();
    })
    .catch(e => { });
  }
}
