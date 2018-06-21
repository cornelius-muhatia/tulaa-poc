import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizThreeComponent } from './quiz-three.component';

describe('QuizThreeComponent', () => {
  let component: QuizThreeComponent;
  let fixture: ComponentFixture<QuizThreeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuizThreeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizThreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
