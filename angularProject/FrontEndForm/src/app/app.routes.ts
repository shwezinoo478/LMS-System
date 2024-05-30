import { Routes } from '@angular/router';
import { DashBoardComponent } from './dashboard/dash-board.component';
import { RegisterComponent } from './register/register.component';


export const routes: Routes = [
    { path: 'dashboard', component: DashBoardComponent },
    { path: 'register', component: RegisterComponent },
];


  