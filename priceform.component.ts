import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Price } from 'src/app/common/price';
import { PriceService } from 'src/app/price.service';

@Component({
  selector: 'app-priceform',
  templateUrl: './priceform.component.html',
  styleUrls: ['./priceform.component.css']
})
export class PriceformComponent implements OnInit {
  price : Price = new Price(0,"",new Date(),"",new Date());
  isEditable: boolean;
  constructor(private priceService:PriceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.price);
    this.activateRoute.paramMap.subscribe(()=>this.getPriceById());

  }
  getPriceById(){
    const priID  = parseFloat(this.activateRoute.snapshot.paramMap.get("pricing_id"));
    
  console.log(priID);
  if(priID> 0)
  {
    this.isEditable = true;
    this.priceService.getPriceByID(priID).subscribe(data=>{
      this.price = data;
      console.log(this.price)
    });
  }

  }
  onSubmit(){
    console.log(this.price);
    if(this.isEditable){
      this.priceService.updatePrice(this.price).subscribe(data=>
        this.router.navigateByUrl("/pricings"));

    }
    else{
    this.priceService.SavePrice( this.price ).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/pricings");
  }
}}
