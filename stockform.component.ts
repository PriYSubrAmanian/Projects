import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Stock } from 'src/app/common/stock';
import { StockService } from 'src/app/stock.service';

@Component({
  selector: 'app-stockform',
  templateUrl: './stockform.component.html',
  styleUrls: ['./stockform.component.css']
})
export class StockformComponent implements OnInit {
  stock : Stock = new Stock(0,0,"",new Date(),new Date(),"",0);
  isEditable: boolean;
  constructor(private stockService:StockService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.stock);
    this.activateRoute.paramMap.subscribe(()=>this.getStockById());

  }
  getStockById(){
    const refID  = parseFloat(this.activateRoute.snapshot.paramMap.get("ref_id"));
    
  console.log(refID);
  if(refID> 0)
  {
    this.isEditable = true;
    this.stockService.getStockByID(refID).subscribe(data=>{
      this.stock = data;
      console.log(this.stock)
    });
  }

  }
  onSubmit(){
    console.log(this.stock);
    if(this.isEditable){
      this.stockService.updateStock(this.stock).subscribe(data=>
        this.router.navigateByUrl("/stocks"));

    }
    else{
    this.stockService.SaveStock( this.stock ).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/stocks");
  }
}}
