import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { User } from '../models/user';
import { ProductServiceService } from './product-service.service';
import { Product } from '../models/product';

@Injectable()
export class CartService {

  user:User;
  cartlines=[];
  constructor(private userService:UserService, private productSservice:ProductServiceService) {
    this.userService.data.subscribe(user=>this.user=user);
    this.userService.getUser();

    
   }

   getAllCartLines(){
    // this.cartlines=[];
    //  for(let cartline of this.user.cart.cartLines){
    //     this.productSservice.getProductDetailsByCode(cartline.product.code)
    //           .subscribe(product=>{
    //             let cl={
    //               product:product,
    //               quantity:cartline.quantity,
    //               subtotal:product.unitPrice*cartline.quantity
    //             };
    //             this.cartlines.push(cl);
    //           }); 
    //  }
    //  return this.cartlines;
    return this.user.cart.cartLines;
   }

   removeProductFromCart(name:String){
     this.userService.removingProductFromUserCart(name);
   }

}
