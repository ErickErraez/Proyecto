import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnteratesComponent } from './enterates.component';

describe('EnteratesComponent', () => {
  let component: EnteratesComponent;
  let fixture: ComponentFixture<EnteratesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnteratesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnteratesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
