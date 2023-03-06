import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/category.service';
import { Category } from 'src/app/common/category';

@Component({
  selector: 'app-categorylist',
  templateUrl: './categorylist.component.html',
  styleUrls: ['./categorylist.component.css']
})
export class CategorylistComponent implements OnInit {
  categories:Category[];
  constructor(private categoryService:CategoryService,public router:Router,private activateRoute:ActivatedRoute) 
  {

   }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.getAllCategories());
  }
getAllCategories()
{
  this.categoryService.getAllCategory().subscribe(data=>{
    console.log(data);
    this.categories=data;
  });
}
addCategory():void
{
  this.router.navigateByUrl("/categoryform")
}
updateCategory(id:number)
{
  this.router.navigateByUrl("/updateCategory/"+id);
}
deleteCategory(id : number){
  console.log(id);
  if(confirm("Do you want to delete ?")){
    this.categoryService.deleteCategory(id).subscribe(data=>{
      console.log(data);
      this.getAllCategories();
    })
  };
}
}