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

   execute(_agent: Person) {
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
      super.execute(null)
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
      super.execute(null)
   }
}

class SignInController extends Controller {
   private actions: Map<string, Command>
   private _person: Person

   constructor(parent: Controller) {
      super(new SignInView(), parent)

      this.actions = new Map<string, Command>()
      this.actions.set("addEmployees", new AddEmployees(this))
      this.actions.set("editClient", new EditClient(this))
      this.actions.set("editEmployee", new EditEmployee(this))

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
      this.actions.get(view.action).execute(this._person)
   }

   private handleSignOut(_event: MouseEvent) {
      this.parent.openView("Até a próxima.")
   }

   openView(message?: string) {
      let actions = new Map<string, string>()

      for (let action of this._person.actions)
         actions.set(action, this.actions.get(action).tag)

      let view = this.view as SignInView
      view.actions = actions
      super.openView(message)
   }
}