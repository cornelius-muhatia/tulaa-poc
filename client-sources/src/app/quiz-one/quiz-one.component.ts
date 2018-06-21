import { Component, OnInit } from '@angular/core';
import {StewardServiceService} from "./../services/steward-service.service";
import {Notify} from "./../entities/common/notify";
import {NgForm} from "@angular/forms";

declare interface Data{
    inputString: string;
}

@Component({
  selector: 'app-quiz-one',
  templateUrl: './quiz-one.component.html',
  styleUrls: ['./quiz-one.component.scss']
})
export class QuizOneComponent implements OnInit {
    
    data: Data = {inputString: null};
    response: string = "";

  constructor(private stewardService: StewardServiceService<Data, string>, private notify: Notify) { }

  ngOnInit() {
  }
  /**
   * Used to send user input to the backend service.
   */
  onSubmit(form: NgForm){
      this.stewardService.postFormData("/reverse-string", this.data).subscribe(response => {
          if (response.code == 200){
              this.response = response.data;
              this.notify.showSuccess("Request processed successfully");
          } else {
              this.notify.showDanger(response.message);
          }
        });
  }

}
