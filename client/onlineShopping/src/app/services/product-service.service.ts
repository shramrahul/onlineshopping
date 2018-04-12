import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { EventEmitter } from '@angular/core';
import { UUID } from 'angular2-uuid';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Product } from '../models/product';
import {DbUtils} from '../utils/dbUtils'


@Injectable()
export class ProductServiceService {

  value:any;
  pushedData= new EventEmitter<any>();
  dbUtils;
  constructor(private http: Http ) {
    this.dbUtils= new DbUtils();
   }

  public pushProduct(product:any){
    this.value=product;
  }

  getProduct(){
    this.pushedData.emit(this.value);
  }

  getAllProducts():Observable<any>{
    return this.http.get(this.dbUtils.baseURL+"/getAllProducts")
    .map((response:Response)=>response.json())
    ._catch((error:Response)=>Observable.throw(error));
  }

  getAllActiveProducts():Observable<any>{
    return this.http.get(this.dbUtils.baseURL+"/getAllActiveProducts")
    .map((response:Response)=>response.json())
    ._catch((error:Response)=>Observable.throw(error));
  }

  getAllProductsByCategoryName(name:String):Observable<any>{
    return this.http.get(this.dbUtils.baseURL+"/getAllProductsByCategoryName/"+name)
    .map((response:Response)=>response.json())
    ._catch((error:Response)=>Observable.throw(error));
  }

  getProductDetailsByCode(code:String):Observable<any>{
    console.log("code....")
    return this.http.get(this.dbUtils.baseURL+"/getProductDetailsByCode/"+code)
    .map((response:Response)=>response.json())
    ._catch((error:Response)=>Observable.throw(error));
  }

  // updateProduct(product:Product){

  //   return this.http.put(this.baseURL+"/updateProduct",JSON.stringify(product),this.options)
  //           .map((response:Response)=>(response.json()));
  // }

  addProduct(prod):Observable<any>{
    if(prod.code===null)
    prod.code="PRD"+UUID.UUID().substring(30).toUpperCase();
    console.log(prod);
    return this.http.post(this.dbUtils.baseURL+"/addProduct",JSON.stringify(prod), this.dbUtils.options)
    .map((response:Response)=>(response.json()))
    //._catch((error:Response)=>Observable.throw(error));
   
  // i was trying to fing the way to map json to domain object in backend. work in progress
  }

  updateProduct(product):Observable<any>{
    return this.http.put(this.dbUtils.baseURL+"/updateProduct",JSON.stringify(product), this.dbUtils.options)
    .map((response:Response)=>(response.json()))
   // ._catch((error:Response)=>Observable.throw(error));
   
  }


}
