/// <reference path="Person.ts" />

class Address {
   district: string
   number: number
   street: string

   constructor(number: number, street: string, district: string) {
      this.district = district
      this.number = number
      this.street = street
   }
}

class Client extends Person {
   static actions: string[] = []
   address: Address
   static type = "Cliente"

   constructor(cpf: string, address: Address) {
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