/********************************************************
* Author: Nick Foster
*
* Last edited: 9/13/2017
********************************************************/

public class Trick {
   // fields
   
   // constructors
   
   // methods
   public static String rollTrick() {
      return String.format("%s %s", trickObject(), trickEffect());
   }
   
   public static String trickObject() {
      switch (Dice.deeRoll(1,20)) {
         case 2: return "Brain in a jar";
         case 3: return "Burning fire";
         case 4: return "Cracked gem";
         case 5: return "Door";
         case 6: return "Fresco";
         case 7: return "Furniture";
         case 8: return "Glass sculpture";
         case 9: return "Mushroom field";
         case 10: return "Painting";
         case 11: return "Plant or tree";
         case 12: return "Pool of water";
         case 13: return "Runes on wall or floor";
         case 14: return "Skull";
         case 15: return "Sphere of energy";
         case 16: return "Statue";
         case 17: return "Stone obelisk";
         case 18: return "Suit of armor";
         case 19: return "Tapestry or rug";
         case 20: return "Target dummy";
         default: return "Book";
      }
   }
   
   public static String trickEffect() {
      switch (Dice.deeRoll(1,32)) {
         case 2: return "animates, or animates nearby objects.";
         case 3: return "asks three skill-testing questions (if answered correctly, a reward appears).";
         case 4: return "bestows resistance or vulnerability.";
         case 5: return "changes a character's alignment, personality, size, appearance, or sex when touched.";
         case 6: return "changes one substance to another, such as gold to lead or metal to brittle crystal.";
         case 7: return "creates a force field.";
         case 8: return "creates an illusion.";
         case 9: return "suppresses magic items for a time.";
         case 10: return "enlarges or reduces characters.";
         case 11: return "magic mouth spell speaks a riddle.";
         case 12: return "casts confusion spell (10-ft. radius).";
         case 13: return "gives directions (true or false).";
         case 14: return "grants a wish.";
         case 15: return "flies around to avoid being touched.";
         case 16: return "casts geas spell on characters.";
         case 17: return "increases, reduces, negates, or reverses gravity.";
         case 18: return "induces greed.";
         case 19: return "contains an imprisoned creature.";
         case 20: return "locks or unlocks exits.";
         case 21: return "offers game of chance, with promise of reward or information.";
         case 22: return "helps or harms certain type(s) of creatures.";
         case 23: return "casts polymorph spell on characters (1 hour duration).";
         case 24: return "presents puzzle or riddle.";
         case 25: return "prevents movement.";
         case 26: return "releases coins, false coins, gems, false gems, magic item, or map.";
         case 27: return "releases, summons, or transforms into monster.";
         case 28: return "casts suggestion spell on characters.";
         case 29: return "wails loudly when touched.";
         case 30: return "speaks (normal, nonsense, poetry/rhymes, sings, casts spells, or screams).";
         case 31: return "teleports characters to another place.";
         case 32: return "swaps the minds of two or more characters.";
         default: return "ages (1d4x10 years) first person to touch it.";
      }
   }
   // END OF CODE
}