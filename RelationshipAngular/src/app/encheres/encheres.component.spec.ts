import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncheresComponent } from './encheres.component';

describe('EncheresComponent', () => {
  let component: EncheresComponent;
  let fixture: ComponentFixture<EncheresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EncheresComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EncheresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
