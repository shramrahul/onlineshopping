import { Product } from "./product";

export class Cartline{
    product:Product;
    productCode:String;
    quantity:number;
    subTotal:number;

    constructor(){
        this.product= new Product();
        this.quantity=1;
        this.subTotal=0;
    }
}