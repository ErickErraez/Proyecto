import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  { path: '/dashboard', title: 'Aplicaciones', icon: 'pe-7s-keypad', class: '' },
  //{ path: '/user', title: 'User Profile', icon: 'pe-7s-user', class: '' },
  //{ path: '/icons', title: 'Icons', icon: 'pe-7s-science', class: '' },
  //{ path: '/notifications', title: 'Notifications', icon: 'pe-7s-bell', class: '' },
];

@Component({
  selector: 'app-sidebar',
  styleUrls: ['./sidebar.component.scss'],
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  showMenu = '';
  constructor() { }

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
}
