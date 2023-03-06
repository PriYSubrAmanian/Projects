import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Price } from './common/price';

@Injectable({
  providedIn: 'root'
})
export class PriceService {

  private priceURl="http://localhost:8080/api/pricedata";
  constructor(private httpclient:HttpClient) { }

  getAllPrice():Observable<Price[]>
  {
    return this.httpclient.get<getPriceResponse>(this.priceURl).pipe(map(response=>response. _embedded.pricings))
  }
  SavePrice(price:Price):Observable<Price>
  {
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpclient.post<Price>(this.priceURl,price,httpOptions);
  }
  deletePrice(pricing_id: number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpclient.delete<Price>(this.priceURl+`/${pricing_id}`,httpOptions);
  }
  getPriceByID(priceID:number):Observable<Price>
{
  const priceIDURl=this.priceURl+"/"+priceID;
  return  this.httpclient.get<Price>(priceIDURl);
}
updatePrice(price:Price):Observable<Price>{
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.put<Price>(this.priceURl+`/${price.pricing_id}`,price,httpOptions);
}

}
interface getPriceResponse
{
  _embedded:
  {
   
    pricings:Price[]
  }
}
