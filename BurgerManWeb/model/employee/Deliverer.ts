/// <reference path="Employee.ts" />

class Deliverer extends Employee {
   static actions: string[] = []
   static type: string = "Entregador"

   get actions() {
      return Deliverer.actions
   }

   get type() {
      return Deliverer.type
   }
}