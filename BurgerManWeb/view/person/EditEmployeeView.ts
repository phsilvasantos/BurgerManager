/// <reference path="EmployeeView.ts" />

class EditEmployeeView extends EmployeeView {
   private _profile: Map<string, string>
   private addButton: HTMLButtonElement
   private attributeInput: HTMLInputElement
   private cancelButton: HTMLButtonElement
   private okButton: HTMLButtonElement
   private profileField: HTMLParagraphElement
   private valueInput: HTMLInputElement

   constructor() {
      super()
      this._profile = new Map<string, string>()

      this.scene.appendChild(document.createElement("hr"))
      this.scene.appendChild(this.createLabel("Perfil", "attribute_input"))

      this.profileField = document.createElement("p")
      this.scene.appendChild(this.profileField)

      this.attributeInput = this.createInput("text", "attribute_input")
      this.attributeInput.placeholder = "Atributo"
      this.scene.appendChild(this.attributeInput)

      this.valueInput = this.createInput("text")
      this.valueInput.placeholder = "Valor"
      this.scene.appendChild(this.valueInput)

      this.addButton = this.createButton("+")
      this.addButton.addEventListener("click", this.handleAdd.bind(this))
      this.scene.appendChild(this.addButton)

      this.scene.appendChild(document.createElement("hr"))

      this.okButton = this.createButton("OK")
      this.scene.appendChild(this.okButton)

      this.cancelButton = this.createButton("Cancelar")
      this.scene.appendChild(this.cancelButton)
   }

   private handleAdd(_event: MouseEvent) {
      let attribute = this.attributeInput.value.toLowerCase()

      if (attribute === "cpf") {
         this.log(true, "Atributo inválido.")
         return
      }

      let value = this.valueInput.value

      if (attribute === "email" || attribute === "e-mail")
         this.emailInput.value = value
      else if (attribute === "nome")
         this.nameInput.value = value
      else {
         this._profile.set(attribute, value)
         this.displayProfile()
      }
   }

   get profile() {
      return new Map<string, string>(this._profile)
   }

   set profile(profile) {
      this._profile.clear()

      for (let [attribute, value] of profile)
         this.profile.set(attribute, value)

      this.displayProfile()
   }

   bindCancel(handler: (event:MouseEvent) => void) {
      this.cancelButton.addEventListener("click", handler)
   }

   bindOk(handler: (event: MouseEvent) => void) {
      this.okButton.addEventListener("click", handler)
   }

   clear() {
      super.clear()
      this.attributeInput.value = ""
      this.valueInput.value = ""
   }

   private displayProfile() {
      this.profileField.innerHTML = ""

      for (let attribute in this.profile) {
         if (this.profileField.firstChild)
            this.profileField.appendChild(document.createElement("br"))

         this.profileField.appendChild(
            document.createTextNode(attribute + ": " + this.profile[attribute])
         )
      }
   }
}