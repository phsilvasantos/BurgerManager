let cpfPattern = "\\d{3}.\\d{3}.\\d{3}-\\d{2}"
let FormatException = "Formato incorreto."

/** @abstract */
class View {
   /** @param {HTMLDivElement} stage */
   constructor(stage) {
      this.stage = stage
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
   createLabel(targetId, text) {
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

   open() {
      this.stage.innerHTML = ""
      this.stage.appendChild(this.scene)
   }
}

/** @abstract */
class PersonView extends View {
   /** @param {HTMLDivElement} stage */
   constructor(stage) {
      super(stage)

      this.scene.appendChild(this.createLabel("cpf_input", "CPF"))
      this.scene.appendChild(document.createElement("br"))

      this.cpfInput = this.createInput("text", "cpf_input")
      this.cpfInput.pattern = cpfPattern
      this.scene.appendChild(this.cpfInput)

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("name_input", "Nome"))
      this.scene.appendChild(document.createElement("br"))

      this.nameInput = this.createInput("text", "name_input")
      this.scene.appendChild(this.nameInput)

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("email_input", "E-mail"))
      this.scene.appendChild(document.createElement("br"))

      this.emailInput = this.createInput("email", "email_input")
      this.scene.appendChild(this.emailInput)

      this.scene.appendChild(document.createElement("hr"))

      this.okButton = this.createButton("OK")
      this.scene.appendChild(this.okButton)

      this.cancelButton = this.createButton("Cancelar")
      this.scene.appendChild(this.cancelButton)
   }

   /** @param {(ev: MouseEvent) => void} handler */
   bindCancel(handler) {
      this.cancelButton.addEventListener("click", handler)
   }

   /** @param {(person: Person) => void} handler */
   bindOk(handler) {
      this.okButton.addEventListener("click", (_ev) => {
         if (!this.checkValidity()) {
            alert(FormatException)
            return
         }

         let person = this.createPerson()
         handler(person)
      })
   }

   checkValidity() {
      return this.cpfInput.checkValidity() && this.emailInput.checkValidity()
   }

   clearInfo() {
      this.cpfInput.value = ""
      this.emailInput.value = ""
      this.nameInput.value = ""
   }

   /** @abstract @returns {Person}*/
   createPerson() {}

   /** @param {Person} person */
   getInfo(person) {
      person.email = this.emailInput.value
      person.name = this.nameInput.value
   }

   open() {
      this.clearInfo()
      super.open()
   }

   /** @param {Person} person */
   setInfo(person) {
      this.cpfInput.value = person.cpf
      this.emailInput.value = person.email
      this.nameInput.value = person.name
   }
}

class NewClientView extends PersonView {
   /** @param {HTMLDivElement} stage */
   constructor(stage) {
      super(stage)

      let nextSibling = this.emailInput.nextSibling

      this.scene.insertBefore(document.createElement("br"), nextSibling)
      this.scene.insertBefore(this.createLabel("street_input", "Endereço"), nextSibling)
      this.scene.insertBefore(document.createElement("br"), nextSibling)

      this.streetInput = this.createInput("text", "street_input")
      this.streetInput.placeholder = "Rua"
      this.scene.insertBefore(this.streetInput, nextSibling)

      this.numberInput = this.createInput("number", "number_input")
      this.numberInput.placeholder = "Número"
      this.scene.insertBefore(this.numberInput, nextSibling)

      this.districtInput = this.createInput("text", "district_input")
      this.districtInput.placeholder = "Bairro"
      this.scene.insertBefore(this.districtInput, nextSibling)
   }

   get address() {
      let district = this.districtInput.value
      let number = parseInt(this.numberInput.value)
      let street = this.streetInput.value
      return new Address(number, street, district)
   }

   set address(address) {
      if (address) {
         this.districtInput.value = address.district
         this.numberInput.value = address.number
         this.streetInput.value = address.street
      } else {
         this.districtInput.value = ""
         this.numberInput.value = ""
         this.streetInput.value = ""
      }
   }

   checkValidity() {
      return super.checkValidity() && this.districtInput.value !== "" &&
         this.numberInput.checkValidity() && this.streetInput.value !== ""
   }

   clearInfo() {
      super.clearInfo()
      this.address = undefined
   }

   createPerson() {
      let client = new Client(this.cpfInput.value, this.address)
      this.getInfo(client)
      return client
   }
}

class NewEmployeeView extends PersonView {
   /** @param {HTMLDivElement} stage */
   constructor(stage) {
      super(stage)

      let nextSibling = this.emailInput.nextSibling

      this.scene.insertBefore(document.createElement("br"), nextSibling)
      this.scene.insertBefore(this.createLabel("type_select", "Função"), nextSibling)
      this.scene.insertBefore(document.createElement("br"), nextSibling)

      this.typeSelect = this.createSelect("type_select")
      this.scene.insertBefore(this.typeSelect, nextSibling)
   }

   /** @param {{[key: string]: Factory}} factories */
   bindFactories(factories) {
      this.factories = factories
      this.typeSelect.innerHTML = ""

      for (let key in factories)
         this.typeSelect.appendChild(this.createOption(key, factories[key].tag))
   }

   createPerson() {
      let employee = this.factories[this.typeSelect.value].create(this.cpfInput.value)
      this.getInfo(employee)
      return employee
   }
}

class PrimaryView extends View {
   /** @param {HTMLDivElement} stage */
   constructor(stage) {
      super(stage)

      this.scene.appendChild(this.createLabel("cpf_input", "CPF"))
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
            alert(FormatException)
            return
         }

         handler(this.cpfInput.value)
      })
   }
}

class SignInView extends View {
   /** @param {HTMLDivElement} stage */
   constructor(stage) {
      super(stage)

      this.personInfo = document.createElement("span")
      this.scene.appendChild(this.personInfo)

      this.scene.appendChild(document.createElement("hr"))
      this.scene.appendChild(this.createLabel("action_select", "Ação"))
      this.scene.appendChild(document.createElement("br"))

      this.actionSelect = this.createSelect("action_select")
      this.scene.appendChild(this.actionSelect)

      this.executeButton = this.createButton("Executar")

      this.executeButton.addEventListener("click", (_ev) => {
         this.actions[this.actionSelect.value].execute()
      })

      this.scene.appendChild(this.executeButton)

      this.scene.appendChild(document.createElement("hr"))

      this.closeButton = this.createButton("Sair")
      this.scene.appendChild(this.closeButton)
   }

   /** @param {{[key: string]: Action}} actions */
   bindActions(actions) {
      this.actions = actions
      this.actionSelect.innerHTML = ""

      for (let action in actions)
         this.actionSelect.appendChild(this.createOption(action, actions[action].tag))
   }

   /** @param {(ev: MouseEvent) => void} handler */
   bindClose(handler) {
      this.closeButton.addEventListener("click", handler)
   }

   /** @param {Person} person */
   setInfo(person) {
      this.personInfo.innerHTML = ""
      this.personInfo.appendChild(document.createTextNode(person.type + ": " + person.name))
   }
}