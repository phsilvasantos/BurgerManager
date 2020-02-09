/// <reference path="../model/employee/Boxer.ts" />
/// <reference path="../model/employee/Cook.ts" />
/// <reference path="../model/employee/Deliverer.ts" />
/// <reference path="../model/employee/Supplier.ts" />
/// <reference path="../view/person/NewEmployeeView.ts" />
/// <reference path="Controller.ts" />

interface Factory {
   create(cpf: string): Employee
   tag: string
}

class BoxerFactory implements Factory {
   get tag() {
      return Boxer.type
   }

   create(cpf: string) {
      return new Boxer(cpf)
   }
}

class CookFactory implements Factory {
   get tag() {
      return Cook.type
   }

   create(cpf: string) {
      return new Cook(cpf)
   }
}

class DelivererFactory implements Factory {
   get tag() {
      return Deliverer.type
   }

   create(cpf: string) {
      return new Deliverer(cpf)
   }
}

class SupplierFactory implements Factory {
   get tag() {
      return Supplier.type
   }

   create(cpf: string) {
      return new Supplier(cpf)
   }
}

class NewEmployeeController extends Controller {
   private factories: {[type: string]: Factory}

   constructor(parent: Controller) {
      super(new NewEmployeeView(), parent)

      this.factories = {
         boxer: new BoxerFactory(),
         cook: new CookFactory(),
         deliverer: new DelivererFactory(),
         supplier: new SupplierFactory()
      }

      let view = this.view as NewEmployeeView
      view.bindCancel(this.handleCancel.bind(this))
      view.bindOk(this.handleOk.bind(this))
   }

   private handleCancel(_event: MouseEvent) {
      this.parent.openView("Adição cancelada.")
   }

   private handleOk(_event: MouseEvent) {
      try {
         let view = this.view as NewEmployeeView
         let employee = this.factories[view.type].create(view.cpf)
         employee.email = view.email
         employee.name = view.name
         this.model.candidate = employee
         this.parent.openView("Adição de funcionário " + employee.name + " aguardando aprovação.")
      } catch (ex) {
         this.view.log(true, ex)
      }
   }

   openView(message?: string) {
      let view = this.view as NewEmployeeView
      view.clear()
      let types: {[type: string]: string} = {}

      for (let type in this.factories)
         types[type] = this.factories[type].tag

      view.types = types
      super.openView(message)
   }
}