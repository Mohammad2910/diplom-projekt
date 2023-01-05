import {Component, OnInit} from '@angular/core';
import * as http from "http";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {User} from "./user";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  token: any;
  user = [];

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.token =  JSON.parse(localStorage.getItem('token'));
    this.getUsers();
  }

  getUsers(): any {
    const parameters = {};
    const params = new HttpParams({
      fromObject: parameters
    });
    const httpHeaders = new HttpHeaders().set('Authorization', 'Bearer ' + this.token);
    const options = {params: params, headers: httpHeaders};
    this.httpClient.get<[]>('https://projekt-mohammad.ddns.net/admin/realms/diplom-projekt/users', options).subscribe(
      response => {
        console.log(response);
        // @ts-ignore
        const mapped = Object.keys(response).map(key => (this.user.push(response[key].username)));
      }
    )
  }
}
