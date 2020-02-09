/// <reference path="EmployeeView.ts" />

class AddEmployeesView extends EmployeeView {
   private addButton: HTMLButtonElement
   private candidateSelect: HTMLSelectElement
   private closeButton: HTMLButtonElement

   constructor() {
      super()
      this.emailInput.readOnly = true
      this.nameInput.readOnly = true

      let child = this.scene.firstChild

      this.scene.insertBefore(this.createLabel("Candidato", "employee_select"), child)
      this.scene.insertBefore(document.createElement("br"), child)

      this.candidateSelect = this.createSelect("employee_select")
      this.scene.insertBefore(this.candidateSelect, child)

      this.addButton = this.createButton("Adicionar")
      this.scene.insertBefore(this.addButton, child)

      this.scene.insertBefore(document.createElement("hr"), child)
      this.scene.appendChild(document.createElement("hr"))

      this.closeButton = this.createButton("Fechar")
      this.scene.appendChild(this.closeButton)
   }

   get candidateIndex() {
      return this.candidateSelect.selectedIndex
   }

   set candidates(candidates: string[]) {
      this.candidateSelect.innerHTML = ""

      for (let index = 0; index < candidates.length; index++)
         this.candidateSelect.appendChild(this.createOption(index.toString(), candidates[index]))
   }

   bindAdd(handler: (event: MouseEvent) => void) {
      this.addButton.addEventListener("click", handler)
   }

   bindClose(handler: (event: MouseEvent) => void) {
      this.closeButton.addEventListener("click", handler)
   }

   bindSelect(handler: (event: Event) => void) {
      this.candidateSelect.addEventListener("change", handler)
   }
}