import { Cart } from "./cart";
import { Address } from "./Address";

export class User {
      username: String;
      firstName: String;
      lastName: String;
      email: String;
      phone: String;
      password: String;
      role: String;
      enabled: boolean;
      addresses:Address[];

      cart: Cart;

      constructor(){
            this.addresses=[];
      }

}
