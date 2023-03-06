import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriceformComponent } from './priceform.component';

describe('PriceformComponent', () => {
  let component: PriceformComponent;
  let fixture: ComponentFixture<PriceformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PriceformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriceformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
