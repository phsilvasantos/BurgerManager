/// <reference path="Employee.ts" />

class Cook extends Employee {
   static actions: string[] = []
   static type = "Cozinheiro"

   get actions() {
      return Cook.actions
   }

   get type() {
      return Cook.type
   }
}