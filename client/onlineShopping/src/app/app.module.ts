import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Location} from '@angular/common';

import { AppComponent } from './app.component';
import { HomeSidebarComponent } from './components/home-sidebar/home-sidebar.component';
import { HomeBodyComponent } from './components/home-body/home-body.component';
import { ProductServiceService } from './services/product-service.service';
import { CategoryService } from './services/category.service';
import { ProductHomeComponent } from './components/product-home/product-home.component';
import { ManageProductsComponent } from './components/manage-products/manage-products.component';
import { FormBuilder, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { DbUtils } from './utils/dbUtils';
import { UserService } from './services/user.service';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { CartComponent } from './components/cart/cart.component';
import { CartService } from './services/cart.service';

const routes: Routes =[
  {path: '',   redirectTo: 'home', pathMatch: 'full' },
  {path:"home",component:HomeBodyComponent},
  {path:"register",component:RegisterUserComponent},
  {path:"products", component: HomeSidebarComponent},
  {path:"login", component:LoginUserComponent},
  {path:"manage-products", component:ManageProductsComponent},
  {path:"products/cart", component:CartComponent},
  {path:"products/product/:name", component: ProductHomeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeSidebarComponent,
    HomeBodyComponent,
    ProductHomeComponent,
    ManageProductsComponent,
    RegisterUserComponent,
    LoginUserComponent,
    CartComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [ProductServiceService, 
                CategoryService,
                CartService,
                UserService , 
                DbUtils, 
                Location, 
                FormBuilder],
  bootstrap: [AppComponent]
})
export class AppModule { }
