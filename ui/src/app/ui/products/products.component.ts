import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
})
export class ProductsComponent implements OnInit{
  public  products : any;
  constructor(private http : HttpClient) {
  }
  ngOnInit() {
    this.http.get("http://localhost:8001/products").subscribe({
      next : data => {
        this.products = data;
      },
      error : err => {
        console.log(err);
      }
    })
  }
}
