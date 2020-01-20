import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ChatRoutingModule } from './chat-routing.module';
import { ChatComponent } from './chat.component';
import { componentsAndDirectives, modules } from './dependencies';


@NgModule({
  declarations: [
    ChatComponent,
    ...componentsAndDirectives
  ],
  imports: [
    CommonModule,
    ChatRoutingModule,
    ...modules
  ]
})
export class ChatModule { }
