import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(private loginService: LoginService) {}

  onSingUp(form: NgForm) {
    this.loginService.addClienti(form.value).subscribe((data) => {
      console.log(data);
    });
  }

  onSingIn(form: NgForm) {
    console.log(form);
  }
}