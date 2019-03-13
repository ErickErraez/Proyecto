import { Injectable } from '@angular/core';
import { CanActivate,Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GuardGuard implements CanActivate {

  loggedIn = false;

  constructor(private router: Router) {

  }

  canActivate() {
    if (sessionStorage.getItem('isLoggedin')) {
      return true;
    }

    this.router.navigate(['/login']);
    return false;
  }
}
