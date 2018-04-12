import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
import { Cartline } from '../../models/Cartline';
import { ProductServiceService } from '../../services/product-service.service';
import { CartService } from '../../services/cart.service';
import { Location } from '@angular/common';
import { Cart } from '../../models/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartLines: Cartline[];
  total:number;
  cart:Cart;
  constructor(private cartService :CartService,
              private userService:UserService ,
              private _location: Location) { 

                
    this.total=0;  
    this.cart= new Cart();
    this.cartLines=this.cartService.getAllCartLines(); 
    
  }

  ngOnInit() {
  }

  onClickContinueShopping(){
    this._location.back();
  }
  
  
  removeCartlineFromCart(name:String){
    this.cartService.removeProductFromCart(name);
    this.cartLines=this.cartService.getAllCartLines();
  }

  onClickCheckoutButton(cartlines){
    for(let cartline of cartlines){
      cartline.subtotal=cartline.product.unitPrice*cartline.quantity;
      console.log(cartline.subtotal)
    }
    this.userService.user.cart.cartLines=cartlines;
    this.userService.updateUserOnCheckout().subscribe(data=>console.log(data));
  }

}
