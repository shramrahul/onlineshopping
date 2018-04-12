import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../../services/product-service.service';
import { CategoryService } from '../../services/category.service';
import { Product } from '../../models/product';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
import { Cartline } from '../../models/Cartline';

@Component({
  selector: 'app-home-sidebar',
  templateUrl: './home-sidebar.component.html',
  styleUrls: ['./home-sidebar.component.css']
})
export class HomeSidebarComponent implements OnInit {
  
  products:Product[];
  categories;
  user:User;
  constructor(private productService:ProductServiceService,
              private categoryService: CategoryService,
                private userService:UserService) {

      this.getAllCategories();
      this.getAllActiveProducts();
    
   }

  ngOnInit() {
  }


  onClickShowDetailsOfProduct(product){
    this.productService.pushProduct(product);
  }

  getAllActiveProducts(){
    console.log("here.....");
    this.productService.getAllActiveProducts().subscribe(data=>this.products=data)
    }

  getAllCategories(){
    this.categoryService.getAllCategories().subscribe(data=>this.categories=data)
  }

  getAllProductsByCategoryName( name:String){
    this.productService.getAllProductsByCategoryName(name).subscribe(data=>this.products=data);

  }

  onClickAddToCart(product){
    this.userService.addingProductToUserCart(product);
  }

}
