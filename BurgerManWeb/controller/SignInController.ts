/// <reference path="../model/employee/Boxer.ts" />
/// <reference path="../model/employee/Cook.ts" />
/// <reference path="../model/employee/Deliverer.ts" />
/// <reference path="../model/employee/Supplier.ts" />
/// <reference path="../view/SignInView.ts" />
/// <reference path="AddEmployeesController.ts" />
/// <reference path="EditClientController.ts" />
/// <reference path="EditEmployeeController.ts" />

abstract class Command {
   protected controller: Controller
   abstract get tag(): string

   constructor(controller: Controller) {
      this.controller = controller
   }

   execute(agent: Person) {
      this.controller.openView()
   }
}

class AddEmployees extends Command {
   constructor(parent: SignInController) {
      super(new AddEmployeesController(parent))
   }

   get tag() {
      return "Adicionar funcionários"
   }
}

class EditClient extends Command {
   constructor(parent: SignInController) {
      super(new EditClientController(parent))
   }

   get tag() {
      return "Editar perfil"
   }

   execute(agent: Client) {
      let controller = this.controller as EditClientController
      controller.client = agent
      super.execute(agent)
   }
}

class EditEmployee extends Command {   
   constructor(parent: SignInController) {
      super(new EditEmployeeController(parent))
   }

   get tag() {
      return "Editar perfil"
   }

   execute(agent: Employee) {
      let controller = this.controller as EditEmployeeController
      controller.employee = agent
      super.execute(agent)
   }
}

class SignInController extends Controller {
   private actions: {[action: string]: Command}
   private _person: Person

   constructor(parent: Controller) {
      super(new SignInView(), parent)

      this.actions = {
         addEmployees: new AddEmployees(this),
         editClient: new EditClient(this),
         editEmployee: new EditEmployee(this)
      }

      Boxer.actions.push("editEmployee")
      Client.actions.push("editClient")
      Cook.actions.push("editEmployee")
      Deliverer.actions.push("editEmployee")
      Manager.actions.push("addEmployees", "editEmployee")
      Supplier.actions.push("editEmployee")

      let view = this.view as SignInView
      view.bindExecute(this.handleExecute.bind(this))
      view.bindSignOut(this.handleSignOut.bind(this))
   }

   set person(person: Person) {
      this._person = person
   }

   private handleExecute(_event: MouseEvent) {
      let view = this.view as SignInView
      this.actions[view.action].execute(this._person)
   }

   private handleSignOut(_event: MouseEvent) {
      this.parent.openView("Até a próxima.")
   }

   openView(message?: string) {
      let actions: {[action: string]: string} = {}

      for (let action of this._person.actions)
         actions[action] = this.actions[action].tag

      let view = this.view as SignInView
      view.actions = actions
      super.openView(message)
   }
}