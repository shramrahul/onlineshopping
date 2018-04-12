import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Http, Response } from '@angular/http';
import { Category } from '../models/Category';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { DbUtils } from '../utils/dbUtils';

@Injectable()
export class CategoryService {
  
  
  constructor(private http: Http, private dbUtils:DbUtils) { }

  getAllCategories():Observable<any>{
    return this.http.get(this.dbUtils.baseURL+"/getAllCategories")
    .map((response:Response)=>response.json())
    ._catch((error:Response)=>Observable.throw(error|| "SERVER ERROR"));
  }

  addCategory(category:Category):Observable<any>{
    return this.http.post(this.dbUtils.baseURL+"/addCategory",category,this.dbUtils.options)
    .map((response:Response)=>response);
  }
  

}
