/// <reference path="Client.ts" />
/// <reference path="employee/Manager.ts" />

class Model {
   private _candidates: Employee[]
   private clients: Map<string, Client>
   private employees: Map<string, Employee>
   private _manager: Manager
   private static existingException = "Funcionário já existente."
   private static notFoundException = "Não encontrado."

   constructor() {
      this._candidates = []
      this.clients = new Map<string, Client>()
      this.employees = new Map<string, Employee>()
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
      this.clients.set(client.cpf, client)
   }

   set employee(employee: Employee) {
      if (this.employees.has(employee.cpf))
         throw Model.existingException

      this.employees.set(employee.cpf, employee)
   }

   get manager() {
      return this._manager
   }

   clearCandidates() {
      this._candidates = []
   }

   getCandidate(index: number) {
      let candidate = this._candidates[index]

      if (!candidate)
         throw Model.notFoundException

      return candidate
   }

   getPerson(cpf: string) {
      let person: Person = this.employees.get(cpf)

      if (!person) {
         person = this.clients.get(cpf)

         if (!person)
            throw Model.notFoundException
      }

      return person
   }

   removeCandidate(index: number) {
      this._candidates.splice(index, 1)
   }
}