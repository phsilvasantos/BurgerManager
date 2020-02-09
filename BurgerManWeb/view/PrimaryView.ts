/// <reference path="View.ts" />

class PrimaryView extends View {
   private cpfInput: HTMLInputElement
   private newClientButton: HTMLButtonElement
   private newEmployeeButton: HTMLButtonElement
   private signInButton: HTMLButtonElement

   constructor() {
      super()

      this.scene.appendChild(this.createLabel("CPF", "cpf_input"))
      this.scene.appendChild(document.createElement("br"))

      this.cpfInput = this.createInput("text", "cpf_input")
      this.cpfInput.pattern = "(" + View.cpfPattern + "|gerente)"
      this.scene.appendChild(this.cpfInput)

      this.signInButton = this.createButton("Entrar")
      this.scene.appendChild(this.signInButton)

      this.scene.appendChild(document.createElement("hr"))

      this.newClientButton = this.createButton("Novo cliente")
      this.scene.appendChild(this.newClientButton)

      this.newEmployeeButton = this.createButton("Novo funcionário")
      this.scene.appendChild(this.newEmployeeButton)
   }

   get cpf() {
      if (!this.cpfInput.checkValidity())
         throw View.formatException
      return this.cpfInput.value
   }

   bindNewClient(handler: (event: MouseEvent) => void) {
      this.newClientButton.addEventListener("click", handler)
   }

   bindNewEmployee(handler: (event: MouseEvent) => void) {
      this.newEmployeeButton.addEventListener("click", handler)
   }

   bindSignIn(handler: (event: MouseEvent) => void) {
      this.signInButton.addEventListener("click", handler)
   }
}