import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProposeAnimalComponent } from './propose-animal/propose-animal.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/user-info'},
  {path: 'user-info', component: ProposeAnimalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
