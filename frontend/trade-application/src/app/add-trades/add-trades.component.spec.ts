import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTradesComponent } from './add-trades.component';

describe('AddTradesComponent', () => {
  let component: AddTradesComponent;
  let fixture: ComponentFixture<AddTradesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTradesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
