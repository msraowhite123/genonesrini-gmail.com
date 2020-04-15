import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'employeetitlepipe'
})
export class EmployeetitlepipePipe implements PipeTransform {

  transform(value: string,gender:string): any {
   if (gender.toLowerCase() == "male")
            return "Mr." + value;
        else
            return "Miss." + value;
  }

}
