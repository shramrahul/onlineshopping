import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import { ProductServiceService } from '../../services/product-service.service';
import { Router } from '@angular/router';
import { Product } from '../../models/product';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-product-home',
  templateUrl: './product-home.component.html',
  styleUrls: ['./product-home.component.css']
})
export class ProductHomeComponent implements OnInit {

   product:Product;
  constructor(private productService:ProductServiceService,
              private userService: UserService,
              private router:Router, private _location: Location) {
  this.product=new Product();
  }
   
  ngOnInit() {
      this.productService.getProductDetailsByCode(this.productService.value)
      .subscribe(data=>this.product=data)    
  }

  onClickHome(){
        this.router.navigateByUrl('home');
  }

  onClickBack(){
    this._location.back();
  }

  onClickAddToCart(){
    this.userService.addingProductToUserCart(this.product);
  }

}
