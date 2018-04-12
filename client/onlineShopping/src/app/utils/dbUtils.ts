
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class DbUtils{

public baseURL:String="http://localhost:8080";
   public headers= new Headers({'Content-Type':"application/json"})
   public options= new RequestOptions({headers:this.headers})
   
}