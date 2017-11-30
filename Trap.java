/********************************************************
* Author: Nick Foster
*
* Last edited: 9/13/2017
********************************************************/

public class Trap {
   // fields
   private enum Severity {SETBACK, DANGEROUS, DEADLY}
   private enum Tier {BASIC, HEROIC, PARAGON, IMMORTAL}
   
   private static Severity severity = Severity.SETBACK;
   private static Tier tier = Tier.BASIC;
   
   // constructors
   
   // methods
   public static String rollTrap() {
      severity = trapSeverity();
      tier = trapTier(Dice.getLevel());
      String trap = String.format("%n%s Trap: %n%s %ntriggered by %s %n[Attack: %s %s]",
                        severity, trapEffect(), trapTrigger(), trapAttack(), trapDamage());
      
      return trap;
   }
   
   public static String trapTrigger() {
      switch (Dice.deeRoll(1,6)) {
         case 2: return "pass through (e.g. doorway, hallway)";
         case 3: return "touch (e.g. doorknob, statue)";
         case 4: return "open (e.g. door, treasure chest)";
         case 5: return "look at (e.g. mural, arcane symbol)";
         case 6: return "move object (e.g. cart, stone block)";
         default: return "step on (e.g. floor, stairs)";
      }
   }
   
   public static Severity trapSeverity() {
      switch (Dice.deeRoll(1,6)) {
         case 1: 
         case 2: return Severity.SETBACK;
         case 6: return Severity.DEADLY;
         default: return Severity.DANGEROUS;
      }
   }
   
   public static Tier trapTier(int level) {
      if (level >= 1 && level <= 4)
         return Tier.BASIC;
      if (level >= 5 && level <= 10)
         return Tier.HEROIC;
      if (level >= 11 && level <= 16)
         return Tier.PARAGON;
      else
         return Tier.IMMORTAL;
   }
   
   public static String trapAttack() {
      switch (severity) {
         case DANGEROUS:   return "+6 to +8 (save DC 12-15)";
         case DEADLY:      return "+9 to +12 (save DC 16-20)";
         default:          return "+3 to +5 (save DC 10-11)";
      }
   }
   
   public static String trapDamage() {
      switch (severity) {
         case DANGEROUS:   return dangerousDamage();
         case DEADLY:      return deadlyDamage();
         default:          return setbackDamage();
      }
   }
   
   public static String setbackDamage() {
      switch (tier) {
         case HEROIC:   return "(11) 2d10 damage";
         case PARAGON:  return "(22) 4d10 damage";
         case IMMORTAL: return "(55) 10d10 damage";
         default:       return "(5) 1d10 damage";
      }
   }
   
   public static String dangerousDamage() {
      switch (tier) {
         case HEROIC:   return "(22) 4d10 damage";
         case PARAGON:  return "(55) 10d10 damage";
         case IMMORTAL: return "(99) 18d10 damage";
         default:       return "(11) 2d10 damage";
      }
   }
   
   public static String deadlyDamage() {
      switch (tier) {
         case HEROIC:   return "(55) 10d10 damage";
         case PARAGON:  return "(99) 18d10 damage";
         case IMMORTAL: return "(132) 24d10 damage";
         default:       return "(22) 4d10 damage";
      }
   }
   
   public static String trapEffect() {
      switch (Dice.deeRoll(1,31)) {
         case 2: return "Collapsing staircase creates ramp that deposits characters into a pit";
         case 3: return "Ceiling block falls, or entire ceiling collapses";
         case 4: return "Ceiling lowers slowly in locked room";
         case 5: return "Chute opens in floor";
         case 6: return "Clanging noise attracts nearby monsters.";
         case 7: return "Touching object triggers a disintegrate spell.";
         case 8: return "Door or other object coated with contact poison";
         case 9: return "Jet of flame shoots from wall, floor, or object";
         case 10: return "Touching an object triggers flesh to stone spell";
         case 11: return "Floor collapses or is an illusion";
         case 12: return "Vent releases gas (blinding, acidic, obscuring, paralyzing, poisonous, or sleep-inducing).";
         case 13: return "Floor tiles are electrified";
         case 14: return "Glyph of warding spell.";
         case 15: return "Huge, wheeled statue rolls down corridor.";
         case 16: return "Lightning bolt spell shoots from wall or object.";
         case 17: return "Locked room floods with water or acid.";
         case 18: return "Darts shoot out of an opened chest.";
         case 19: return "Weapon, suit of armor, or rug animates and attacks when touched.";
         case 20: return "Pendulum (bladed or weighted), swings across room or hallway.";
         case 21: return "Hidden pit opens beneath character (25%% chance of ooze fills bottom of pit.";
         case 22: return "Hidden pit floods with acid or fire.";
         case 23: return "Locking pit floods with water.";
         case 24: return "Scything blade emerges from wall or object.";
         case 25: return "Spears (possibly poisoned) spring out.";
         case 26: return "Brittle stairs collapse over spikes.";
         case 27: return "Thunderwave spell knocks character into pit or spikes.";
         case 28: return "Steel or stone jaws restrain character.";
         case 29: return "Stone block smashes across hallway.";
         case 30: return "Symbol spell.";
         case 31: return "Walls slide together.";
         default: return "Magic missiles shoot from a statue or object.";
      }
   }
   
   // END OF CODE
}