/// <reference path="Employee.ts" />

class Manager extends Employee {
   static actions: string[] = []
   static type = "Gerente"

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