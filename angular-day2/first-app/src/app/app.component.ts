import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name = 'Max';
  firstName : string = 'Moriez';
  lastName : string = 'joe';
  isDisabled : boolean = false;
  imagePath  = 'https://www.udemy.com/staticx/udemy/images/v6/logo-coral-light.svg';
  classesToApply: string = 'italicsClass boldClass';
  username = '';

  getFullName() : String{

    return this.firstName +' '+this.lastName;
  }
  onCLick():void {
     console.log('Button Clicked');
  }
}
