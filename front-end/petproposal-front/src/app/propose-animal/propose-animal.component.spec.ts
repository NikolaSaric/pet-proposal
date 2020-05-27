import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProposeAnimalComponent } from './propose-animal.component';

describe('ProposeAnimalComponent', () => {
  let component: ProposeAnimalComponent;
  let fixture: ComponentFixture<ProposeAnimalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProposeAnimalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProposeAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
