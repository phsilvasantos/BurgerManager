/// <reference path="../view/person/EditClientView.ts" />
/// <reference path="Controller.ts" />

class EditClientController extends Controller {
   private _client: Client

   constructor(parent: Controller) {
      super(new EditClientView(), parent)
      let view = this.view as EditClientView
      view.bindCancel(this.handleCancel.bind(this))
      view.bindOk(this.handleOk.bind(this))
   }

   set client(client: Client) {
      this._client = client
   }

   private handleCancel(_event: MouseEvent) {
      this.parent.openView("Alteração cancelada.")
   }

   private handleOk(_event: MouseEvent) {
      try {
         let view = this.view as EditClientView
         this._client.address.district = view.district
         this._client.address.number = view.number
         this._client.address.street = view.street
         this._client.email = view.email
         this._client.name = view.name
         this.parent.openView("Perfil de " + this._client.name + " alterado.")
      } catch (ex) {}
   }

   openView(message?: string) {
      let view = this.view as EditClientView
      view.cpf = this._client.cpf
      view.district = this._client.address.district
      view.email = this._client.email
      view.name = this._client.name
      view.number = this._client.address.number
      view.street = this._client.address.street
      super.openView(message)
   }
}