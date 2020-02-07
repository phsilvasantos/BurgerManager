let cpfPattern = "\\d{3}.\\d{3}.\\d{3}-\\d{2}"
let FormatException = "Formato incorreto."

/** @abstract */
class View {
   constructor() {
      this.scene = document.createElement("div")
   }

   /** @param {string} text */
   createButton(text) {
      let button = document.createElement("button")
      button.textContent = text
      button.type = "button"
      return button
   }

   /** @param {string} type @param {string} [id] */
   createInput(type, id) {
      let input = document.createElement("input")
      input.type = type

      if (id)
         input.id = id

      return input
   }

   /** @param {string} targetId @param {string} text */
   createLabel(text, targetId) {
      let label = document.createElement("label")
      label.setAttribute("for", targetId)
      label.textContent = text
      return label
   }

   /** @param {string} value @param {string} text */
   createOption(value, text) {
      let option = document.createElement("option")
      option.value = value
      option.textContent = text
      return option
   }

   /** @param {string} id */
   createSelect(id) {
      let select = document.createElement("select")
      select.id = id
      return select
   }

   /** @param {boolean} error @param {string} [message] */
   log(error, message) {
      if (error)
         View.log.classList.add("error")
      else
         View.log.classList.remove("error")

      if (message)
         View.log.innerHTML = message
      else
         View.log.innerHTML = "-"
   }

   open() {
      View.stage.innerHTML = ""
      View.stage.appendChild(this.scene)
   }
}

View.log = document.querySelector("#log")
View.stage = document.querySelector("#stage")

class PrimaryView extends View {
   constructor() {
      super()

      this.scene.appendChild(this.createLabel("CPF", "cpf_input"))
      this.scene.appendChild(document.createElement("br"))

      this.cpfInput = this.createInput("text", "cpf_input")
      this.cpfInput.pattern = "(" + cpfPattern + "|gerente)"
      this.scene.appendChild(this.cpfInput)

      this.signInButton = this.createButton("Entrar")
      this.scene.appendChild(this.signInButton)

      this.scene.appendChild(document.createElement("hr"))

      this.newClientButton = this.createButton("Novo cliente")
      this.scene.appendChild(this.newClientButton)

      this.newEmployeeButton = this.createButton("Novo funcionário")
      this.scene.appendChild(this.newEmployeeButton)
   }

   /** @param {(ev: MouseEvent) => void} handler */
   bindNewClient(handler) {
      this.newClientButton.addEventListener("click", handler)
   }

   /** @param {(ev: MouseEvent) => void} handler */
   bindNewEmployee(handler) {
      this.newEmployeeButton.addEventListener("click", handler)
   }

   /** @param {(cpf: string) => void} handler */
   bindSignIn(handler) {
      this.signInButton.addEventListener("click", (_ev) => {
         if (!this.cpfInput.checkValidity()) {
            this.log(true, FormatException)
            return
         }

         handler(this.cpfInput.value)
      })
   }
}

class SignInView extends View {
   constructor() {
      super()

      this.scene.appendChild(this.createLabel("Ação", "action_select"))
      this.scene.appendChild(document.createElement("br"))

      this.actionSelect = this.createSelect("action_select")
      this.scene.appendChild(this.actionSelect)

      this.executeButton = this.createButton("Executar")

      /*this.executeButton.addEventListener("click", (_ev) => {
         this.actions[this.actionSelect.value].execute(this._person)
      })*/

      this.scene.appendChild(this.executeButton)

      this.scene.appendChild(document.createElement("hr"))

      this.signOutButton = this.createButton("Sair")
      this.scene.appendChild(this.signOutButton)
   }

   /** @param {{[action: string]: string}} actions */
   set actions(actions) {
      this.actionSelect.innerHTML = ""

      for (let action in actions)
         this.actionSelect.appendChild(this.createOption(action, actions[action]))
   }

   /** @param {(action: string) => void} handler */
   bindExecute(handler) {
      this.executeButton.addEventListener("click", (_ev) => {
         handler(this.actionSelect.value)
      })
   }

   /** @param {(ev: MouseEvent) => void} handler */
   bindSignOut(handler) {
      this.signOutButton.addEventListener("click", handler)
   }
}