/// <reference path="../view/person/EditEmployeeView.ts" />
/// <reference path="Controller.ts" />

class EditEmployeeController extends Controller {
   private _employee: Employee

   constructor(parent: Controller) {
      super(new EditEmployeeView(), parent)
      let view = this.view as EditEmployeeView
      view.bindCancel(this.handleCancel.bind(this))
      view.bindOk(this.handleOk.bind(this))
   }

   set employee(employee: Employee) {
      this._employee = employee
   }

   private handleCancel(_event: MouseEvent) {
      this.parent.openView("Alteração cancelada.")
   }

   private handleOk(_event: MouseEvent) {
      let view = this.view as EditEmployeeView
      this._employee.email = view.name
      this._employee.name = view.name
      this._employee.profile = view.profile
      this.parent.openView("Perfil de " + this._employee.name + " alterado.")
   }

   openView(message?: string) {
      let view = this.view as EditEmployeeView
      view.clear()
      view.cpf = this._employee.cpf
      view.email = this._employee.email
      view.name = this._employee.name
      view.profile = this._employee.profile
      view.type = this._employee.type
      super.openView(message)
   }
}