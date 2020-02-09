/// <reference path="Employee.ts" />

class Supplier extends Employee {
   static actions: string[] = []
   static salary: number
   static type = "Fornecedor"

   get actions() {
      return Supplier.actions
   }

   get type() {
      return Supplier.type
   }
}