/// <reference path="../view/person/AddEmployeesView.ts" />
/// <reference path="Controller.ts" />

class AddEmployeesController extends Controller {
   constructor(parent: Controller) {
      super(new AddEmployeesView(), parent)
      let view = this.view as AddEmployeesView
      view.bindAdd(this.handleAdd.bind(this))
      view.bindClose(this.handleClose.bind(this))
      view.bindSelect(this.handleSelect.bind(this))
   }

   private handleAdd(_event: MouseEvent) {
      try {
         let view = this.view as AddEmployeesView
         let index = view.candidateIndex
         let employee = this.model.getCandidate(index)
         this.model.employee = employee
         this.model.removeCandidate(index)
         view.candidates = this.model.candidates.map((candidate) => {return candidate.name})
         this.handleSelect(null)
         view.log(false, "Funcionário " + employee.name + " adicionado.")
      } catch (ex) {
         this.view.log(true, ex)
      }
   }

   private handleClose(_event: MouseEvent) {
      this.model.clearCandidates()
      this.parent.openView()
   }

   private handleSelect(_event: Event) {
      let view = this.view as AddEmployeesView
      view.clear()

      try {
         let employee = this.model.getCandidate(view.candidateIndex)
         view.cpf = employee.cpf
         view.email = employee.email
         view.name = employee.name
         view.type = employee.type
      } catch (ex) {}
   }

   openView(message?: string) {
      let view = this.view as AddEmployeesView
      view.candidates = this.model.candidates.map((candidate) => {return candidate.name})
      this.handleSelect(null)
      super.openView(message)
   }
}