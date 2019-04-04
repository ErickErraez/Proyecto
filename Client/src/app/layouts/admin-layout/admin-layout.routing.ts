import { Routes } from '@angular/router';

import { HomeComponent } from '../../home/home.component';


import { IconsComponent } from '../../icons/icons.component';
import { ViewAppComponent } from 'app/view-app/view-app.component';
import { LibraryComponent } from 'app/library/library.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { RolComponent } from '../rol/rol.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard', component: DashboardComponent},
    { path: 'aplication', component: HomeComponent},
    { path: 'library', component: LibraryComponent },
    { path: 'icons', component: IconsComponent },
    { path: 'view', component: ViewAppComponent },
    { path: 'rol', component: RolComponent },
    { path: '', redirectTo: 'dashboard' },
];
