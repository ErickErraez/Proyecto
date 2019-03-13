import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';

import { HomeComponent } from '../../home/home.component';
import { IconsComponent } from '../../icons/icons.component';
import { ViewAppComponent } from 'app/view-app/view-app.component';
import { UrlPipe } from 'app/pipes/url.pipe';
import { LibraryComponent } from 'app/library/library.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,

  ],
  declarations: [
    HomeComponent,
    LibraryComponent,
    IconsComponent,
    ViewAppComponent,
    UrlPipe,
  ]
})

export class AdminLayoutModule {}
