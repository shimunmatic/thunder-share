import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DefaultComponent } from './components/default/default.component';


const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    loadChildren: () => import('./modules/login/login.module').then(m => m.LoginModule)
  },
  {
    path: 'register',
    loadChildren: () => import('./modules/register/register.module').then(m => m.RegisterModule)
  },
  {
    path: 'chat',
    loadChildren: () => import('./modules/chat/chat.module').then(m => m.ChatModule)
  },
  {
    path: '**',
    component: DefaultComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
