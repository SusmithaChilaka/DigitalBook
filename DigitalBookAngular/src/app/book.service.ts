import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import Book from './entity/book';

const API_URL = "http://localhost:8088/books/"
@Injectable({
  providedIn: 'root'
})
export class BookService {
  
  ID:any;
  constructor(public client:HttpClient) { } 
  saveBook(book : Book){
   return  this.client.post(API_URL,book)
  }

  getBooks(){
    return this.client.get(API_URL)
  }

  deleteBook(id: number) {
    return this.client.delete(API_URL + id);
  }

  updateBook(id: number, value: any){
    
    return this.client.put(API_URL+id, value);
  }

  getBookList() {
    return this.client.get(API_URL)
  }

  getUsers(){
    return this.client.get(API_URL+'user')
  }
  purchaseBook(books:Book){
    return this.client.post(API_URL +'buy',books)
  }

  searchBook(title:string){
    console.log(title);
    return this.client.get(API_URL+'search/'+title)
  }

}
