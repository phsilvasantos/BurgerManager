abstract class Person {
   cpf: string
   email: string
   name: string

   constructor(cpf: string) {
      this.cpf = cpf
   }

   abstract get actions(): string[]
   abstract get type(): string

   toString() {
      let p = "cpf: " + this.cpf
      p += "\nnome: " + this.name
      p += "\ne-mail: " + this.email
      return p;
   }
}