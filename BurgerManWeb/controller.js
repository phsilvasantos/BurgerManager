class Command {
   /** @param {(agent: Person) => void} handler @param {string} tag */
   constructor(tag, handler) {
      this.execute = handler
      this.tag = tag
   }
}

class Factory {
   /** @param {(cpf: string) => Employee} handler @param {string} tag */
   constructor(tag, handler) {
      this.create = handler
      this.tag = tag
   }
}

/** @abstract */
class Controller {
   /** @param {Controller} [parent] @param {View} view */
   constructor(view, parent) {
      this.model = Controller.model
      this.view = view

      if (parent)
         this.parent = parent
   }

   /** @param {string} [message] */
   openView(message) {
      this.view.open()
      this.view.log(false, message)
   }
}

Controller.model = new Model()

class AddEmployeesController extends Controller {
   /** @param {Controller} parent */
   constructor(parent) {
      super(new AddEmployeesView(), parent)
      /** @type {AddEmployeesView} */ this.view

      this.view.bindAdd((index) => {
         let employee = this.model.pendingEmployees[index]
         let cpf = employee.cpf

         if (this.model.employees[cpf])
            this.view.log(true, "Funcionário já existente.")
         else {
            this.model.employees[cpf] = employee
            this.model.pendingEmployees.splice(index, 1)

            this.view.candidates = this.model.pendingEmployees.map((employee) => {
               return employee.name
            })

            this.view.log(false, "Funcionário " + employee.name + " adicionado.")
         }
      })

      this.view.bindClose((_ev) => {
         let length = this.model.pendingEmployees.length
         this.model.pendingEmployees.splice(0, length)
         this.parent.openView()
      })

      this.view.bindSelect((index) => {
         if (index < 0 || index >= this.model.pendingEmployees.length) {
            this.view.setInfo()
            return
         }

         let employee = this.model.pendingEmployees[index]
         let cpf = employee.cpf
         let email = employee.email
         let name = employee.name
         let type = employee.type
         this.view.setInfo(type, cpf, name, email)
      })
   }

   /** @param {string} [message] */
   openView(message) {
      this.view.candidates = this.model.pendingEmployees.map((employee) => {
         return employee.name
      })

      super.openView(message)
   }
}

class EditClientController extends Controller {
   /** @param {Controller} parent */
   constructor(parent) {
      super(new EditClientView(), parent)
      /** @type {EditClientView} */ this.view

      this.view.bindCancel((_ev) => {
         this.parent.openView("Alteração cancelada.")
      })

      this.view.bindOk((_cpf, name, email, street, number, district) => {
         this._client.email = email
         this._client.name = name
         this._client.address.district = district
         this._client.address.number = number
         this._client.address.street = street
         this.parent.openView("Perfil de " + name + " alterado.")
      })
   }

   /** @param {Client} client */
   set client(client) {
      this._client = client
   }

   /** @param {string} [message] */
   openView(message) {
      let cpf = this._client.cpf
      let email = this._client.email
      let name = this._client.name
      let district = this._client.address.district
      let number = this._client.address.number
      let street = this._client.address.street
      this.view.setInfo(cpf, name, email, street, number, district)
      super.openView(message)
   }
}

class EditEmployeeController extends Controller {
   /** @param {Controller} parent */
   constructor(parent) {
      super(new EditEmployeeView(), parent)
      /** @type {EditEmployeeView} */ this.view

      this.view.bindCancel((_ev) => {
         this.parent.openView("Alteração cancelada.")
      })

      this.view.bindOk((name, email, profile) => {
         this._employee.email = email
         this._employee.name = name
         this._employee.profile = profile
         this.parent.openView("Perfil de " + name + " alterado.")
      })
   }

   /** @param {Employee} employee */
   set employee(employee) {
      this._employee = employee
   }

   /** @param {string} [message] */
   openView(message) {
      let cpf = this._employee.cpf
      let email = this._employee.email
      let name = this._employee.name
      let type = this._employee.type
      let profile = this._employee.profile
      this.view.setInfo(type, cpf, name, email, profile)
      super.openView(message)
   }
}

class NewClientController extends Controller {
   /** @param {Controller} parent */
   constructor(parent) {
      super(new NewClientView(), parent)
      /** @type {NewClientView} */ this.view

      this.view.bindCancel((_ev) => {
         this.parent.openView("Adição cancelada.")
      })

      this.view.bindOk((cpf, name, email, street, number, district) => {
         let address = new Address(number, street, district)
         let client = new Client(cpf, address)
         client.email = email
         client.name = name
         this.model.clients[cpf] = client
         this.parent.openView("Cliente " + name + " adicionado.")
      })
   }

   /** @param {string} [message] */
   openView(message) {
      this.view.setInfo()
      super.openView(message)
   }
}

class NewEmployeeController extends Controller {
   /** @param {Controller} parent */
   constructor(parent) {
      super(new NewEmployeeView(), parent)
      /** @type {NewEmployeeView} */ this.view

      this.view.bindCancel((_ev) => {
         this.parent.openView("Adição cancelada.")
      })

      /** @type {{[type: string]: Factory}} */
      this.factories = {
         boxer: new Factory(Boxer.type, (cpf) => {return new Boxer(cpf)}),
         cook: new Factory(Cook.type, (cpf) => {return new Cook(cpf)}),
         deliverer: new Factory(Deliverer.type, (cpf) => {return new Deliverer(cpf)}),
         supplier: new Factory(Supplier.type, (cpf) => {return new Supplier(cpf)})
      }

      this.view.bindOk((cpf, name, email, type) => {
         let employee = this.factories[type].create(cpf)
         employee.email = email
         employee.name = name
         this.model.pendingEmployees.push(employee)
         this.parent.openView(
            "Adição de funcionário " + name + " aguardando aprovação."
         )
      })
   }

   /** @param {string} [message] */
   openView(message) {
      /** @type {{[type: string] => string}} */ let types = {}

      for (let type in this.factories)
         types[type] = this.factories[type].tag

      this.view.setInfo(types)
      super.openView(message)
   }
}

class SignInController extends Controller {
   /** @param {Controller} parent */
   constructor(parent) {
      super(new SignInView(), parent)
      this.addEmployeesController = new AddEmployeesController(this)
      this.editClientController = new EditClientController(this)
      this.editEmployeeController = new EditEmployeeController(this)
      // this.takeOrderController = ...

      /** @type {{[action: string]: Command}} */ this.actions = {
         add: new Command("Adicionar funcionários", (_ag) => {
            this.addEmployeesController.openView()
         }),

         edit: new Command("Editar perfil", (agent) => {
            if (agent instanceof Client) {
               this.editClientController.client = agent
               this.editClientController.openView()
            } else {
               this.editEmployeeController.employee = agent
               this.editEmployeeController.openView()
            }
         })
      }

      Boxer.actions.push("edit")
      Client.actions.push("edit")
      Cook.actions.push("edit")
      Deliverer.actions.push("edit")
      Manager.actions.push("add", "edit")
      Supplier.actions.push("edit")

      /** @type {SignInView} */ this.view

      this.view.bindExecute((action) => {
         this.actions[action].execute(this._person)
      })

      this.view.bindSignOut((_ev) => {
         this.parent.openView("Até a próxima!")
      })
   }

   /** @param {Person} person */
   set person(person) {
      this._person = person
   }

   /** @param {string} [message] */
   openView(message) {
      /** @type {{[action: string]: string}} */ let actions = {}

      for (let action of this._person.actions)
         actions[action] = this.actions[action].tag

      this.view.actions = actions
      super.openView(message)
   }
}

class PrimaryController extends Controller {
   constructor() {
      super(new PrimaryView())
      this.newClientController = new NewClientController(this)
      this.newEmployeeController = new NewEmployeeController(this)
      this.signInController = new SignInController(this)

      this.view.bindNewClient((_ev) => {
         this.newClientController.openView()
      })

      this.view.bindNewEmployee((_ev) => {
         this.newEmployeeController.openView()
      })

      this.view.bindSignIn((cpf) => {
         try {
            let person

            if (cpf === "gerente")
               person = this.model.manager
            else
               person = this.model.getPerson(cpf)

            this.signInController.person = person
            this.signInController.openView("Bem-vindo, " + person.name + "!")
         } catch (ex) {
            this.view.log(true, ex)
         }
      })
   }
}