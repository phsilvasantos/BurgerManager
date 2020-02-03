class Address {
   /**@param {string} district  @param {number} number @param {string} street */
   constructor(number, street, district) {
      this.district = district
      this.number = number
      this.street = street
   }

   toString() {
      return "rua " + this.street + ", " + this.number + ", " + this.district
   }
}

class Action {
   /** @param {(executor: Person) => void} handler @param {string} tag */
   constructor(tag, handler) {
      this.execute = handler
      this.tag = tag
   }
}

class Factory {
   /** @param {(cpf: string) => Person} handler @param {string} tag */
   constructor(tag, handler) {
      this.create = handler
      this.tag = tag
   }
}

/** @abstract */
class Person {
   /** @param {string} cpf */
   constructor(cpf) {
      /** @type {{[key: string]: Action}} */
      this.actions
      this.cpf = cpf;
      this.email = "0@z"
      this.name = "-"
      /** @type {string} */
      this.type
   }

   toString() {
      let p = "cpf: " + this.cpf;
      p += "\nnome: " + this.name;
      p += "\ne-mail: " + this.email;
      return p;
   }
}

class Client extends Person {
   /** @param {Address} address @param {string} cpf */
   constructor(cpf, address) {
      super(cpf)
      this.address = address
      this.actions = Client.actions
      this.type = Client.type
   }

   /** @param {Action} action @param {string} key */
   static bindAction(key, action) {
      Client.actions[key] = action
   }

   toString() {
      return super.toString() + "\nEndereço: " + this.address
   }
}

/** @type {{[key: string]: Action}} */
Client.actions = {}
Client.type = "Cliente"

/** @abstract */
class Employee extends Person {
   /** @param {string} cpf */
   constructor(cpf) {
      super(cpf)
      this.profile = {}
   }

   /** @param {string} key @param {string} value */
   setAttribute(key, value) {
      key = key.toLowerCase()

      if (key === "cpf")
         throw "Atributo inválido."
      
      if (key === "email" || key === "e-mail")
         this.email = value
      else if (key === "nome")
         this.name = value
      else
         this.profile[key] = value
   }

   toString() {
      let e = super.toString()

      for (key in this.profile)
         e += "\n" + key + ": " + this.profile[key]

      e += "\nfunção: " + this.type.toLowerCase()
      return e
   }
}

class Boxer extends Employee {
   /** @param {string} cpf */
   constructor(cpf) {
      super(cpf)
      this.actions = Boxer.actions
      this.type = Boxer.type
   }

   /** @param {Action} action @param {string} key */
   static bindAction(key, action) {
      Boxer.actions[key] = action
   }
}

/** @type {{[key: string]: Action}} */
Boxer.actions = {}
Boxer.type = "Embalador"

class Cook extends Employee {
   /** @param {string} cpf */
   constructor(cpf) {
      super(cpf)
      this.actions = Cook.actions
      this.type = Cook.type
   }

   /** @param {Action} action @param {string} key */
   static bindAction(key, action) {
      Cook.actions[key] = action
   }
}

/** @type {{[key: string]: Action}} */
Cook.actions = {}
Cook.type = "Cozinheiro"

class Deliverer extends Employee {
   /** @param {string} cpf */
   constructor(cpf) {
      super(cpf)
      this.actions = Deliverer.actions
      this.type = Deliverer.type
   }

   /** @param {Action} action @param {string} key */
   static bindAction(key, action) {
      Deliverer.actions[key] = action
   }
}

/** @type {{[key: string]: Action}} */
Deliverer.actions = {}
Deliverer.type = "Entregador"

class Manager extends Employee {
   constructor() {
      super("000.000.000-00")
      this.actions = Manager.actions
      this.type = Manager.type
   }

   /** @param {Action} action @param {string} key */
   static bindAction(key, action) {
      Manager.actions[key] = action
   }
}

/** @type {{[key: string]: Action}} */
Manager.actions = {}
Manager.type = "Gerente"

class Supplier extends Employee {
   /** @param {string} cpf */
   constructor(cpf) {
      super(cpf)
      this.actions = Supplier.actions
      this.type = Supplier.type
   }

   /** @param {Action} action @param {string} key */
   static bindAction(key, action) {
      Supplier.actions[key] = action
   }
}

/** @type {{[key: string]: Action}} */
Supplier.actions = {}
Supplier.type = "Fornecedor"

let NotFoundException = "Não encontrado."

class Model {
   constructor() {
      /** @type {{[cpf: string]: Client}} */
      this.clients = {}
      let cpf = "987.654.321-09"
      /** @type {Person} */
      let person = new Client(cpf)
      person.name = "Tomate"
      person.type = "Impostor"
      let action = new Action("Sabotar", (_ex) => {console.log("Sabotando...")})
      Client.bindAction("sabotage", action)
      this.clients[cpf] = person

      /** @type {{[cpf: string]: Employee}} */
      this.employees = {}
      cpf = "123.456.789-01"
      person = new Supplier(cpf)
      person.name = "Cebola"
      person.type = "Tripulante"
      action = new Action("Consertar", (_ex) => {console.log("Consertando...")})
      Supplier.bindAction("fix", action)
      this.employees[cpf] = person

      this.manager = new Manager()
      this.manager.name = "Batata"
   }

   /** @param {string} cpf @throws {NotFoundException} */
   getClient(cpf) {
      let client = this.clients[cpf]

      if (!client)
         throw NotFoundException

      return client
   }

   /** @param {string} cpf @throws {NotFoundException} */
   getEmployee(cpf) {
      let employee = this.employees[cpf]

      if (!employee)
         throw NotFoundException

      return employee
   }

   /** @param {string} cpf @throws {NotFoundException}*/
   getPerson(cpf) {
      try {
         return this.getClient(cpf)
      } catch (ex) {
         return this.getEmployee(cpf)
      }
   }
}