import { Routes } from '@angular/router';
import path from 'path';
import { ContactComponent } from './contact/contact.component';
import { AbouteusComponent } from './abouteus/abouteus.component';

export const routes: Routes = [

    {path: "contact", component: ContactComponent},
    {path:"abouteus", component: AbouteusComponent},
];
