/********************************************************
* Author: Nick Foster
*
* Last edited: 9/13/2017
********************************************************/

public class Contents {
   // fields
   
   // constructors
   
   // methods
   public static String checkContents() {
      switch (Dice.deeRoll(1,100)) {
         case 1: 
         case 2: 
         case 3: 
         case 4: 
         case 5: 
         case 6: 
         case 7: 
         case 8: return String.format("%s", dominantMonster());
         case 9: 
         case 10: 
         case 11: 
         case 12: 
         case 13: 
         case 14: 
         case 15: return String.format("%s with %n%s", dominantMonster(), randomTreasure());
         case 28: 
         case 29: 
         case 30: 
         case 31: 
         case 32: 
         case 33: return String.format("%s with %n%s", alliedMonster(), randomTreasure());
         case 34: 
         case 35: 
         case 36: 
         case 37: 
         case 38: 
         case 39: 
         case 40: 
         case 41: 
         case 42: return String.format("%s", randomMonster());
         case 43: 
         case 44: 
         case 45: 
         case 46: 
         case 47: 
         case 48: 
         case 49: 
         case 50: return String.format("%s with %n%s", randomMonster(), randomTreasure());
         case 51: 
         case 52: 
         case 53: 
         case 54: 
         case 55: 
         case 56: 
         case 57: 
         case 58: return String.format("%s with %n%s", dungeonHazard(), randomTreasure());
         case 59: 
         case 60: 
         case 61: 
         case 62: 
         case 63: return String.format("%s", randomObstacle());
         case 64: 
         case 65: 
         case 66: 
         case 67: 
         case 68: 
         case 69: 
         case 70: 
         case 71: 
         case 72: 
         case 73: return String.format("%s", randomTrap());
         case 74: 
         case 75: 
         case 76: return String.format("%s %n%s", randomTrap(), randomTreasure());
         case 77: 
         case 78: 
         case 79: 
         case 80: return String.format("%s", Trick.rollTrick());
         case 81: 
         case 82: 
         case 83: 
         case 84: 
         case 85: 
         case 86: 
         case 87: 
         case 88: return String.format("%s", emptyRoom());
         case 89: 
         case 90: 
         case 91: 
         case 92: 
         case 93: 
         case 94: return String.format("%s with %n%s", emptyRoom(), randomTreasure());
         case 95: 
         case 96: 
         case 97: 
         case 98: 
         case 99: 
         case 100: return String.format("%s with %n%s", emptyRoom(), randomTreasure());
         default: return String.format("%s", alliedMonster());
      }
   }
   
   public static String dominantMonster()    {return "dominant monster";}
   public static String alliedMonster()      {return "allied monster";}
   public static String randomMonster()      {return "random monster";}
   public static String dungeonHazard()      {return "dungeon hazard";}
   public static String randomObstacle()     {return "random obstacle";}
   public static String randomTrap()         {return Trap.rollTrap();}
   //public static String randomTrick()        {return "random trick";}
   public static String emptyRoom()          {return "empty room";}
   
   public static String randomTreasure() {
      return Item.hoardToString(Item.generateHoard(Dice.getLevel()));
   }
   
   
}