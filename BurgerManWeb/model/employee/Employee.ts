/// <reference path="../Person.ts" />

abstract class Employee extends Person {
   profile: {[attribute: string]: string}

   constructor(cpf: string) {
      super(cpf)
      this.profile = {}
   }

   toString() {
      let e = super.toString()

      for (let attribute in this.profile)
         e += "\n" + attribute + ": " + this.profile[attribute]

      e += "\nfunção: " + this.type.toLowerCase()
      return e
   }
}