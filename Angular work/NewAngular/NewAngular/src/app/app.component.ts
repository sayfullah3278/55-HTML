import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { TodoList } from './TodoList';
import { TodoItem } from './TodoItem';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  private list = new TodoList("Hasan",[
    new TodoItem("Singara Khabo"),
    new TodoItem("Jorimana Korbo"),
    new TodoItem("Cha Khabo")
  ]);

  get username():string{

    return this.list.user;
  }
  get itenCount(): number{

    return this.list.items
    .filter(item=> !item.Complete).length;
  }
}
