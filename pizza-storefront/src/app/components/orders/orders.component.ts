import { Component } from '@angular/core';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent {

  //constructor()

  delivery(){
    console.log("hello i'm in delivery")
  }

  amount(){
    console.log("i am in AMOUNT")
  }

  order(){
    console.log("back to orddeerringgg")
  }

  //"updateamount(amount.value)" #amount
}
