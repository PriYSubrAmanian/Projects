import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Invoice } from 'src/app/common/invoice';
import { InvoiceService } from 'src/app/invoice.service';

@Component({
  selector: 'app-invoiceform',
  templateUrl: './invoiceform.component.html',
  styleUrls: ['./invoiceform.component.css']
})
export class InvoiceformComponent implements OnInit {
  invoice : Invoice = new Invoice(0,0,0);
  isEditable: boolean;
  constructor(private invoiceService:InvoiceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.invoice);
    this.activateRoute.paramMap.subscribe(()=>this.getInvoiceById());

  }
  getInvoiceById(){
    const invID  = parseFloat(this.activateRoute.snapshot.paramMap.get("invoice_id"));
    
  console.log(invID);
  if(invID> 0)
  {
    this.isEditable = true;
    this.invoiceService.getInvoiceByID(invID).subscribe(data=>{
      this.invoice = data;
      console.log(this.invoice)
    });
  }

  }
  onSubmit(){
    console.log(this.invoice);
    if(this.isEditable){
      this.invoiceService.updateInvoice(this.invoice).subscribe(data=>
        this.router.navigateByUrl("/invoices"));

    }
    else{
    this.invoiceService.SaveInvoice( this.invoice ).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/invoices");
  }
}}

