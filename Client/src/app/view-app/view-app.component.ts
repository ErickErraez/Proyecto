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
  constructor(private router: Router, private root: ActivatedRoute, private http: Http, private sanitizer: DomSanitizer) {
    this.id = this.root.snapshot.params['id'];
    if (this.id == 1) {
      this.url = 'https://lumen.laravel.com/';
    }
    if (this.id == 2) {
      this.url = 'https://getbootstrap.com/docs/4.3/components/card/'
    }

  }

  ngOnInit() {
  }

}
