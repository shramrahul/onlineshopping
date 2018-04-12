import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { EventEmitter } from '@angular/core';
import { DbUtils } from '../utils/dbUtils';
import { Observable } from 'rxjs/Observable';
import { Http, Headers } from '@angular/http';
import { Response } from '@angular/http';
import { Address } from '../models/Address';
import { Cartline } from '../models/Cartline';
import { Product } from '../models/product';


@Injectable()
export class UserService {

   user:User;
    authenticated:boolean=false;

  data= new EventEmitter<any>();
  constructor(private dbUtils: DbUtils, private http: Http) {
    this.user=new User();
   }

  pushData(user:User){
    this.user=user;
  }

  getUser(){
    this.data.emit(this.user);
  }

  registerUser(user:User):Observable<any>{
    return this.http.post(this.dbUtils.baseURL+"/registerUser",user,this.dbUtils.options)
    .map((response:Response)=>console.log(response));
  }

  onLogin():Observable<any>{
   return this.http.get(this.dbUtils.baseURL+"/login")
   .map((response:Response)=>response.json());
  }

  updateUserOnCheckout():Observable<any>{
    console.log("sending...")
    return this.http.post(this.dbUtils.baseURL+"/updateUser",this.user,this.dbUtils.options)
    .map((response:Response)=>response);
  }


  addingProductToUserCart(product:Product){
    console.log(this.user);
    let isFound:boolean=false;

    for(let cl of this.user.cart.cartLines){
      if(cl.product.code===product.code){
        const i: number= this.user.cart.cartLines.indexOf(cl);
        this.user.cart.cartLines[i].quantity++;
        this.user.cart.cartLines[i].subTotal+=product.unitPrice;
        isFound=true;
        break;
      }
    }
    
    if(!isFound){
      const cartline=new Cartline();
        cartline.product=product;
        cartline.productCode=product.code;
        cartline.subTotal=product.unitPrice;
        this.user.cart.cartLines.push(cartline);
    }
  }


  removingProductFromUserCart(name:String){
    for(let cl of this.user.cart.cartLines){
      if(cl.product.code===name){
        this.user.cart.cartLines.splice(this.user.cart.cartLines.indexOf(cl),1);
        break;
      }
    }
  }

}
