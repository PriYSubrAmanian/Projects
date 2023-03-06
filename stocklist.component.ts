import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Stock } from 'src/app/common/stock';
import { StockService } from 'src/app/stock.service';

@Component({
  selector: 'app-stocklist',
  templateUrl: './stocklist.component.html',
  styleUrls: ['./stocklist.component.css']
})
export class StocklistComponent implements OnInit {
  stocks:Stock[];
  constructor(private stockService:StockService,public router:Router,private activateRoute:ActivatedRoute) 
  {

   }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.getAllStocks());
  }
getAllStocks()
{
  this.stockService.getAllStock().subscribe(data=>{
    console.log(data);
    this.stocks=data;
  });
}
addStock():void
{
  this.router.navigateByUrl("/stockform")
}
updateStock(ref_id:number)
{
  this.router.navigateByUrl("/updateStock/"+ref_id);
}
deleteStock(id : number){
  console.log(id);
  if(confirm("Do you want to delete ?")){
    this.stockService.deleteStock(id).subscribe(data=>{
      console.log(data);
      this.getAllStocks();
    })
  };
}
}