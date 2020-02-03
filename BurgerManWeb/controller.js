class Controller {
   constructor() {
      this.model = Controller.model
      /** @type {View} */
      this.view
   }

   openView() {
      this.view.open()
   }
}

Controller.model = new Model()

class NewClientController extends Controller {
   /** @param {Controller} parentController @param {HTMLDivElement} stage */
   constructor(parentController, stage) {
      super()
      this.parentController = parentController
      this.view = new NewClientView(stage)

      this.view.bindCancel((_ev) => {
         this.parentController.openView()
      })

      this.view.bindOk((client) => {
         this.model.clients[client.cpf] = client
         this.parentController.openView()
      })
   }
}

class NewEmployeeController extends Controller {
   /** @param {Controller} parentController @param {HTMLDivElement} stage */
   constructor(parentController, stage) {
      super()
      this.parentController = parentController
      this.view = new NewEmployeeView(stage)

      this.view.bindCancel((_ev) => {
         this.parentController.openView()
      })

      this.view.bindFactories({
         boxer: new Factory(Boxer.type, (cpf) => {return new Boxer(cpf)}),
         cook: new Factory(Cook.type, (cpf) => {return new Cook(cpf)}),
         deliverer: new Factory(Deliverer.type, (cpf) => {return new Deliverer(cpf)}),
         supplier: new Factory(Supplier.type, (cpf) => {return new Supplier(cpf)})
      })

      this.view.bindOk((employee) => {
         this.model.employees[employee.cpf] = employee
         this.parentController.openView()
      })
   }
}

class SignInController extends Controller {
   /** @param {Controller} parentController @param {HTMLDivElement} stage */
   constructor(parentController, stage) {
      super()
      this.parentController = parentController
      /** @type {Person} */
      this.person
      this.view = new SignInView(stage)

      let action = new Action("Fazer um teste", () => {console.log("Testando...")})
      Manager.bindAction("makeTest", action)

      this.view.bindClose((_ev) => {
         this.parentController.openView()
      })
   }

   openView() {
      this.view.bindActions(this.person.actions)
      this.view.setInfo(this.person)
      super.openView()
   }
}

class PrimaryController extends Controller {
   constructor() {
      super()
      /** @type {HTMLDivElement} */
      let stage = document.querySelector("#stage")
      this.signInController = new SignInController(this, stage)
      this.newClientController = new NewClientController(this, stage)
      this.newEmployeeController = new NewEmployeeController(this, stage)
      this.view = new PrimaryView(stage)

      this.view.bindNewClient((_ev) => {
         this.newClientController.openView()
      })

      this.view.bindNewEmployee((_ev) => {
         this.newEmployeeController.openView()
      })

      this.view.bindSignIn((cpf) => {
         try {
            /** @type {Person} */
            let person

            if (cpf === "gerente")
               person = this.model.manager
            else
               person = this.model.getPerson(cpf)

            this.signInController.person = person
            this.signInController.openView()
         } catch (ex) {
            alert(ex)
         }
      })
   }
}

let burgerMan = new PrimaryController()
burgerMan.openView()