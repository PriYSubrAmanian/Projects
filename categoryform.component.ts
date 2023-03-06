import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/category.service';
import { Category } from 'src/app/common/category';

@Component({
  selector: 'app-categoryform',
  templateUrl: './categoryform.component.html',
  styleUrls: ['./categoryform.component.css']
})
export class CategoryformComponent implements OnInit {
  category : Category = new Category(0,"","",new Date(),"",new Date());
  isEditable: boolean;
  constructor(private categoryService:CategoryService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.category);
    this.activateRoute.paramMap.subscribe(()=>this.getCategoryById());

  }
  getCategoryById(){
    const catID  = parseFloat(this.activateRoute.snapshot.paramMap.get("category_id"));
    
  console.log(catID);
  if(catID> 0)
  {
    this.isEditable = true;
    this.categoryService.getCategoryByID(catID).subscribe(data=>{
      this.category = data;
      console.log(this.category)
    });
  }

  }
  onSubmit(){
    console.log(this.category);
    if(this.isEditable){
      this.categoryService.updateCategory(this.category).subscribe(data=>
        this.router.navigateByUrl("/categories"));

    }
    else{
    this.categoryService.SaveCategory( this.category ).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/categories");
  }
}}

