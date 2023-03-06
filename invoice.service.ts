import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Invoice } from './common/invoice';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {
  private invoiceURl="http://localhost:8080/api/invoice";
constructor(private httpclient:HttpClient) { }

getAllInvoice():Observable<Invoice[]>
{
  return this.httpclient.get<getInvoiceResponse>(this.invoiceURl).pipe(map(response=>response. _embedded.invoices))
}
SaveInvoice(invoice:Invoice):Observable<Invoice>
{
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.post<Invoice>(this.invoiceURl,invoice,httpOptions);
}
deleteInvoice(invoice_id: number) {
 
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.delete<Invoice>(this.invoiceURl+`/${invoice_id}`,httpOptions);
}
getInvoiceByID(invoiceID:number):Observable<Invoice>
{
const invoiceIDURl=this.invoiceURl+"/"+invoiceID;
return  this.httpclient.get<Invoice>(invoiceIDURl);
}
updateInvoice(invoice:Invoice):Observable<Invoice>{
const httpOptions = {
  headers : new HttpHeaders({
      'Content-Type' : 'application/json',
      'Authorization' : 'auth-token',
      'Access-Control-Allow-Origin' : '*'
  })
};
return  this.httpclient.put<Invoice>(this.invoiceURl+`/${invoice.invoice_id}`,invoice,httpOptions);
}

}
interface getInvoiceResponse
{
_embedded:
{
 
  invoices:Invoice[]
}
}

