import { Component } from '@angular/core';
import { ConfigService } from '../service/service'
import {  Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  
  constructor(private configService: ConfigService, private router: Router ) { }
  username : string = "";
  email_txt : string = "";
  gender : string = "";
  password_chk : string = "";
  password_txt : string = "";

  err_message : string = "";
  err_pass_msg : string = "";
  err_Register_msg : Boolean = false;

  goRegister(){
    if(this.validateRadio() && this.validateFormInput()){
      this.configService.getEncryptedPassword(this.password_txt).then((encryptedString: string) => {
        
        const data = {
          "name": this.username,
          "email": this.email_txt,
          "password": encryptedString,
          "gender": this.gender
        };
        this.configService.postData("http://localhost:8080/login/register",data).subscribe(
          response => {
            console.log(response.message);
            if(response.message !== 'successful'){
              this.err_Register_msg = true ;  
            }else{
              this.router.navigate(['/']);
            }
        },
        error => {
          console.log("No Connection Here!!")
        }
      );

        console.log(this.password_chk);
      });
      
    }
   
  }
 
  goLoginClick(){
    this.router.navigate(['/']);
  }


  OnCheckPassword(){
    if(this.password_txt.trim() == this.password_chk.trim() && this.password_txt.trim()!='')
      this.err_pass_msg = "";
    else if(this.password_txt == '')
      this.err_pass_msg = "Type your password First!"
    else
      this.err_pass_msg = " Passwords are not same!";
  }


  validateFormInput() {
    var result  = false;
    if(!this.username.trim())
      this.err_message = 'Please enter your Name!';
    else if(!this.email_txt.trim())
      this.err_message = 'Please enter your Email!';
    else{
      result  = true;
      this.err_message = '';
    }
      
    return result;
  }
  
  validateRadio(){
    var result  = false;
    if(!this.gender)
      this.err_message = 'Please Select your Gender!';
    else{
      result  = true;
      this.err_message = '';
    }
    return result;
  }
}
