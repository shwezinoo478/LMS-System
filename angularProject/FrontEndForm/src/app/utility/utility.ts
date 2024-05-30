import { Injectable } from "@angular/core";
import { RouterOutlet } from "@angular/router";

declare global {
    var url_Str : String ;
    var course_img_path : String;
    var isLogin : boolean ;
    var alreadyLoginAlert : String;
    var successLogin : String ;
}

export function LoginSetData () {
    
        window.url_Str = "http://localhost:4200/";
        window.course_img_path = "http://localhost:4200/assets/img_path/";
        window.isLogin = true;
    
 };