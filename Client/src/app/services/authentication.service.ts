import { Injectable, ViewContainerRef } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from 'environments/environment';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng6-toastr';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  url = environment.url + 'user/';
  auth = {};
  constructor(private router: Router, private http: Http,private toastr: ToastrService) {

  }

  loginPerson(user?: String, password?: String) {
    this.auth = { user: user, password: password, userRol: { idRol: 2 } };
    this.http.post(this.url + 'userLogin', this.auth).toPromise().then(r => {
      this.toastr.success('Bienvenido a Intranet!', 'Logueado con Exito!');
      sessionStorage.setItem('isLoggedin', 'true');
      sessionStorage.setItem('UserRol', r.json().userRol.descripcion);
      this.router.navigate(['/dashboard']);
    }).catch(e => {
      this.toastr.error('Crendenciales Incorrectas!', 'Oops algo ha salido mal!');  
    });
  }

}
