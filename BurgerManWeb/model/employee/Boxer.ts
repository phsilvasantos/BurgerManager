/// <reference path="Employee.ts" />

class Boxer extends Employee {
   static actions: string[] = []
   static type = "Embalador"

   get actions() {
      return Boxer.actions
   }

   get type() {
      return Boxer.type
   }
}