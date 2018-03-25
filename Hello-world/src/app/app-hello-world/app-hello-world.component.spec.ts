import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppHelloWorldComponent } from './app-hello-world.component';

describe('AppHelloWorldComponent', () => {
  let component: AppHelloWorldComponent;
  let fixture: ComponentFixture<AppHelloWorldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppHelloWorldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppHelloWorldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
