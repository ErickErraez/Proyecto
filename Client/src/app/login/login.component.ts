import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { environment } from 'environments/environment';
import { AuthenticationService } from 'app/services/authentication.service';
import { ToastsManager } from 'ng6-toastr';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  user: String;
  password: String;
  constructor(private authServices: AuthenticationService) {

  }

  ngOnInit() {

  }

  login() {
    this.authServices.loginPerson(this.user + '@iepi', this.password);
  }
}
