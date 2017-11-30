/********************************************************
* Author: Nick Foster
*
* Last edited: 9/13/2017
********************************************************/

public class Delve {
   // fields
   private static int passageLength = 0;
   private static String passageNote = "";
   
   // constructors
   
   // methods
   public static String newPassage() {
      switch (Dice.deeRoll(1,12)) {
         case 1: 
         case 2: return String.format("5-ft. wide passage: %s", longPassage());
         default: return String.format("10-ft. wide passage: %s", longPassage());
      }
   }
   
   public static String sidePassage() {
      switch (Dice.deeRoll(1,12)) {
         case 1: 
         case 2: return String.format("5-ft. wide passage: %s", shortPassage());
//          case 13: 
//          case 14: return String.format("20-ft. wide passage: %s", shortPassage());
//          case 15: 
//          case 16: return String.format("30-ft. wide passage: %s", shortPassage());
//          case 17: return String.format("40-ft. wide passage, with a row of pillars down the middle: %s", shortPassage());
//          case 18: return String.format("40-ft. wide passage, with a double row of pillars: %s", shortPassage());
//          case 19: return String.format("40-ft. wide passage, 20-ft. high: %s", shortPassage());
//          case 20: return String.format("40-ft. wide passage, 20-ft. high; %n10-ft. gallery allows access to level above: %s", shortPassage());
         default: return String.format("10-ft. wide passage: %s", shortPassage());
      }
   }
   
   public static String doorPassage() {
      switch (Dice.deeRoll(1,20)) {
         case 1: 
         case 2: return "5-ft. wide passage:";
         case 13: 
         case 14: return "20-ft. wide passage:";
         case 15: 
         case 16: return "30-ft. wide passage:";
         case 17: return "40-ft. wide passage, with a row of pillars down the middle:";
         case 18: return "40-ft. wide passage, with a double row of pillars:";
         case 19: return "40-ft. wide passage, 20-ft. high:";
         case 20: return "40-ft. wide passage, 20-ft. high; %n10-ft. gallery allows access to level above:";
         default: return "10-ft. wide passage:";
      }
   }
   
   public static String shortPassage() {
      switch (Dice.deeRoll(1,20)) {
         case 3: return String.format("straight 20 feet, with a (%s) on the right %nMain passage continues 10 feet", rollDoor());
         case 4: return String.format("straight 20 feet, with a (%s) on the left %nMain passage continues 10 feet", rollDoor());
         case 5: return String.format("straight 20 feet; passage ends in a (%s)", rollDoor());
         case 6: 
         case 7: return String.format("straight 20 feet, side passage on the right %nMain passage continues 10 feet %n-> %s", sidePassage());
         case 8: 
         case 9: return String.format("straight 20 feet, side passage on the left %nMain passage continues 10 feet %n<- %s", sidePassage());
         case 10: return "straight 20 feet; passage ends in a dead end; 10%% chance of a secret door";
         case 11: 
         case 12: return "straight 20 feet; passage turns right and continues 10 feet";
         case 13: 
         case 14: return "straight 20 feet; passage turns left and continues 10 feet";
         case 15: 
         case 16: 
         case 17: 
         case 18: 
         case 19: return String.format("opens into %n(o) %s", newChamber());
         case 20: return String.format("opens onto %n(o) %s", newStairs());
         default: return "straight 30 feet, with no doors or side passages";
      }
   }
   
   public static String longPassage() {
      switch (Dice.deeRoll(1,20)) {
         case 3:
            passageLength += 30;
            return passageNote += String.format("straight 20 feet, with a (%s) on the right; %nMain passage continues 10 feet; %n|| %s",
                  rollDoor(), ongoingPassage());
         case 4:
            passageLength += 30;
            return passageNote += String.format("straight 20 feet, with a (%s) on the left; %nMain passage continues 10 feet; %n|| %s",
                  rollDoor(), ongoingPassage());
         case 5:
            passageLength += 20;
            return String.format("straight 20 feet; passage ends in a (%s)",
                  rollDoor());
         case 6: 
         case 7:
            passageLength += 30;
            return passageNote += String.format("straight 20 feet, side passage on the right %n-> %s %nMain passage continues 10 feet %n|| %s",
                  sidePassage(), ongoingPassage());
         case 8: 
         case 9:
            passageLength += 30;
            return passageNote += String.format("straight 20 feet, side passage on the left %n<- %s %nMain passage continues 10 feet %n|| %s",
                  sidePassage(), ongoingPassage());
         case 10:
            passageLength += 20;
            return "straight 20 feet; passage ends in a dead end; 10%% chance of a secret door";
         case 11: 
         case 12:
            passageLength += 20;
            return "straight 20 feet; passage turns right and continues 10 feet";
         case 13: 
         case 14:
            passageLength += 20;
            return "straight 20 feet; passage turns left and continues 10 feet";
         case 15: 
         case 16: 
         case 17: 
         case 18: 
         case 19: return String.format("opens into %n(o) %s", newChamber());
         case 20: return String.format("opens onto %n(o) %s", newStairs());
         default:
            passageLength += 30;
            return passageNote += String.format("straight 30 feet, with no doors or side passages %n|| %s",
                  ongoingPassage());
      }
   }
   
   public static String ongoingPassage() {
      passageNote += longPassage();
      return passageNote;
   }
   
   public static void resetPassage() {
      passageLength = 0;
      passageNote = "";
   }
   
   public static String totalPassageLength() {
      if (passageLength > 30) return String.format("Passage length: %d", passageLength);
      else return "";
   }
   
   public static String rollDoor() {
      switch (Dice.deeRoll(1,20)) {
         case 11: 
      case 12: return "wooden door, barred/locked";
         case 13: return "stone door";
         case 14: return "stone door, barred/locked";
         case 15: return "iron door";
         case 16: return "iron door, barred/locked";
         case 17: return "portcullis";
         case 18: return "portcullis, barred/locked";
         case 19: return "secret door";
         case 20: return "secret door, barred/locked";
         default: return "wooden door";
      }
   }
   
   public static String beyondDoor() {
      switch (Dice.deeRoll(1,20)) {
         case 1: 
         case 2: return String.format("%s extends 10 feet; T-intersection extends 10 feet to the right and left", doorPassage());
         case 3: 
         case 4: 
         case 5: 
         case 6: 
         case 7: 
         case 8: return String.format("%s extends 20 feet straight forward", doorPassage());
         case 19: return String.format("%s opens onto %n(o) %s", doorPassage(), newStairs());
         case 20: return String.format("false door with trap"); // TODO
         default: return newChamber();
      }
   }
   
   public static String newChamber() {
      boolean isLarge = false;
      String description = "";
      
      switch (Dice.deeRoll(1,20)) {
         case 1: 
         case 2: description = "Small square chamber, 20x20 feet"; break;
         case 3: 
         case 4: description = "Small square chamber, 30x30 feet"; break;
         case 5: 
         case 6: description = "Small square chamber, 40x40 feet"; break;
         case 10: 
         case 11: 
         case 12: description = "Small rectangular chamber, 30x40 feet"; break;
         case 13: 
         case 14: 
            description = "Large rectangular chamber, 40x50";
            isLarge = true;
            break;
         case 15: 
            description = "Large rectangular chamber, 50x80";
            isLarge = true;
            break;
         case 16: description = "Small round chamber, 30-ft. diamter."; break;
         case 17: 
            description = "Large round chamber, 50-ft. diamter.";
            isLarge = true;
            break;
         case 18: 
            description = "Large octagonal chamber, 40-ft. diamter.";
            isLarge = true;
            break;
         case 19: 
            description = "Large octagonal chamber, 60-ft. diamter.";
            isLarge = true;
            break;
         case 20: 
            description = "Large trapezoidal chamber, 40x60 feet";
            isLarge = true;
            break;
         default: description = "Small rectangular chamber, 20x30 feet "; break;
      }
      
      if (isLarge)
         return String.format("%s %n%s %n%nContains: %n%s %n%nExit(s): %s", 
         description, Furnish.furnishChamber(), Contents.checkContents(), rollLargeExits());
      else
         return String.format("%s %n%s %n%nContains: %n%s %n%nExit(s): %s", 
         description, Furnish.furnishChamber(), Contents.checkContents(), rollSmallExits());
   }
   
   public static String rollSmallExits() {
      int rooms = smallRoomExits();
      
      if (rooms > 0) return rollExits(rooms);
      else return "none";
   }
   
   public static String rollLargeExits() {
      int rooms = largeRoomExits();
      
      if (rooms > 0) return rollExits(rooms);
      else return "none";
   }
   
   public static int smallRoomExits() {
      int n = Dice.deeRoll(1,20);
      
      if (n >= 1 && n <= 5) return 0;
      else if (n >= 6 && n <= 11) return 1;
      else if (n >= 12 && n <= 15) return 2;
      else if (n >= 16 && n <= 18) return 3;
      else return 4;
   }
   
   public static int largeRoomExits() {
      int n = Dice.deeRoll(1,20);
      
      if (n >= 1 && n <= 3) return 0;
      else if (n >= 4 && n <= 8) return 1;
      else if (n >= 9 && n <= 13) return 2;
      else if (n >= 14 && n <= 17) return 3;
      else if (n == 18) return 4;
      else if (n == 19) return 5;
      else return 6;
   }
   
   public static String rollExits(int exits) {
      String s = "";
      for (int i = 1; i <= exits; ++i) {
         s += String.format("%n");
         s += typeExit();
         s += "; ";
         s += locateExit();
      }
      
      return s;
   }
   
   public static String locateExit() {
      int n = Dice.deeRoll(1,20);
      
      if (n >= 1 && n <= 7) return "opposite from entrance";
      else if (n >= 8 && n <= 12) return "right of entrance";
      else if (n >= 13 && n <= 17) return "left of entrance";
      else return "same wall as entrance";
   }
   
   public static String typeExit() {
      if (Dice.deeRoll(1,2) == 1) return "* " + rollDoor();
      else return "= 10-ft. wide passage";
   }
   
   public static String newStairs() {
      switch (Dice.deeRoll(1,20)) {
         case 5: 
         case 6: 
         case 7: 
         case 8: return "Stairs: down one level to 20-ft. passage";
         case 9: return "Stairs: down two levels to chamber";
         case 10: return "Stairs: down two levels to 20-ft. passage";
         case 11: return "Stairs: down three levels to chamber";
         case 12: return "Stairs: down three levels to 20-ft. passage";
         case 13: return "Stairs: up one level to chamber";
         case 14: return "Stairs: up one level to 20-ft. passage";
         case 15: return "Stairs: down to dead end";
         case 16: return "Stairs: up to dead end";
         case 17: return "Chimney: up one level to 20-ft. passage";
         case 18: return "Chimney: up two levels to 20-ft. passage";
         case 19: return "Shaft (elevator) down one level to chamber";
         case 20: return "Shaft (elevator) up one level to chamber";
         default: return "Stairs: down one level to chamber";
      }
   }
   
   // END OF CODE
}