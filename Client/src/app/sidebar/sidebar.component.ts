import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare const $: any;
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  { path: '/dashboard', title: 'Aplicaciones', icon: 'pe-7s-keypad', class: '' },
  { path: '/library', title: 'Biblioteca  Digital', icon: 'pe-7s-notebook', class: '' },
  { path: '/icons', title: 'Icons', icon: 'pe-7s-science', class: '' },
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

  }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
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
}
