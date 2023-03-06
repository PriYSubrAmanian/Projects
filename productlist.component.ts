import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {
  products:Product[];
  constructor(private productService:ProductService,public router:Router,private activateRoute:ActivatedRoute) 
  {

   }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.getAllProducts());
  }
getAllProducts()
{
  this.productService.getAllProduct().subscribe(data=>{
    console.log(data);
    this.products=data;
  });
}
addProduct():void
{
  this.router.navigateByUrl("/productform")
}
updateProduct(id:number)
{
  this.router.navigateByUrl("/updateProduct/"+id);
}
deleteProduct(id : number){
  console.log(id);
  if(confirm("Do you want to delete ?")){
    this.productService.deleteProduct(id).subscribe(data=>{
      console.log(data);
      this.getAllProducts();
    })
  };
}
}
