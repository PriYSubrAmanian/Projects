import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Product } from './common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productURl="http://localhost:8080/api/product";
constructor(private httpclient:HttpClient) { }

getAllProduct():Observable<Product[]>
{
  return this.httpclient.get<getProductResponse>(this.productURl).pipe(map(response=>response. _embedded.products))
}
SaveProduct(product:Product):Observable<Product>
{
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.post<Product>(this.productURl,product,httpOptions);
}
deleteProduct(productid: number) {
 
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.delete<Product>(this.productURl+`/${productid}`,httpOptions);
}
getProductByID(productID:number):Observable<Product>
{
const productIDURl=this.productURl+"/"+productID;
return  this.httpclient.get<Product>(productIDURl);
}
updateProduct(product:Product):Observable<Product>{
const httpOptions = {
  headers : new HttpHeaders({
      'Content-Type' : 'application/json',
      'Authorization' : 'auth-token',
      'Access-Control-Allow-Origin' : '*'
  })
};
return  this.httpclient.put<Product>(this.productURl+`/${product.productid}`,product,httpOptions);
}

}
interface getProductResponse
{
_embedded:
{
 
  products:Product[]
}
}
