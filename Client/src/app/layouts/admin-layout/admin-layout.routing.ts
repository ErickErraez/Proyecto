import { Routes } from '@angular/router';

import { HomeComponent } from '../../home/home.component';


import { IconsComponent } from '../../icons/icons.component';
import { ViewAppComponent } from 'app/view-app/view-app.component';
import { LibraryComponent } from 'app/library/library.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard', component: HomeComponent},
    { path: 'library', component: LibraryComponent },
    { path: 'icons', component: IconsComponent },
    { path: 'view', component: ViewAppComponent },
    { path: '', redirectTo: 'dashboard' },
];
