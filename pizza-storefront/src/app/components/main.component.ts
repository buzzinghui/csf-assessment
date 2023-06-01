import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PizzaService } from '../pizza.service';
// import { Order } from '../common/order';
import { Observable } from 'rxjs';
//import { Observable } from 'rxjs/internal/Observable';


const SIZES: string[] = [
  "Personal - 6 inches",
  "Regular - 9 inches",
  "Large - 12 inches",
  "Extra Large - 15 inches"
]

const PIZZA_TOPPINGS: string[] = [
    'chicken', 'seafood', 'beef', 'vegetables',
    'cheese', 'arugula', 'pineapple'
]

//let pizzatoppings = new FormArray([])

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  //<FormArray>pizzatoppings!: FormGroup

  form!: FormGroup

  pizzaSize = SIZES[0]

  constructor(private router: Router, private formBuilder: FormBuilder,
              private pizzaOrderService: PizzaService) { }

  ngOnInit(): void {
      this.form = this.formBuilder.group({
        name: ['', [Validators.required, Validators.minLength(3)]],
        email: ['', [Validators.required]],
        size: ['6 inches', [Validators.required]],
        base: ['', [Validators.required]],
        sauce: ['', [Validators.required]],
        toppings: this.formBuilder.array([]),
        comments: ['']
      })
  }

  updateSize(size: string) {
    this.pizzaSize = SIZES[parseInt(size)]
  }

  onSubmit() {
    console.log(this.form.value)
    const pizzaOrder = this.form.value
    this.pizzaOrderService.placeOrder(pizzaOrder).subscribe({
      next: response => {
        console.log("placing order i am")

        this.resetOrder()
      },
      error: err => {
        console.log("i am having an error")
      }
      }
    )
  }

  get toppingsArray(): FormArray {
    return this.form.get('toppings') as FormArray;
  }

  onAddRemoveIngredient(event: any) {
    const toppings = this.toppingsArray;
    if (event.target.checked) {
      toppings.push(this.formBuilder.control(event.target.value));
    } else {
      const index = toppings.controls.findIndex(x => x.value === event.target.value);
      toppings.removeAt(index);
    }
  }

  resetOrder() {
    this.form.reset()
  }
}
