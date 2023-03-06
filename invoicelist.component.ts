import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Invoice } from 'src/app/common/invoice';
import { InvoiceService } from 'src/app/invoice.service';

@Component({
  selector: 'app-invoicelist',
  templateUrl: './invoicelist.component.html',
  styleUrls: ['./invoicelist.component.css']
})
export class InvoicelistComponent implements OnInit {
  invoices:Invoice[];
  constructor(private invoiceService:InvoiceService,public router:Router,private activateRoute:ActivatedRoute) 
  {

   }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.getAllInvoices());
  }
getAllInvoices()
{
  this.invoiceService.getAllInvoice().subscribe(data=>{
    console.log(data);
    this.invoices=data;
  });
}
addInvoice():void
{
  this.router.navigateByUrl("/invoiceform")
}
updateInvoice(id:number)
{
  this.router.navigateByUrl("/updateInvoice/"+id);
}
deleteInvoice(id : number){
  console.log(id);
  if(confirm("Do you want to delete ?")){
    this.invoiceService.deleteInvoice(id).subscribe(data=>{
      console.log(data);
      this.getAllInvoices();
    })
  };
}
}