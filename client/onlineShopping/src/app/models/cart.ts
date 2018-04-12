import { Cartline } from "./Cartline";

export class Cart {
      username:String;
      total:Number;
      cartLines:Cartline[];

      constructor(){
          this.username="";
          this.total=0;
          this.cartLines=[];
      }
}
