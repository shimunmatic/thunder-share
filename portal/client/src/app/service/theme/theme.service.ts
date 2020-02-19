import { Injectable } from '@angular/core';
import { OverlayContainer } from '@angular/cdk/overlay';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private _isLight = new BehaviorSubject<boolean>(true);
  isLight$ = this._isLight.asObservable();

  constructor(private overlayContainer: OverlayContainer) {
    this.setLight();
  }

  setDark() {
    this.getDocumentBody().classList.remove('light-theme');
    this.getDocumentBody().classList.add('dark-theme');
    this.getOverlayBody().classList.remove('light-theme');
    this.getOverlayBody().classList.add('dark-theme');
    this._isLight.next(false);
  }

  setLight() {
    this.getDocumentBody().classList.remove('dark-theme');
    this.getDocumentBody().classList.add('light-theme');
    this.getOverlayBody().classList.remove('dark-theme');
    this.getOverlayBody().classList.add('light-theme');
    this._isLight.next(true);
  }

  private getDocumentBody() {
    return document.body;
  }

  private getOverlayBody() {
    return this.overlayContainer.getContainerElement();
  }

}
