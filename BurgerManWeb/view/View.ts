abstract class View {
   protected static cpfPattern = "\\d{3}.\\d{3}.\\d{3}-\\d{2}"
   protected static formatException = "Formato incorreto."
   private static log = document.querySelector("#log")
   protected scene: HTMLDivElement
   private static stage = document.querySelector("#stage")

   constructor() {
      this.scene = document.createElement("div")
   }

   createButton(text: string) {
      let button = document.createElement("button")
      button.textContent = text
      button.type = "button"
      return button
   }

   createInput(type: string, id?: string) {
      let input = document.createElement("input")
      input.type = type

      if (id)
         input.id = id

      return input
   }

   createLabel(text: string, targetId: string) {
      let label = document.createElement("label")
      label.setAttribute("for", targetId)
      label.textContent = text
      return label
   }

   createOption(value: string, text: string) {
      let option = document.createElement("option")
      option.value = value
      option.textContent = text
      return option
   }

   createSelect(id: string) {
      let select = document.createElement("select")
      select.id = id
      return select
   }

   log(error: boolean, message: string) {
      if (error)
         View.log.classList.add("error")
      else
         View.log.classList.remove("error")

      View.log.innerHTML = message
   }

   open() {
      View.stage.innerHTML = ""
      View.stage.appendChild(this.scene)
   }
}