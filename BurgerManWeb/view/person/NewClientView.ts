/// <reference path="PersonView.ts" />

class NewClientView extends PersonView {
   private cancelButton: HTMLButtonElement
   private districtInput: HTMLInputElement
   private numberInput: HTMLInputElement
   private okButton: HTMLButtonElement
   private streetInput: HTMLInputElement

   constructor() {
      super()

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("Endereço", "street_input"))
      this.scene.appendChild(document.createElement("br"))

      this.streetInput = this.createInput("text", "street_input")
      this.streetInput.placeholder = "Rua"
      this.scene.appendChild(this.streetInput)

      this.numberInput = this.createInput("number")
      this.numberInput.placeholder = "Número"
      this.scene.appendChild(this.numberInput)

      this.districtInput = this.createInput("text")
      this.districtInput.placeholder = "Bairro"
      this.scene.appendChild(this.districtInput)

      this.scene.appendChild(document.createElement("hr"))

      this.okButton = this.createButton("OK")
      this.scene.appendChild(this.okButton)

      this.cancelButton = this.createButton("Cancelar")
      this.scene.appendChild(this.cancelButton)
   }

   get district() {
      let district = this.districtInput.value

      if (district === "")
         throw View.formatException

      return district
   }

   set district(district: string) {
      this.districtInput.value = district
   }

   get number() {
      if (!this.numberInput.checkValidity())
         throw View.formatException

      return parseInt(this.numberInput.value)
   }

   set number(number: number) {
      this.numberInput.value = number.toString()
   }

   get street() {
      let street = this.streetInput.value

      if (street === "")
         throw View.formatException

      return street
   }

   set street(street: string) {
      this.streetInput.value = street
   }

   bindCancel(handler: (event: MouseEvent) => void) {
      this.cancelButton.addEventListener("click", handler)
   }

   bindOk(handler: (event: MouseEvent) => void) {
      this.okButton.addEventListener("click", handler)
   }

   clear() {
      super.clear()
      this.districtInput.value = ""
      this.numberInput.value = ""
      this.streetInput.value = ""
   }
}