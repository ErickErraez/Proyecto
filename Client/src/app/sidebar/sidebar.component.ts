import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare const $: any;
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
  condition(): boolean;

}

export const ROUTES: RouteInfo[] = [
  { path: '/aplication', title: 'Aplicaciones', icon: 'pe-7s-keypad', class: '', condition() { return true } },
  { path: '/library', title: 'Biblioteca  Digital', icon: 'pe-7s-notebook', class: '', condition() { return true } },
  { path: '/icons', title: 'Icons', icon: 'pe-7s-science', class: '', condition() { return true } },
  { path: '/view', title: 'Eventos', icon: 'pe-7s-date', class: '', condition() { return true } },
  {
    path: '/rol', title: 'Aignar Rol', icon: 'pe-7s-id', class: '', condition() {
      var userRol = sessionStorage.getItem('UserRol');
      if (userRol === 'Administrador') {
        return true;
      }
      return false;
    }
  },
];


@Component({
  selector: 'app-sidebar',
  styleUrls: ['./sidebar.component.scss'],
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  showMenu = '';

  constructor(private router: Router) {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

  ngOnInit() {


  }
  isMobileMenu() {
    if ($(window).width() > 991) {
      return false;
    }
    return true;
  };
  addExpandClass(element: any) {
    if (element === this.showMenu) {
      this.showMenu = '0';
    } else {
      this.showMenu = element;
    }
  }

  logOut() {
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }

  refresh() {

  }

}
