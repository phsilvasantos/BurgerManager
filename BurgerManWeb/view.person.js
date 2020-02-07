/** @abstract */
class PersonView extends View {
   constructor() {
      super()

      this.scene.appendChild(this.createLabel("CPF", "cpf_input"))
      this.scene.appendChild(document.createElement("br"))

      this.cpfInput = this.createInput("text", "cpf_input")
      this.cpfInput.pattern = cpfPattern
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

   checkValidity() {
      return this.cpfInput.checkValidity() &&
         this.emailInput.checkValidity() && this.nameInput.value !== ""
   }

   /** @param {string} [cpf] @param {string} [email] @param {string} [name] */
   setInfo(cpf, name, email) {
      this.cpfInput.value = cpf ? cpf : ""
      this.emailInput.value = email ? email : ""
      this.nameInput.value = name ? name : ""
   }
}

class NewClientView extends PersonView {
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

   /** @param {(ev: MouseEvent) => void} handler */
   bindCancel(handler) {
      this.cancelButton.addEventListener("click", handler)
   }

   /**
    * @param {(
         cpf: string, name: string, email: string,
         street: string, number: number, district: string
      ) => void} handler
    */
   bindOk(handler) {
      this.okButton.addEventListener("click", (_ev) => {
         if (!this.checkValidity()) {
            this.log(true, FormatException)
            return
         }

         let cpf = this.cpfInput.value
         let district = this.districtInput.value
         let email = this.emailInput.value
         let name = this.nameInput.value
         let number = parseInt(this.numberInput.value)
         let street = this.streetInput.value
         handler(cpf, name, email, street, number, district)
      })
   }

   checkValidity() {
      return super.checkValidity() && this.districtInput.value !== "" &&
         this.numberInput.checkValidity() && this.streetInput.value !== ""
   }

   /**
    * @param {string} [cpf] @param {string} [district] @param {string} [email]
    * @param {string} [name] @param {number} [number] @param {string} [street]
    */
   setInfo(cpf, name, email, street, number, district) {
      super.setInfo(cpf, name, email)
      this.districtInput.value = district ? district : ""
      this.numberInput.value = number ? number : ""
      this.streetInput.value = street ? street : ""
   }
}

class EditClientView extends NewClientView {
   constructor() {
      super()
      this.cpfInput.readOnly = true
   }
}

class EmployeeView extends PersonView {
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

   /**
    * @param {string} [cpf] @param {string} [email] @param {string} [name] @param {string} [type]
    */
   setInfo(type, cpf, name, email) {
      super.setInfo(cpf, name, email)
      this.typeInput.value = type ? type : ""
   }
}

class AddEmployeesView extends EmployeeView {
   constructor() {
      super()
      /** @type {Employee[]} */ this.addedEmployees = []
      this.emailInput.readOnly = true
      this.nameInput.readOnly = true

      let child = this.scene.firstChild

      this.scene.insertBefore(this.createLabel("Candidato", "employee_select"), child)
      this.scene.insertBefore(document.createElement("br"), child)

      this.candidateSelect = this.createSelect("employee_select")
      this.scene.insertBefore(this.candidateSelect, child)

      this.candidateSelect.appendChild(this.createOption("-1", "-"))

      this.addButton = this.createButton("Adicionar")
      this.scene.insertBefore(this.addButton, child)

      this.scene.insertBefore(document.createElement("hr"), child)
      this.scene.appendChild(document.createElement("hr"))

      this.closeButton = this.createButton("Fechar")
      this.scene.appendChild(this.closeButton)
   }

   /** @param {string[]} candidates */
   set candidates(candidates) {
      let option = this.candidateSelect.options[0]
      this.candidateSelect.innerHTML = ""
      this.candidateSelect.appendChild(option)

      for (let index = 0; index < candidates.length; index++)
         this.candidateSelect.appendChild(this.createOption(index, candidates[index]))
   }

   /** @param {(index: number) => void} handler */
   bindAdd(handler) {
      this.addButton.addEventListener("click", (_ev) => {
         let index = this.candidateSelect.selectedIndex
         if (index !== 0)
            handler(index - 1)
      })
   }

   /** @param {(ev: MouseEvent) => void} handler */
   bindClose(handler) {
      this.closeButton.addEventListener("click", handler)
   }

   /** @param {(index: number) => void} handler */
   bindSelect(handler) {
      this.candidateSelect.addEventListener("change", (_ev) => {
         let index = this.candidateSelect.selectedIndex
         if (index === 0)
            handler(index - 1)
      })
   }
}

class EditEmployeeView extends EmployeeView {
   constructor() {
      super()

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

      this.addButton.addEventListener("click", (_ev) => {
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
            this.profile[attribute] = value
            this.displayProfile()
         }
      })

      this.scene.appendChild(this.addButton)

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

   /**
    * @param {(
         name: string, email: string, profile: {[attribute: string]: string}
      ) => void} handler
    */
   bindOk(handler) {
      this.okButton.addEventListener("click", (_ev) => {
         if (!this.checkValidity()) {
            this.log(true, FormatException)
            return
         }

         let email = this.emailInput.value
         let name = this.nameInput.value
         handler(name, email, this.profile)
      })
   }

   displayProfile() {
      this.profileField.innerHTML = ""

      for (let attribute in this.profile) {
         if (this.profileField.firstChild)
            this.profileField.appendChild(document.createElement("br"))
         this.profileField.appendChild(
            document.createTextNode(attribute + ": " + this.profile[attribute])
         )
      }
   }

   /**
    * @param {string} cpf @param {string} email @param {string} name
    * @param {{[attribute: string]: string}} profile @param {string} type
    */
   setInfo(type, cpf, name, email, profile) {
      super.setInfo(type, cpf, name, email)
      /** @type {{[attribute: string]: string}} */ this.profile = {}

      for (let attribute in profile)
         this.profile[attribute] = profile[attribute]

      this.displayProfile()
   }
}

class NewEmployeeView extends PersonView {
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

   /** @param {(ev: MouseEvent) => void} handler */
   bindCancel(handler) {
      this.cancelButton.addEventListener("click", handler)
   }

   /** @param {(cpf: string, name: string, email: string, type: string) => void} handler */
   bindOk(handler) {
      this.okButton.addEventListener("click", (_ev) => {
         if (!this.checkValidity()) {
            this.log(true, FormatException)
            return
         }

         let cpf = this.cpfInput.value
         let email = this.emailInput.value
         let name = this.nameInput.value
         let type = this.typeSelect.value
         handler(cpf, name, email, type)
      })
   }

   /** @param {{[type: string]: string}} types */
   setInfo(types) {
      super.setInfo()
      this.typeSelect.innerHTML = ""

      for (let type in types)
         this.typeSelect.appendChild(this.createOption(type, types[type]))
   }
}