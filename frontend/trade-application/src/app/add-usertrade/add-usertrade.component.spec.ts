import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUsertradeComponent } from './add-usertrade.component';

describe('AddUsertradeComponent', () => {
  let component: AddUsertradeComponent;
  let fixture: ComponentFixture<AddUsertradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUsertradeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUsertradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
