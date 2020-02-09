/// <reference path="PersonView.ts" />

class EmployeeView extends PersonView {
   private typeInput: HTMLInputElement

   constructor() {
      super()
      this.cpfInput.readOnly = true

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("Função", "type_input"))
      this.scene.appendChild(document.createElement("br"))

      this.typeInput = this.createInput("text", "type_input")
      this.typeInput.readOnly = true
      this.scene.appendChild(this.typeInput)
   }

   get type() {
      return this.typeInput.value
   }

   set type(type: string) {
      this.typeInput.value = type
   }

   clear() {
      super.clear()
      this.typeInput.value = ""
   }
}