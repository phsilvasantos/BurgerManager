/// <reference path="../view/PrimaryView.ts" />
/// <reference path="NewClientController.ts" />
/// <reference path="NewEmployeeController.ts" />
/// <reference path="SignInController.ts" />

class PrimaryController extends Controller {
   private newClientController: NewClientController
   private newEmployeeController: NewEmployeeController
   private signInController: SignInController

   constructor() {
      super(new PrimaryView())
      this.newClientController = new NewClientController(this)
      this.newEmployeeController = new NewEmployeeController(this)
      this.signInController = new SignInController(this)
      let view = this.view as PrimaryView
      view.bindNewClient(this.handleNewClient.bind(this))
      view.bindNewEmployee(this.handleNewEmployee.bind(this))
      view.bindSignIn(this.handleSignIn.bind(this))
   }

   private handleNewClient(_event: MouseEvent) {
      this.newClientController.openView()
   }

   private handleNewEmployee(_event: MouseEvent) {
      this.newEmployeeController.openView()
   }

   private handleSignIn(_event: MouseEvent) {
      try {
         let view = this.view as PrimaryView
         let cpf = view.cpf
         let person: Person

         if (cpf === "gerente")
            person = this.model.manager
         else
            person = this.model.getPerson(cpf)

         this.signInController.person = person
         this.signInController.openView("Bem-vindo, " + person.name + ".")
      } catch (ex) {
         this.view.log(true, ex)
      }
   }
}