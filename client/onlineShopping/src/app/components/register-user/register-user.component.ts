import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { Address } from '../../models/Address';
import { Cart } from '../../models/cart';
import {Router} from "@angular/router";
import { setTimeout } from 'timers';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  user:User;
  address:Address;
  constructor(private userService: UserService, private router:Router) {
    this.user= new User();

    this.address= new Address();
   }

  ngOnInit() {
  }

  

  onClickRegister(){
    this.address.billing=true;
    this.address.shipping=false;
    this.user.enabled=true;
    this.user.addresses.push(this.address);
    this.userService.registerUser(this.user).subscribe(data=>console.log(data));
    
   
  }
}
