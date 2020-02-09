/// <reference path="Client.ts" />
/// <reference path="employee/Manager.ts" />

class Model {
   private _candidates: Employee[]
   private clients: {[cpf: string]: Client}
   private employees: {[cpf: string]: Employee}
   private _manager: Manager
   private static existingException = "Funcionário já existente."
   private static notFoundException = "Não encontrado."

   constructor() {
      this._candidates = []
      this.clients = {}
      this.employees = {}
      this._manager = new Manager()
      this._manager.name = "Batata"
      this._manager.email = "batata@burgerman"
   }

   get candidates() {
      return this._candidates.slice(0)
   }

   set candidate(candidate: Employee) {
      this._candidates.push(candidate)
   }

   set client(client: Client) {
      this.clients[client.cpf] = client
   }

   set employee(employee: Employee) {
      if (this.employees[employee.cpf])
         throw Model.existingException

      this.employees[employee.cpf] = employee
   }

   get manager() {
      return this._manager
   }

   clearCandidates() {
      this._candidates = []
   }

   getPerson(cpf: string) {
      let person: Person = this.employees[cpf]

      if (!person) {
         person = this.clients[cpf]

         if (!person)
            throw Model.notFoundException
      }

      return person
   }

   removeCandidate(index: number) {
      this._candidates.splice(index, 1)
   }
}