import { Routes } from '@angular/router';
import path from 'path';
import { ContactComponent } from './contact/contact.component';
import { AbouteusComponent } from './abouteus/abouteus.component';
import { ContacteComponent } from './contacte/contacte.component';
import { FooterComponent } from './footer/footer.component';

export const routes: Routes = [

    {path: "contact", component: ContactComponent},
    {path:"abouteus", component: AbouteusComponent},
    {path:"contacte", component: ContacteComponent},
    {path:"footer", component: FooterComponent},

];
