import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-productform',
  templateUrl: './productform.component.html',
  styleUrls: ['./productform.component.css']
})
export class ProductformComponent implements OnInit {
  product : Product = new Product(0,"","",new Date(),"",new Date(),0,0);
  isEditable: boolean;
  constructor(private productService:ProductService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.product);
    this.activateRoute.paramMap.subscribe(()=>this.getProductById());

  }
  getProductById(){
    const proID  = parseFloat(this.activateRoute.snapshot.paramMap.get("productid"));
    
  console.log(proID);
  if(proID> 0)
  {
    this.isEditable = true;
    this.productService.getProductByID(proID).subscribe(data=>{
      this.product = data;
      console.log(this.product)
    });
  }

  }
  onSubmit(){
    console.log(this.product);
    if(this.isEditable){
      this.productService.updateProduct(this.product).subscribe(data=>
        this.router.navigateByUrl("/products"));

    }
    else{
    this.productService.SaveProduct( this.product ).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/products");
  }
}}

