/// <reference path="View.ts" />

class SignInView extends View {
   private actionSelect: HTMLSelectElement
   private executeButton: HTMLButtonElement
   private signOutButton: HTMLButtonElement

   constructor() {
      super()

      this.scene.appendChild(this.createLabel("Ação", "action_select"))
      this.scene.appendChild(document.createElement("br"))

      this.actionSelect = this.createSelect("action_select")
      this.scene.appendChild(this.actionSelect)

      this.executeButton = this.createButton("Executar")
      this.scene.appendChild(this.executeButton)

      this.scene.appendChild(document.createElement("hr"))

      this.signOutButton = this.createButton("Sair")
      this.scene.appendChild(this.signOutButton)
   }

   get action() {
      return this.actionSelect.value
   }

   set actions(actions: Map<string, string>) {
      this.actionSelect.innerHTML = ""

      for (let [action, tag] of actions)
         this.actionSelect.appendChild(this.createOption(action, tag))
   }

   bindExecute(handler: (event: MouseEvent) => void) {
      this.executeButton.addEventListener("click", handler)
   }

   bindSignOut(handler: (event: MouseEvent) => void) {
      this.signOutButton.addEventListener("click", handler)
   }
}