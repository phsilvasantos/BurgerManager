/// <reference path="../model/Model.ts" />
/// <reference path="../view/View.ts" />

abstract class Controller {
   static model = new Model()
   protected model: Model
   protected parent: Controller
   protected view: View

   constructor(view: View, parent?: Controller) {
      this.model = Controller.model
      this.view = view

      if (parent)
         this.parent = parent
   }

   openView(message?: string) {
      this.view.open()

      if (message)
         this.view.log(false, message)
      else
         this.view.log(false, "-")
   }
}