class Address {
   /** @param {string} district  @param {number} number @param {string} street */
   constructor(number, street, district) {
      this.district = district
      this.number = number
      this.street = street
   }

   toString() {
      return "rua " + this.street + ", " + this.number + ", " + this.district
   }
}

/** @abstract */
class Person {
   /** @param {string} cpf */
   constructor(cpf) {
      this.cpf = cpf
      /** @type {string} */ this.email
      /** @type {string} */ this.name
   }

   /** @returns {string[]} */
   get actions() {
      return undefined
   }

   /** @returns {string} */
   get type() {
      return undefined
   }

   toString() {
      let p = "cpf: " + this.cpf
      p += "\nnome: " + this.name
      p += "\ne-mail: " + this.email
      return p;
   }
}

class Client extends Person {
   /** @param {Address} address @param {string} cpf */
   constructor(cpf, address) {
      super(cpf)
      this.address = address
   }

   get actions() {
      return Client.actions
   }

   get type() {
      return Client.type
   }

   toString() {
      return super.toString() + "\nEndereço: " + this.address
   }
}

/** @type {string[]} */ Client.actions = []
Client.type = "Cliente"

/** @abstract */
class Employee extends Person {
   /** @param {string} cpf */
   constructor(cpf) {
      super(cpf)
      /** @type {{[attribute: string]: string}} */ this.profile = {}
   }

   toString() {
      let e = super.toString()

      for (let attribute in this.profile)
         e += "\n" + attribute + ": " + this.profile[attribute]

      e += "\nfunção: " + this.type.toLowerCase()
      return e
   }
}

class Boxer extends Employee {
   get actions() {
      return Boxer.actions
   }

   get type() {
      return Boxer.type
   }
}

/** @type {string[]} */ Boxer.actions = []
Boxer.type = "Embalador"

class Cook extends Employee {
   get actions() {
      return Cook.actions
   }

   get type() {
      return Cook.type
   }
}

/** @type {string[]} */ Cook.actions = []
Cook.type = "Cozinheiro"

class Deliverer extends Employee {
   get actions() {
      return Deliverer.actions
   }

   get type() {
      return Deliverer.type
   }
}

/** @type {string[]} */ Deliverer.actions = []
Deliverer.type = "Entregador"

class Manager extends Employee {
   constructor() {
      super("000.000.000-00")
   }

   get actions() {
      return Manager.actions
   }

   get type() {
      return Manager.type
   }
}

/** @type {string[]} */ Manager.actions = []
Manager.type = "Gerente"

class Supplier extends Employee {
   get actions() {
      return Supplier.actions
   }

   get type() {
      return Supplier.type
   }
}

/** @type {string[]} */ Supplier.actions = []
Supplier.type = "Fornecedor"

let NotFoundException = "Não encontrado."

class Model {
   constructor() {
      /** @type {{[cpf: string]: Client}} */ this.clients = {}
      /** @type {{[cpf: string]: Employee}} */ this.employees = {}
      /** @type {Employee[]} */ this.pendingEmployees = []

      this.manager = new Manager()
      this.manager.email = "batata@burgerman"
      this.manager.name = "Batata"
   }

   /** @param {string} cpf @returns {Person} @throws {NotFoundException}*/
   getPerson(cpf) {
      let person = this.clients[cpf]

      if (!person) {
         person = this.employees[cpf]

         if (!person)
            throw NotFoundException
      }

      return person
   }
}