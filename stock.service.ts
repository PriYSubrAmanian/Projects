import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Stock } from './common/stock';

@Injectable({
  providedIn: 'root'
})
export class StockService {
   private stockURl="http://localhost:8080/api/stock";
constructor(private httpclient:HttpClient) { }

getAllStock():Observable<Stock[]>
{
  return this.httpclient.get<getStockResponse>(this.stockURl).pipe(map(response=>response. _embedded.stocks))
}
SaveStock(stock:Stock):Observable<Stock>
{
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.post<Stock>(this.stockURl,stock,httpOptions);
}
deleteStock(ref_id: number) {
 
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.delete<Stock>(this.stockURl+`/${ref_id}`,httpOptions);
}
getStockByID(refID:number):Observable<Stock>
{
const refIDURl=this.stockURl+"/"+refID;
return  this.httpclient.get<Stock>(refIDURl);
}
updateStock(stock:Stock):Observable<Stock>{
const httpOptions = {
  headers : new HttpHeaders({
      'Content-Type' : 'application/json',
      'Authorization' : 'auth-token',
      'Access-Control-Allow-Origin' : '*'
  })
};
return  this.httpclient.put<Stock>(this.stockURl+`/${stock.ref_id}`,stock,httpOptions);
}

}
interface getStockResponse
{
_embedded:
{
 
  stocks:Stock[]
}
}

