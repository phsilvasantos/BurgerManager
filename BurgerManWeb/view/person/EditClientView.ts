/// <reference path="NewClientView.ts" />

class EditClientView extends NewClientView {
   constructor() {
      super()
      this.cpfInput.readOnly = true
   }
}