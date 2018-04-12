export class Product {
    code:String;
    name:String;
    brand:String;
    description:String;
    unitPrice:number;
    quantity: String;
    active:boolean;
    category:String;
    purchases:Number;
    supplierId:Number;
    views:Number;

    constructor(){
        this.active=true;
        this.purchases=0;
        this.supplierId=100000;
        this.views=0;
    }
}
