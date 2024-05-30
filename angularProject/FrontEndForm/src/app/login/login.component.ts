import { Component, OnInit} from '@angular/core';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import {ConfigService} from '../service/service';
import { LoginSetData } from '../utility/utility';

@Component({
  selector: 'app-root',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  
})

export class LoginComponent { 
  errorMsg : string = "";
  pass_word : string = "";
  username : string = "";
  encryptedPsssword : string  = "";

    constructor(private configService: ConfigService, private router: Router ) {}

    ngOnInit(): void {
      this.router.events.subscribe(event => {
        if (event instanceof NavigationEnd && this.router.url === '/') {
          this.errorMsg = '';
          this.username = '';
          this.pass_word = '';
        }
      });
    }

    

    goLogin( ){
      this.configService.getEncryptedPassword(this.pass_word).then((encryptedString: string) => {
        const data = {
          "email": this.username,
          "password": encryptedString
        };
        this.configService.postData("http://localhost:8080/login/login",data).subscribe(
          response => {
            console.log( response.message);
            if(response.message == 'okay'){
              LoginSetData();
              this.router.navigate(['/dashboard']);
            }else{
              this.errorMsg = response.message;
            }
          },
          error => {
            this.errorMsg = "No Connection Here!!"
          }
        )
      });
      
    }

    isLoginRoute(): boolean {
      // Check if the current route matches the dashboard route
      return this.router.url === '/';
    }
    
    
}
