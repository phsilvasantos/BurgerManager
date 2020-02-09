/// <reference path="PersonView.ts" />

class NewEmployeeView extends PersonView {
   private cancelButton: HTMLButtonElement
   private okButton: HTMLButtonElement
   private typeSelect: HTMLSelectElement

   constructor() {
      super()

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("Função", "type_select"))
      this.scene.appendChild(document.createElement("br"))

      this.typeSelect = this.createSelect("type_select")
      this.scene.appendChild(this.typeSelect)

      this.scene.appendChild(document.createElement("hr"))

      this.okButton = this.createButton("OK")
      this.scene.appendChild(this.okButton)

      this.cancelButton = this.createButton("Cancelar")
      this.scene.appendChild(this.cancelButton)
   }

   get type() {
      return this.typeSelect.value
   }

   set types(types: {[type: string]: string}) {
      this.typeSelect.innerHTML = ""

      for (let type in types)
         this.typeSelect.appendChild(this.createOption(type, types[type]))
   }

   bindCancel(handler: (event: MouseEvent) => void) {
      this.cancelButton.addEventListener("click", handler)
   }

   bindOk(handler: (event: MouseEvent) => void) {
      this.okButton.addEventListener("click", handler)
   }
}