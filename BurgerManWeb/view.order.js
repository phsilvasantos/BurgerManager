class TakeOrderView extends View {
   constructor() {
      super()

      this.scene.appendChild(this.createLabel("Hambúrguer de carne", "beef_burger_input"))
      this.scene.appendChild(document.createElement("br"))

      this.nBeefBurgerInput = this.createInput("number", "beef_burger_input")
      this.nBeefBurgerInput.min = 0
      this.nBeefBurgerInput.placeholder = "Quantidade"
      this.scene.appendChild(this.nBeefBurgerInput)

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("Hambúrguer de frango", "chicken_burger_input"))
      this.scene.appendChild(document.createElement("br"))

      this.nChickenBurgerInput = this.createInput("number", "chicken_burger_input")
      this.nChickenBurgerInput.min = 0
      this.nChickenBurgerInput.placeholder = "Quantidade"
      this.scene.appendChild(this.nChickenBurgerInput)

      this.scene.appendChild(document.createElement("br"))
      this.scene.appendChild(this.createLabel("Cheeseburger", "cheese_burger_input"))
      this.scene.appendChild(document.createElement("br"))

      this.nCheeseBurgerInput = this.createInput("number", "cheese_burger_input")
      this.nCheeseBurgerInput.min = 0
      this.nCheeseBurgerInput.placeholder = "Quantidade"
      this.scene.appendChild(this.nCheeseBurgerInput)

      this.scene.appendChild(document.createElement("hr"))

      this.okButton = this.createButton("OK")
      this.scene.appendChild(this.okButton)

      this.cancelButton = this.createButton("Cancelar")
      this.scene.appendChild(this.cancelButton)
   }
}