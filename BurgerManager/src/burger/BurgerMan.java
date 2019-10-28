package burger;

import burger.action.*;

import java.util.Scanner;

public class BurgerMan {
   public static final Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      Action[] actions = new Action[] {};

      while (true) {
         System.out.println("---\n0 - sair");
         int a;
         for (a = 1; a <= actions.length; a++)
            System.out.println(a + " - " + actions[a - 1]);
         System.out.print("---\nAção: ");

         try {
            a = Integer.parseInt(input.nextLine());
            if (a == 0)
               break;

            actions[a - 1].execute();
         }

         catch (NumberFormatException | IndexOutOfBoundsException ex) {
            System.out.println("<!> Entrada inválida.");
         }
         catch (Exception ex) {
            System.out.println("<!> " + ex.getMessage());
         }
      }
   }
}