// begin exception
let FormatException = "Formato incorreto.";
let NotFoundException = "Não encontrado.";
// end exception

// begin model
// begin person
class Person {
   constructor(cpf) {
      let match = /\d{3}.\d{3}.\d{3}-\d{2}/.exec(cpf);

      if (match === null || match[0].length !== cpf.length)
         throw FormatException;

      this.cpf = cpf;
      Object.defineProperty(this, "cpf", { writable: false });
   }

   get email() {
      return this._email;
   }

   set email(email) {
      let match = /[a-z0-9.]+@[a-z.]+/i.exec(email);

      if (match === null || match[0].length !== email.length)
         throw FormatException;

      this._email = email;
   }

   get name() {
      return this._name;
   }

   set name(name) {
      if (name.length === 0)
         name = "-";

      this._name = name;
   }

   toString() {
      let p = "cpf: " + this.cpf;
      p += "\nnome: " + this.name;
      p += "\ne-mail: " + this.email;

      return p;
   }
}

class Client extends Person {
   constructor(cpf) {
      super(cpf);
   }

   get address() {
      return this._address;
   }

   set address(address) {
      if (address.length === 0)
         address = "-";

      this._address = address;
   }

   toString() {
      let c = super.toString();
      c += "\nendereço: " + this.address;

      return c;
   }
}

// begin employee
class Employee extends Person {
   constructor(cpf) {
      super(cpf);
      this._profile = {}
   }

   putAttribute(key, value) {
      key = key.toLowerCase();

      if (key === "cpf")
         throw "Atributo inválido.";

      if (key === "email" || key === "e-mail")
         this.email = value;
      else if (key === "nome")
         this.name = value;
      else
         this._profile[key] = value;
   }

   toString() {
      let e = super.toString();

      for (key in this._profile) {
         let value = this._profile[key];
         e += "\n" + key + ": " + value;
      }

      e += "\nfunção: " + this.type;

      return e;
   }
}

class Manager extends Employee {
   constructor(cpf) {
      super(cpf);

      this.actions = {
         teste: function() {
            alert("testando...");
         }
      }

      this.type = "gerente";

      Object.defineProperties(this, {
         actions: { writable: false },
         type: { writable: false }
      });
   }
}
// end employee
// end person
// end model

//begin controller
let PersonController = {
   clients: {},
   employees: {gerente: new Manager("000.000.000-00")},

   init: function() {
      PersonController.addressField = document.getElementById("address_field");
      PersonController.cpfInput = document.getElementById("cpf_input");
      PersonController.primaryScene = document.getElementById("primary_scene");
      PersonController.profileScene = document.getElementById("profile_scene");
      PersonController.typeField = document.getElementById("type_field");
   },

   newPerson: function(isClient) {
      PersonController.profileScene.style.display = "block";
      PersonController.addressField.style.display = isClient ? "block" : "none";
      PersonController.typeField.style.display = isClient ? "none" : "block";
   },

   open: function() {
      PersonController.primaryScene.style.display = "block";
   }
}
// end controller

let BurgerMan = {
   main: function() {
      PersonController.init();
      PersonController.open();
   }
}