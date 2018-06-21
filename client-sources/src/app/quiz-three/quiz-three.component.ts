import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {StewardServiceService} from "./../services/steward-service.service";
import {Notify} from "./../entities/common/notify";

declare interface Data {
    input: Array<number>;
}

@Component({
    selector: 'app-quiz-three',
    templateUrl: './quiz-three.component.html',
    styleUrls: ['./quiz-three.component.scss']
})
export class QuizThreeComponent implements OnInit {

    data: Data = { input: [] };
    elements: Array<number> = [0];
    response: boolean;

    constructor(private stewardService: StewardServiceService<Data, boolean>, private notify: Notify) { }

    ngOnInit() {
    }
    
    addField(){
        this.elements.push(this.elements.length);
    }
    
    resetFields(){
        this.data.input = [];
        this.elements = [0];
    }
    
    onSubmit(form: NgForm){
        this.stewardService.postJson("/validate-triplex", this.data).subscribe(response => {
            if (response.code == 200){
                this.notify.showSuccess("Processed request successfully");
                this.response = response.data;
            }else{
                this.notify.showDanger(response.message);
            }
          });
    }

}
