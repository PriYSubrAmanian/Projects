import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Price } from 'src/app/common/price';
import { PriceService } from 'src/app/price.service';

@Component({
  selector: 'app-pricelist',
  templateUrl: './pricelist.component.html',
  styleUrls: ['./pricelist.component.css']
})
export class PricelistComponent implements OnInit {
  prices:Price[];
  constructor(private priceService:PriceService,public router:Router,private activateRoute:ActivatedRoute) 
  {

   }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.getAllPrices());
  }
getAllPrices()
{
  this.priceService.getAllPrice().subscribe(data=>{
    console.log(data);
    this.prices=data;
  });
}
addPrice():void
{
  this.router.navigateByUrl("/priceform")
}
updatePrice(id:number)
{
  this.router.navigateByUrl("/updatePrice/"+id);
}
deletePrice(id : number){
  console.log(id);
  if(confirm("Do you want to delete ?")){
    this.priceService.deletePrice(id).subscribe(data=>{
      console.log(data);
      this.getAllPrices();
    })
  };
}
}

 


