import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Category } from './common/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private categoryURl="http://localhost:8080/api/category";
constructor(private httpclient:HttpClient) { }

getAllCategory():Observable<Category[]>
{
  return this.httpclient.get<getCategoryResponse>(this.categoryURl).pipe(map(response=>response. _embedded.categories))
}
SaveCategory(category:Category):Observable<Category>
{
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.post<Category>(this.categoryURl,category,httpOptions);
}
deleteCategory(category_id: number) {
 
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.delete<Category>(this.categoryURl+`/${category_id}`,httpOptions);
}
getCategoryByID(categoryID:number):Observable<Category>
{
const categoryIDURl=this.categoryURl+"/"+categoryID;
return  this.httpclient.get<Category>(categoryIDURl);
}
updateCategory(category:Category):Observable<Category>{
const httpOptions = {
  headers : new HttpHeaders({
      'Content-Type' : 'application/json',
      'Authorization' : 'auth-token',
      'Access-Control-Allow-Origin' : '*'
  })
};
return  this.httpclient.put<Category>(this.categoryURl+`/${category.category_id}`,category,httpOptions);
}

}
interface getCategoryResponse
{
_embedded:
{
 
  categories:Category[]
}
}

