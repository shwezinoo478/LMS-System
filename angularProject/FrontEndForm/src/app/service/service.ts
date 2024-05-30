import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class ConfigService {
  constructor(private http: HttpClient) { }
 
  postData(url_str : string , data : object): Observable<any>{
    return this.http.post(url_str , data);
  }

  getData(url_str: string ) : Observable<any>{
    return this.http.get(url_str);
  }


  //for Encrypted Password
  async getEncryptedPassword(pass_word : string) {
    const result = await this.sha256(pass_word);
    return result.toString();
    
  }
  async sha256(input: string): Promise<string> {
    const buffer = new TextEncoder().encode(input);
    const hashBuffer = await crypto.subtle.digest('SHA-256', buffer);
    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
    return hashHex; // Make sure to return the resolved value here
  }

}