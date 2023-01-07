import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../user";

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  private getAuthHeader() {
    // @ts-ignore
    const token =  JSON.parse(localStorage.getItem('token'));
    const httpHeaders = new HttpHeaders().set('Authorization', 'Bearer ' + token);

    return httpHeaders;
  }

  getUsers(): Observable<User[]> {
    const url = 'https://projekt-mohammad.ddns.net/api/users';
    const options = {headers: this.getAuthHeader()};

    return this.httpClient.get<[]>(url, options);
  }
}
