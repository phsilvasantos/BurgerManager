/// <reference path="../view/person/NewClientView.ts" />
/// <reference path="Controller.ts" />

class NewClientController extends Controller {
   constructor(parent: Controller) {
      super(new NewClientView(), parent)
      let view = this.view as NewClientView
      view.bindCancel(this.handleCancel.bind(this))
      view.bindOk(this.handleOk.bind(this))
   }

   private handleCancel(_event: MouseEvent) {
      this.parent.openView("Adição cancelada.")
   }

   private handleOk(_event: MouseEvent) {
      try {
         let view = this.view as NewClientView
         let address = new Address(view.number, view.street, view.district)
         let client = new Client(view.cpf, address)
         client.email = view.email
         client.name = view.name
         this.model.client = client
         this.parent.openView("Cliente " + client.name + " adicionado.")
      } catch (ex) {
         this.view.log(true, ex)
      }
   }

   openView(message?: string) {
      let view = this.view as NewClientView
      view.clear()
      super.openView(message)
   }
}