import { Routes } from '@angular/router';

import { QuizOneComponent } from '../../quiz-one/quiz-one.component';
import { QuizThreeComponent } from '../../quiz-three/quiz-three.component';
import { QuizFourComponent } from '../../quiz-four/quiz-four.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'quiz-one', component: QuizOneComponent },
    { path: 'quiz-three', component: QuizThreeComponent },
    { path: 'quiz-four', component: QuizFourComponent }
];
