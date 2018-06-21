import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { QuizOneComponent } from '../../quiz-one/quiz-one.component';
import { QuizThreeComponent } from '../../quiz-three/quiz-three.component';
import { QuizFourComponent } from '../../quiz-four/quiz-four.component';

import {
  MatButtonModule,
  MatInputModule,
  MatRippleModule,
  MatTooltipModule,
} from '@angular/material';
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    MatButtonModule,
    MatRippleModule,
    MatInputModule,
    MatTooltipModule,
  ],
  declarations: [
    QuizOneComponent,
    QuizThreeComponent,
    QuizFourComponent
  ]
})

export class AdminLayoutModule {}
