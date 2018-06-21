import { Component, OnInit } from '@angular/core';
import {StewardServiceService} from "./../services/steward-service.service";
import {Notify} from "./../entities/common/notify";
import {NgForm} from "@angular/forms";

declare interface Data{
    inputString: string;
}

@Component({
  selector: 'app-quiz-four',
  templateUrl: './quiz-four.component.html',
  styleUrls: ['./quiz-four.component.scss']
})
export class QuizFourComponent implements OnInit {
    
    data: Data = {inputString: null};
    response: string = "";

  constructor(private stewardService: StewardServiceService<Data, string>, private notify: Notify) { }

  ngOnInit() {
  }
  
  onSubmit(form: NgForm){
      this.stewardService.postFormData("/compile-blocks", this.data).subscribe(response => {
          if (response.code == 200){
              this.response = response.data;
              this.notify.showSuccess("Request processed successfully");
              form.resetForm();
          } else {
              this.notify.showDanger(response.message);
          }
        });
  }

}
