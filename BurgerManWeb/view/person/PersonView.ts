/// <reference path="../View.ts" />

class PersonView extends View {
   protected cpfInput: HTMLInputElement
   protected emailInput: HTMLInputElement
   protected nameInput: HTMLInputElement

   constructor() {
      super()

      this.scene.appendChild(this.createLabel("CPF", "cpf_input"))
      this.scene.appendChild(document.createElement("br"))

      this.cpfInput = this.createInput("text", "cpf_input")
      this.cpfInput.pattern = View.cpfPattern
      this.scene.appendChild(this.cpfInput)

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("Nome", "name_input"))
      this.scene.appendChild(document.createElement("br"))

      this.nameInput = this.createInput("text", "name_input")
      this.scene.appendChild(this.nameInput)

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("E-mail", "email_input"))
      this.scene.appendChild(document.createElement("br"))

      this.emailInput = this.createInput("email", "email_input")
      this.scene.appendChild(this.emailInput)
   }

   get cpf() {
      if (!this.cpfInput.checkValidity())
         throw View.formatException

      return this.cpfInput.value
   }

   set cpf(cpf: string) {
      this.cpfInput.value = cpf
   }

   get email() {
      if (!this.emailInput.checkValidity())
         throw View.formatException

      return this.emailInput.value
   }

   set email(email: string) {
      this.emailInput.value = email
   }

   get name() {
      let name = this.nameInput.value

      if (name === "")
         throw View.formatException

      return name
   }

   set name(name: string) {
      this.nameInput.value = name
   }

   clear() {
      this.cpfInput.value = ""
      this.emailInput.value = ""
      this.nameInput.value = ""
   }
}