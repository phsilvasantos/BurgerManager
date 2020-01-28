class Model {
   constructor() {
      this.clients = []
      this.employees = []
   }
}

class PrimaryView {
   constructor() {
      this.stage = document.querySelector("#stage")
      this.scene = document.createElement("div")

      let label = document.createElement("label")
      label.setAttribute("for", "cpf_input")
      label.textContent = "CPF"
      this.scene.appendChild(label)

      this.scene.appendChild(document.createElement("br"))

      this.cpfInput = document.createElement("input")
      this.cpfInput.id = "cpf_input"
      this.cpfInput.type = "text"
      this.scene.appendChild(this.cpfInput)

      this.signInButton = document.createElement("button")
      this.signInButton.textContent = "Entrar"
      this.signInButton.type = "button"
      this.scene.appendChild(this.signInButton)

      this.scene.appendChild(document.createElement("hr"))

      this.newClientButton = document.createElement("button")
      this.newClientButton.textContent = "Novo cliente"
      this.newClientButton.type = "button"
      this.scene.appendChild(this.newClientButton)

      this.newEmployeeButton = document.createElement("button")
      this.newEmployeeButton.textContent = "Novo funcionário"
      this.newEmployeeButton.type = "button"
      this.scene.appendChild(this.newEmployeeButton)
   }

   open() {
      this.stage.innerHTML = ""
      this.stage.appendChild(this.scene)
   }
}

class PrimaryController {
   constructor() {
      this.model = new Model()
      this.view = new PrimaryView()
      //this.signInController = new SignInController(model)
      //this.newClientController = new ...
      //...

      this.view.open()
   }
}

let app = new PrimaryController()