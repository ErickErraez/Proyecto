import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.scss']
})
export class LibraryComponent implements OnInit {

  showMenu: any;
  isExpand = false;

  constructor() { }

  ngOnInit() {
  }

  addExpandClass(element: any) {
    if (element === this.showMenu) {
      this.showMenu = '0';
      this.isExpand = false;
    } else {
      this.showMenu = element;
      this.isExpand = true;
    }
  }
}
