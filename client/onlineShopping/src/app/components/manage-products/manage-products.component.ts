import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CategoryService } from '../../services/category.service';
import { ProductServiceService } from '../../services/product-service.service';
import { Product } from '../../models/product';
import { error } from 'util';
import { Response } from '@angular/http';
import { Category } from '../../models/Category';

@Component({
  selector: 'app-manage-products',
  templateUrl: './manage-products.component.html',
  styleUrls: ['./manage-products.component.css']
})
export class ManageProductsComponent implements OnInit {

  category:Category;
  categories:Category[];
  product:Product;
  products:Product[];

  constructor(private categoryService: CategoryService, 
    private productService: ProductServiceService,
    private formBuilder: FormBuilder) {

    this.product= new Product();
    this.category= new Category();
    this.productService.getAllProducts().subscribe(data=>this.products=data);
    this.categoryService.getAllCategories().subscribe(data=>this.categories=data);

   }

  ngOnInit() {
  }

  onClickSubmit(prod){
    // this.productService.addProduct(this.product.value);
    this.productService.addProduct(prod).subscribe(data=>console.log(data));
  }


  onClickEditButton(product:Product){
    this.product=product;
  }

  onClickActiveDeactiveButtonOf(product:Product){
    product.active=!product.active;
    this.productService.updateProduct(product).subscribe(data=>console.log(data));
  }

  onClickSUbmitNewCategory(){
    this.categoryService.addCategory(this.category).subscribe(data=>console.log(data));
  }

}
