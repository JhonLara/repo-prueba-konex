import { Injectable } from "@angular/core";
import { Headers, Http, RequestOptions } from "@angular/http";

@Injectable({
  providedIn: "root"
})
export class RestService {
  static queryExternalApi(url: string) {
    throw new Error('Method not implemented.');
  }
  constructor(private http: Http) { }

  /**
   *
   **/
  queryPostRegular(route: string, body: any) {
    let repos = this.http.post((route), body);
    return repos;
  }

  //Lazy loading
  queryDeleteRegular(route: string) {
    let repos = this.http.delete((route));
    return repos;
  }

  queryGet(route: string) {
    let token = localStorage.getItem("token");
    let headers = new Headers({ Authorization: token });
    let options = new RequestOptions({ headers: headers });
    let repos = this.http.get((route), options);
    return repos;
  }

  queryPost(route: string, body: any) {
    let token = localStorage.getItem("token");
    let headers = new Headers({
      'Content-Type': 'application/json'
    });
    let options = new RequestOptions({ headers: headers });
    let repos = this.http.post((route), body, options);
    return repos;
  }

  queryDelete(route: string) {
    let token = localStorage.getItem("token");
    let headers = new Headers({ Authorization: token });
    let options = new RequestOptions({ headers: headers });
    let repos = this.http.delete((route), options);
    return repos;
  }

  queryExternalApi(route: string) {
    let repos = this.http.get((route));
    return repos;
  }
}
