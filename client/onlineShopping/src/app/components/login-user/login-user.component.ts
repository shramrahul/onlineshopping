import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  credentials={username:'',password:''}
  constructor(private userService:UserService){}
  
  ngOnInit() {
  }

  login(){
    this.userService.onLogin().subscribe(user=>this.userService.pushData(user));
  }

  

}
