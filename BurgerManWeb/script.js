class PersonHandler {
   static init() {
      PersonHandler.scene = document.getElementById("person");
   }

   static open(parent, cpf) {
      PersonHandler.parent = parent;
      parent.style.display = "none";
      PersonHandler.scene.style.display = "block";
   }

   static signOut() {
      PersonHandler.scene.style.display = "none";
      PersonHandler.parent.style.display = "block";
   }
}

class PrimaryHandler {
   static init() {
      PrimaryHandler.cpfInput = document.getElementById("cpf");
      PrimaryHandler.scene = document.getElementById("primary");
   }

   static open() {
      PrimaryHandler.scene.style.display = "block";
   }

   static signIn() {
      PersonHandler.open(PrimaryHandler.scene, PrimaryHandler.cpfInput.value);
   }
}

class BurgerMan {
   static main() {
      PersonHandler.init();
      PrimaryHandler.init();
      PrimaryHandler.open();
   }
}