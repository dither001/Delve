/********************************************************
* Author: Nick Foster
*
* Last edited: 9/11/2017
********************************************************/

import java.util.Scanner;

public class Menu {
   // fields
   private static final Scanner input = new Scanner(System.in);
   
   // methods
   public static void preventNonInteger() {
      while (!input.hasNextInt()) {
         input.next();
      }
   }
   
   public static boolean mainMenuLoop() {
      int choice = -1;
      
      while (choice < 0 || choice > 10) {
         System.out.printf("%n%s (Level %d)", Furnish.getTheme(), Dice.getLevel());
         System.out.printf("%n0. Exit Generator");
         System.out.printf("%n1. New Passage");
         System.out.printf("%n2. Side Passage");
         System.out.printf("%n3. New Chamber");
         System.out.printf("%n4. Beyond Door");
         System.out.printf("%n5. Stairs");
         System.out.printf("%n6. Trick");
         System.out.printf("%n7. Trap");
         System.out.printf("%n8. Treasure");
         System.out.printf("%n9. Change theme");
         System.out.printf("%n10. Set level");
         System.out.printf("%n");
         
         preventNonInteger();
         choice = input.nextInt();
      }
      
      Delve.resetPassage();
      switch (choice) {
         case 1: System.out.printf(Delve.newPassage()); break;
         case 2: System.out.printf(Delve.sidePassage()); break;
         case 3: System.out.printf(Delve.newChamber()); break;
         case 4: System.out.printf(Delve.beyondDoor()); break;
         case 5: System.out.printf(Delve.newStairs()); break;
         case 6: System.out.printf(Trick.rollTrick()); break;
         case 7: System.out.printf(Trap.rollTrap()); break;
         case 8: System.out.printf(Item.hoardToString(Item.generateHoard(Dice.getLevel()))); break;
         case 9: selectThemeLoop(); break;
         case 10: selectLevelLoop(); break;
         default: System.exit(0);
      }
      System.out.printf("%n%s", Delve.totalPassageLength());
      
      if (choice == 0) return false;
      else return true;
   }
   
   public static void selectThemeLoop() {
      int choice = -1;
      
      while (choice < 0 || choice > 9) {
         System.out.printf("%nCurrent theme: %s", Furnish.getTheme());
         System.out.printf("%n0. Random theme");
         System.out.printf("%n1. %s", Furnish.getTheme(1));
         System.out.printf("%n2. %s", Furnish.getTheme(2));
         System.out.printf("%n3. %s", Furnish.getTheme(3));
         System.out.printf("%n4. %s", Furnish.getTheme(4));
         System.out.printf("%n5. %s", Furnish.getTheme(5));
         System.out.printf("%n6. %s", Furnish.getTheme(6));
         System.out.printf("%n7. %s", Furnish.getTheme(7));
         System.out.printf("%n8. %s", Furnish.getTheme(8));
         System.out.printf("%n9. %s", Furnish.getTheme(9));
         System.out.printf("%n");
         
         preventNonInteger();
         choice = input.nextInt();
      }
      
      System.out.printf(Furnish.setTheme(choice));
   }
   
   public static void selectLevelLoop() {
      int choice = -1;
      
      while (choice < 1 || choice > 20) {
         System.out.printf("%nChoose level (1-20): ");
         
         preventNonInteger();
         choice = input.nextInt();
      }
      
      Dice.setLevel(choice);
   }
}