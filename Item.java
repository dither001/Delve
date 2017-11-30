/****************************************
* Author: Nick Foster
*
* Last Edited: 8/1/2017
****************************************/

import java.util.ArrayList;

public class Item {
   private enum Type {     ARMOR, ART, COINS, GEMS,
                           POTION, RING, ROD, SCROLL,
                           STAFF, WAND, WEAPON, WONDROUS}
   private enum Rarity {   COMMON, UNCOMMON, RARE, VERY_RARE, LEGEND}
   private enum Tier {     BASIC, HEROIC, PARAGON, IMMORTAL}
   
   // fields
   private String name;
   private Type type;
   private Rarity rarity;
   private boolean attuned;
   private int value;
   
   // constructors
   public Item (String s, Type t, Rarity r, boolean a, int v) {
      name = s;
      type = t;
      rarity = r;
      attuned = a;
      value = v;
   }
   
   // static methods
   public static ArrayList<Item> generateHoard(int level) {
      if (level <= 4) return basicHoard();
      else if (level >= 5 && level <= 10) return heroicHoard();
      else if (level >= 11 && level <= 16) return paragonHoard();
      else return immortalHoard();
   }
   
   public static ArrayList<Item> basicHoard() {
      ArrayList<Item> a = new ArrayList<Item>();
      a.add(new Item("copper piece", Type.COINS, Rarity.COMMON, false, 500));
      // 500 copper
      a.add(new Item("silver pieces", Type.COINS, Rarity.COMMON, false, 50));
      // 50 silver
      a.add(new Item("gold pieces", Type.COINS, Rarity.COMMON, false, 10));
      // 10 gold
      
      int n = Dice.deeRoll(1,100);
      if (n <= 5) {                       // no magic, no gems, no art
         return a;
      }
      else if (n >= 6 && n <= 25) {       // no magic
         a.add(basicObjects());
      }
      else if (n >= 26 && n <= 50) {      // 1d6 A-type
         a.add(basicObjects());
         for (int i = Dice.deeRoll(1,6); i > 0; --i)
            {a.add(selectTableA());}
      }
      else if (n >= 51 && n <= 70) {      // 1d4 B-type
         a.add(basicObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableB());}
      }
      else if (n >= 71 && n <= 85) {      // 1d4 C-type
         a.add(basicObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableC());}
      }
      else if (n >= 86 && n <= 95) {      // 1d4 F-type
         a.add(basicObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableF());}
      }
      else {                              // 1 G-type
         a.add(basicObjects());
         a.add(selectTableG());
      }
      
      // items returned as a group
      return a;
   }
   
   public static ArrayList<Item> heroicHoard() {
      ArrayList<Item> a = new ArrayList<Item>();
      a.add(new Item("copper pieces", Type.COINS, Rarity.COMMON, false, 100));
      // 100 copper
      a.add(new Item("silver pieces", Type.COINS, Rarity.COMMON, false, 100));
      // 100 silver
      a.add(new Item("gold pieces", Type.COINS, Rarity.UNCOMMON, false, 500));
      // 500 gold
      a.add(new Item("platinum pieces", Type.COINS, Rarity.UNCOMMON, false, 20));
      // 20 platinum
      
      int n = Dice.deeRoll(1,100);
      if (n <= 4) {                       // no magic, no gems, no art
         return a;
      }
      else if (n >= 5 && n <= 28) {       // no magic
         a.add(heroicObjects());
      }
      else if (n >= 29 && n <= 44) {      // 1d6 A-type
         a.add(heroicObjects());
         for (int i = Dice.deeRoll(1,6); i > 0; --i)
            {a.add(selectTableA());}
      }
      else if (n >= 45 && n <= 63) {      // 1d4 B-type
         a.add(heroicObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableB());}
      }
      else if (n >= 64 && n <= 74) {      // 1d4 C-type
         a.add(heroicObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableC());}
      }
      else if (n >= 75 && n <= 80) {      // 1 D-type
         a.add(heroicObjects());
         a.add(selectTableD());
      }
      else if (n >= 81 && n <= 94) {      // 1d4 F-type
         a.add(heroicObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableF());}
      }
      else if (n >= 95 && n <= 98) {      // 1d4 G-type
         a.add(heroicObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableG());}
      }
      else {                              // 1 H-type
         a.add(heroicObjects());
         a.add(selectTableH());
      }
      
      // items returned as a group
      return a;
   }
   
   public static ArrayList<Item> paragonHoard() {
      ArrayList<Item> a = new ArrayList<Item>();
      a.add(new Item("gold pieces", Type.COINS, Rarity.RARE, false, 2000));
      // 2,000 gold
      a.add(new Item("platinum pieces", Type.COINS, Rarity.RARE, false, 500));
      // 500 platinum
      
      int n = Dice.deeRoll(1,100);
      if (n <= 3) {                       // no magic, no gems, no art
         return a;
      }
      else if (n >= 4 && n <= 15) {       // no magic
         a.add(paragonObjects());
      }
      else if (n >= 16 && n <= 29) {      // 1d4 A-type + 1d6 B-type
         a.add(paragonObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableA());}
         for (int i = Dice.deeRoll(1,6); i > 0; --i)
            {a.add(selectTableB());}
      }
      else if (n >= 30 && n <= 50) {      // 1d6 C-type
         a.add(paragonObjects());
         for (int i = Dice.deeRoll(1,6); i > 0; --i)
            {a.add(selectTableC());}
      }
      else if (n >= 51 && n <= 66) {      // 1d4 D-type
         a.add(paragonObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableD());}
      }
      else if (n >= 67 && n <= 74) {      // 1 E-type
         a.add(paragonObjects());
         a.add(selectTableE());
      }
      else if (n >= 75 && n <= 82) {      // 1 F-type + 1d4 G-Type
         a.add(paragonObjects());
         {a.add(selectTableF());}
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableG());}
      }
      else if (n >= 83 && n <= 92) {      // 1d4 H-type
         a.add(paragonObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableH());}
      }
      else {                              // 1 I-type
         a.add(paragonObjects());
         a.add(selectTableI());
      }
      
      // items returned as a group
      return a;
   }
   
   public static ArrayList<Item> immortalHoard() {
      ArrayList<Item> a = new ArrayList<Item>();
      a.add(new Item("gold pieces", Type.COINS, Rarity.VERY_RARE, false, 7000));
      // 7,000 gold
      a.add(new Item("platinum pieces", Type.COINS, Rarity.VERY_RARE, false, 5000));
      // 5,000 platinum
      
      int n = Dice.deeRoll(1,100);
      if (n <= 2) {                       // no magic, no gems, no art
         return a;
      }
      else if (n >= 3 && n <= 14) {       // 1d8 C-type
         a.add(immortalObjects());
         for (int i = Dice.deeRoll(1,8); i > 0; --i)
            {a.add(selectTableC());}
      }
      else if (n >= 15 && n <= 46) {      // 1d6 D-type
         a.add(immortalObjects());
         for (int i = Dice.deeRoll(1,6); i > 0; --i)
            {a.add(selectTableD());}
      }
      else if (n >= 47 && n <= 68) {      // 1d6 E-type
         a.add(immortalObjects());
         for (int i = Dice.deeRoll(1,6); i > 0; --i)
            {a.add(selectTableE());}
      }
      else if (n >= 69 && n <= 72) {      // 1d4 G-type
         a.add(immortalObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableG());}
      }
      else if (n >= 73 && n <= 80) {      // 1d4 H-type
         a.add(immortalObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableH());}
      }
      else {                              // 1d4 I-type
         a.add(immortalObjects());
         for (int i = Dice.deeRoll(1,4); i > 0; --i)
            {a.add(selectTableI());}
      }
      
      // items returned as a group
      return a;
   }
   
   public static Item basicObjects() {
      switch (Dice.deeRoll(1,3)) {
         case 2: return new Item(twentyGpArt(), Type.GEMS, Rarity.COMMON, false, 25);
         case 3: return new Item(fiftyGpGems(), Type.GEMS, Rarity.COMMON, false, 50);
         default: return new Item(tenGpGems(), Type.GEMS, Rarity.COMMON, false, 10);
      }
   }
   
   public static Item heroicObjects() {
      switch (Dice.deeRoll(1,4)) {
         case 2: return new Item(fiftyGpGems(), Type.GEMS, Rarity.COMMON, false, 50);
         case 3: return new Item(hundredGpGems(), Type.GEMS, Rarity.COMMON, false, 100);
         case 4: return new Item(twoHundredGpArt(), Type.ART, Rarity.UNCOMMON, false, 250);
         default: return new Item(twentyGpArt(), Type.ART, Rarity.COMMON, false, 25);
      }
   }
   
   public static Item paragonObjects() {
      switch (Dice.deeRoll(1,4)) {
         case 2: return new Item(fiveHundredGpGems(), Type.GEMS, Rarity.UNCOMMON, false, 500);
         case 3: return new Item(sevenHundredGpArt(), Type.ART, Rarity.RARE, false, 750);
         case 4: return new Item(thousandGpGems(), Type.GEMS, Rarity.RARE, false, 1000);
         default: return new Item(twoHundredGpArt(), Type.ART, Rarity.UNCOMMON, false, 200);
      }
   }
   
   public static Item immortalObjects() {
      switch (Dice.deeRoll(1,4)) {
         case 2: return new Item(twoThousandGpArt(), Type.ART, Rarity.RARE, false, 2500);
         case 3: return new Item(fiveThousandGpGems(), Type.GEMS, Rarity.RARE, false, 5000);
         case 4: return new Item(sevenThousandGpArt(), Type.ART, Rarity.VERY_RARE, false, 7500);
         default: return new Item(thousandGpGems(), Type.GEMS, Rarity.RARE, false, 1000);
      }
   }
   
   public static String tenGpGems() {
      switch (Dice.deeRoll(1,12)) {
         case 2: return "banded agate";
         case 3: return "blue quartz";
         case 4: return "eye agate";
         case 5: return "hematite";
         case 6: return "lapis lazuli";
         case 7: return "malachite";
         case 8: return "moss agate";
         case 9: return "obsidian";
         case 10: return "rhodochrosite";
         case 11: return "tiger eye";
         case 12: return "turquoise";
         default: return "azurite";
      }
   }
   
   public static String fiftyGpGems() {
      switch (Dice.deeRoll(1,12)) {
         case 2: return "carnelian";
         case 3: return "chalcedony";
         case 4: return "chrysoprase";
         case 5: return "citrine";
         case 6: return "jasper";
         case 7: return "moonstone";
         case 8: return "onyx";
         case 9: return "quartz";
         case 10: return "sardonyx";
         case 11: return "rose quartz";
         case 12: return "zircon";
         default: return "bloodstone";
      }
   }
   
   public static String hundredGpGems() {
      switch (Dice.deeRoll(1,10)) {
         case 2: return "amethyst";
         case 3: return "chrysoberyl";
         case 4: return "coral";
         case 5: return "garnet";
         case 6: return "jade";
         case 7: return "jet";
         case 8: return "pearl";
         case 9: return "spinel";
         case 10: return "tourmaline";
         default: return "amber";
      }
   }
   
   public static String fiveHundredGpGems() {
      switch (Dice.deeRoll(1,6)) {
         case 2: return "aquamarine";
         case 3: return "black pearl";
         case 4: return "blue spinel";
         case 5: return "peridot";
         case 6: return "topaz";
         default: return "alexandrite";
      }
   }
   
   public static String thousandGpGems() {
      switch (Dice.deeRoll(1,8)) {
         case 2: return "blue sapphire";
         case 3: return "emerald";
         case 4: return "fire opal";
         case 5: return "opal";
         case 6: return "star ruby";
         case 7: return "star sapphire";
         case 8: return "yellow sapphire";
         default: return "black opal";
      }
   }
   
   public static String fiveThousandGpGems() {
      switch (Dice.deeRoll(1,4)) {
         case 2: return "diamond";
         case 3: return "jacinth";
         case 4: return "ruby";
         default: return "black sapphire";
      }
   }
   
   public static String twentyGpArt() {
      switch (Dice.deeRoll(1,10)) {
         case 2: return "carved bone idol";
         case 3: return "small gold bracelet";
         case 4: return "golden filigree";
         case 5: return "velvet mask";
         case 6: return "copper chalice";
         case 7: return "carved bone dice";
         case 8: return "small mirror";
         case 9: return "silk handkerchief";
         case 10: return "golden locket";
         default: return "silver ewer";
      }
   }
   
   public static String twoHundredGpArt() {
      switch (Dice.deeRoll(1,10)) {
         case 2: return "carved ivory idol";
         case 3: return "large gold bracelet";
         case 4: return "gemstone pendant";
         case 5: return "bronze crown";
         case 6: return "fancy silk robe";
         case 7: return "elegant tapestry";
         case 8: return "brass gemstone mug";
         case 9: return "turquoise figurines";
         case 10: return "golden birdcage";
         default: return "bloodstone ring";
      }
   }
   
   public static String sevenHundredGpArt() {
      switch (Dice.deeRoll(1,10)) {
         case 2: return "silver longsword";
         case 3: return "exotic wood harp";
         case 4: return "small gold idol";
         case 5: return "gold gemstone comb";
         case 6: return "fancy gold flask";
         case 7: return "ceremonial dagger";
         case 8: return "gold-silver brooch";
         case 9: return "obsidian idol";
         case 10: return "golden war mask";
         default: return "moonstone chalice";
      }
   }
   
   public static String twoThousandGpArt() {
      switch (Dice.deeRoll(1,10)) {
         case 2: return "old fancy painting";
         case 3: return "fancy mantlepiece";
         case 4: return "sapphire bracelet";
         case 5: return "embroidered glove";
         case 6: return "jeweled anklet";
         case 7: return "gold music box";
         case 8: return "aquamarine circlet";
         case 9: return "gemstone false eye";
         case 10: return "pearl necklace";
         default: return "fire opal pendant";
      }
   }
   
   public static String sevenThousandGpArt() {
      switch (Dice.deeRoll(1,8)) {
         case 2: return "platinum ring";
         case 3: return "gold ruby idol";
         case 4: return "gold emerald cup";
         case 5: return "gold jewelry box";
         case 6: return "gold sarcophagus";
         case 7: return "jade game board";
         case 8: return "ivory drink cup";
         default: return "gold jewel crown";
      }
   }
   
   public static Item selectTableA() {
      int n = Dice.deeRoll(1,100);
      
      if (n <= 50)
         return new Item("Potion of healing, basic", Type.POTION, Rarity.COMMON, false, 100);
      else if (n >= 51 && n <= 60)
         return new Item("Spell scroll (cantrip)", Type.SCROLL, Rarity.COMMON, false, 100);
      else if (n >= 61 && n <= 70)
         return new Item("Potion of climbing", Type.POTION, Rarity.COMMON, false, 100);
      else if (n >= 71 && n <= 90)
         return new Item("Spell scroll (1st)", Type.SCROLL, Rarity.COMMON, false, 100);
      else if (n >= 91 && n <= 94)
         return new Item("Spell scroll (2nd)", Type.SCROLL, Rarity.UNCOMMON, false, 500);
      else if (n >= 91 && n <= 98)
         return new Item("Potion of healing, greater", Type.POTION, Rarity.UNCOMMON, false, 500);
      else if (n == 99)
         return new Item("Bag of holding", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
      else
         return new Item("Driftglobe", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
   }
   
   public static Item selectTableB() {
      switch (Dice.deeRoll(1,100)) {
         case 15: return new Item("Potion of healing, greater", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 16: 
         case 17: 
         case 18: 
         case 19: 
         case 20: 
         case 21: 
         case 22: return new Item("Potion of fire breath", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 23: 
         case 24: 
         case 25: 
         case 26: 
         case 27: 
         case 28: 
         case 29: return new Item("Potion of resistance", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 30: 
         case 31: 
         case 32: 
         case 33: 
         case 34: return new Item("Magic arrow (+1)", Type.WEAPON, Rarity.UNCOMMON, false, 500);
         case 35: 
         case 36: 
         case 37: 
         case 38: 
         case 39: return new Item("Potion of animal friend", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 40: 
         case 41: 
         case 42: 
         case 43: 
         case 44: return new Item("Potion of hill giant", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 45: 
         case 46: 
         case 47: 
         case 48: 
         case 49: return new Item("Potion of growth", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 50: 
         case 51: 
         case 52: 
         case 53: 
         case 54: return new Item("Potion of water breathing", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 55: 
         case 56: 
         case 57: 
         case 58: 
         case 59: return new Item("Spell scroll (2nd)", Type.SCROLL, Rarity.UNCOMMON, false, 500);
         case 60: 
         case 61: 
         case 62: 
         case 63: 
         case 64: return new Item("Spell scroll (3rd)", Type.SCROLL, Rarity.UNCOMMON, false, 500);
         case 65: 
         case 66: 
         case 67: return new Item("Bag of holding", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 68: 
         case 69: 
         case 70: return new Item("Keoghtom's ointment", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 71: 
         case 72: 
         case 73: return new Item("Oil of slipperiness", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 74: 
         case 75: return new Item("Dust of disappearance", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 76: 
         case 77: return new Item("Dust of dryness", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 78: 
         case 79: return new Item("Dust of sneezing", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 80: 
         case 81: return new Item("Elemental gem", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 82: 
         case 83: return new Item("Philter of love", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 84: return new Item("Alchemy jug", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 85: return new Item("Cap of water breathing", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 86: return new Item("Cloak of the manta ray", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 87: return new Item("Driftglobe", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 88: return new Item("Goggles of night", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 89: return new Item("Helm of languages", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 90: return new Item("Immovable rod", Type.ROD, Rarity.UNCOMMON, false, 500);
         case 91: return new Item("Lantern of revealing", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 92: return new Item("Mariner's armor", Type.ARMOR, Rarity.UNCOMMON, false, 500);
         case 93: return new Item("Mithral armor", Type.ARMOR, Rarity.UNCOMMON, false, 500);
         case 94: return new Item("Potion of poison", Type.POTION, Rarity.UNCOMMON, false, 500);
         case 95: return new Item("Ring of swimming", Type.RING, Rarity.UNCOMMON, false, 500);
         case 96: return new Item("Robe of useful items", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 97: return new Item("Rope of climbing", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 98: return new Item("Saddle of the cavalier", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 99: return new Item("Wand of magic detect", Type.WAND, Rarity.UNCOMMON, false, 500);
         case 100: return new Item("Wand of secrets", Type.WAND, Rarity.UNCOMMON, false, 500);
         default: return new Item("Potion of healing, greater", Type.POTION, Rarity.UNCOMMON, false, 500);
      }
   }
   
   public static Item selectTableC() {
      switch (Dice.deeRoll(1,100)) {
         case 15: return new Item("Potion of healing, super", Type.POTION, Rarity.VERY_RARE, false, 50000);
         case 16: 
         case 17: 
         case 18: 
         case 19: 
         case 20: 
         case 21: 
         case 22: return new Item("Spell scroll (4th)", Type.SCROLL, Rarity.RARE, false, 5000);
         case 23: 
         case 24: 
         case 25: 
         case 26: 
         case 27: return new Item("Magic arrow (+2)", Type.WEAPON, Rarity.RARE, false, 5000);
         case 28: 
         case 29: 
         case 30: 
         case 31: 
         case 32: return new Item("Potion of clairvoyance", Type.POTION, Rarity.RARE, false, 5000);
         case 33: 
         case 34: 
         case 35: 
         case 36: 
         case 37: return new Item("Potion of diminution", Type.POTION, Rarity.RARE, false, 5000);
         case 38: 
         case 39: 
         case 40: 
         case 41: 
         case 42: return new Item("Potion of gaseous form", Type.POTION, Rarity.RARE, false, 5000);
         case 43: 
         case 44: 
         case 45: 
         case 46: 
         case 47: return new Item("Potion of frost giant (23)", Type.POTION, Rarity.RARE, false, 5000);
         case 48: 
         case 49: 
         case 50: 
         case 51: 
         case 52: return new Item("Potion of stone giant (23)", Type.POTION, Rarity.RARE, false, 5000);
         case 53: 
         case 54: 
         case 55: 
         case 56: 
         case 57: return new Item("Potion of heroism", Type.POTION, Rarity.RARE, false, 5000);
         case 58: 
         case 59: 
         case 60: 
         case 61: 
         case 62: return new Item("Potion of invulnerability", Type.POTION, Rarity.RARE, false, 5000);
         case 63: 
         case 64: 
         case 65: 
         case 66: 
         case 67: return new Item("Potion of mind reading", Type.POTION, Rarity.RARE, false, 5000);
         case 68: 
         case 69: 
         case 70: 
         case 71: 
         case 72: return new Item("Spell scroll (5th)", Type.SCROLL, Rarity.RARE, false, 5000);
         case 73: 
         case 74: 
         case 75: return new Item("Elixir of health", Type.POTION, Rarity.RARE, false, 5000);
         case 76: 
         case 77: 
         case 78: return new Item("Oil of etherealess", Type.POTION, Rarity.RARE, false, 5000);
         case 79: 
         case 80: 
         case 81: return new Item("Potion of fire giant (25)", Type.POTION, Rarity.RARE, false, 5000);
         case 82: 
         case 83: 
         case 84: return new Item("Quaal's feather token", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 85: 
         case 86: 
         case 87: return new Item("Scroll of protection", Type.SCROLL, Rarity.RARE, false, 5000);
         case 88: 
         case 89: return new Item("Bag of beans", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 90: 
         case 91: return new Item("Bead of force", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 92: return new Item("Chime of opening", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 93: return new Item("Decanter of water", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 94: return new Item("Eyes of minute seeing", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 95: return new Item("Folding boat", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 96: return new Item("Heward's haversack", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 97: return new Item("Horseshoes of speed", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 98: return new Item("Necklace of fireballs", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 99: return new Item("Periapt of health", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 100: return new Item("Sending stones", Type.WONDROUS, Rarity.RARE, false, 5000);
         default: return new Item("Potion of healing, super", Type.POTION, Rarity.VERY_RARE, false, 50000);
      }
   }
   
   public static Item selectTableD() {
      int n = Dice.deeRoll(1,100);
      
      if (n <= 20)
         return new Item("Potion of healing, super", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 21 && n <= 30)
         return new Item("Potion of invisibility", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 31 && n <= 40)
         return new Item("Potion of speed", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 41 && n <= 50)
         return new Item("Spell scroll (6th)", Type.SCROLL, Rarity.VERY_RARE, false, 50000);
      else if (n >= 51 && n <= 57)
         return new Item("Spell scroll (7th)", Type.SCROLL, Rarity.VERY_RARE, false, 50000);
      else if (n >= 58 && n <= 62)
         return new Item("Magic arrow (+3)", Type.WEAPON, Rarity.VERY_RARE, false, 50000);
      else if (n >= 63 && n <= 67)
         return new Item("Oil of sharpness", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 68 && n <= 72)
         return new Item("Potion of flying", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 73 && n <= 77)
         return new Item("Potion of cloud giant", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 78 && n <= 82)
         return new Item("Potion of longevity", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 83 && n <= 87)
         return new Item("Potion of vitality", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 88 && n <= 92)
         return new Item("Spell scroll (8th)", Type.SCROLL, Rarity.VERY_RARE, false, 50000);
      else if (n >= 93 && n <= 95)
         return new Item("Horseshoes of zephyr", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
      else if (n >= 96 && n <= 98)
         return new Item("Nolzur's pigments", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
      else if (n == 99)
         return new Item("Bag of devouring", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
      else
         return new Item("Portable hole", Type.WONDROUS, Rarity.RARE, false, 5000);
   }
   
   public static Item selectTableE() {
      int n = Dice.deeRoll(1,100);
      
      if (n <= 30)
         return new Item("Spell scroll (8th)", Type.SCROLL, Rarity.VERY_RARE, false, 50000);
      else if (n >= 31 && n <= 55)
         return new Item("Potion of storm giant", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 56 && n <= 70)
         return new Item("Potion of healing, super", Type.POTION, Rarity.VERY_RARE, false, 50000);
      else if (n >= 71 && n <= 85)
         return new Item("Spell scroll (9th)", Type.SCROLL, Rarity.LEGEND, false, 99000);
      else if (n >= 86 && n <= 93)
         return new Item("Universal solvent", Type.WONDROUS, Rarity.LEGEND, false, 99000);
      else if (n >= 94 && n <= 98)
         return new Item("Arrow of slaying", Type.WEAPON, Rarity.VERY_RARE, false, 50000);
      else
         return new Item("Sovereign glue", Type.WONDROUS, Rarity.LEGEND, false, 99000);
   }
   
   public static Item selectTableF() {
      switch (Dice.deeRoll(1,100)) {
         case 15: return new Item("Magic weapon (+1)", Type.WEAPON, Rarity.UNCOMMON, false, 500);
         case 16: 
         case 17: 
         case 18: return new Item("Magic shield (+1)", Type.ARMOR, Rarity.UNCOMMON, false, 500);
         case 19: 
         case 20: 
         case 21: return new Item("Sentinel shield", Type.ARMOR, Rarity.UNCOMMON, true, 500);
         case 22: 
         case 23: return new Item("Amulet against detect", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 24: 
         case 25: return new Item("Boots of elvenkind", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 26: 
         case 27: return new Item("Boots of striding", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 28: 
         case 29: return new Item("Bracers of archery", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 30: 
         case 31: return new Item("Brooch of shielding", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 32: 
         case 33: return new Item("Broom of flying", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 34: 
         case 35: return new Item("Cloak of elvenkind", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 36: 
         case 37: return new Item("Cloak of protection (+1)", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 38: 
         case 39: return new Item("Gauntlets of ogre power", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 40: 
         case 41: return new Item("Hat of disguise", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 42: 
         case 43: return new Item("Javelin of lightning", Type.WEAPON, Rarity.UNCOMMON, false, 500);
         case 44: 
         case 45: return new Item("Pearl of power", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 46: 
         case 47: return new Item("Magic rod (+1)", Type.ROD, Rarity.UNCOMMON, true, 500);
         case 48: 
         case 49: return new Item("Slippers of spider climb", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 50: 
         case 51: return new Item("Staff of the adder", Type.STAFF, Rarity.UNCOMMON, true, 500);
         case 52: 
         case 53: return new Item("Staff of the python", Type.STAFF, Rarity.UNCOMMON, true, 500);
         case 54: 
         case 55: return new Item("Sword of vengeance", Type.WEAPON, Rarity.UNCOMMON, true, 500);
         case 56: 
         case 57: return new Item("Trident of fish command", Type.WEAPON, Rarity.UNCOMMON, true, 500);
         case 58: 
         case 59: return new Item("Wand of magic missiles", Type.WAND, Rarity.UNCOMMON, true, 500);
         case 60: 
         case 61: return new Item("Magic wand (+1)", Type.WAND, Rarity.UNCOMMON, true, 500);
         case 62: 
         case 63: return new Item("Wand of web", Type.WAND, Rarity.UNCOMMON, true, 500);
         case 64: 
         case 65: return new Item("Weapon of warning", Type.WEAPON, Rarity.UNCOMMON, true, 500);
         case 66: 
         case 67: 
         case 68: return new Item("Adamantine armor", Type.ARMOR, Rarity.UNCOMMON, false, 500);
         case 69: return new Item("Bag of tricks (gray)", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 70: return new Item("Bag of tricks (rust)", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 71: return new Item("Bag of tricks (tan)", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 72: return new Item("Boots of the winderlands", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 73: return new Item("Circlet of blasting", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 74: return new Item("Deck of illusions", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 75: return new Item("Eversmoking bottle", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 76: return new Item("Eyes of charming", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 77: return new Item("Eyes of the eagle", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 78: return new Item("Figurine (silver raven)", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 79: return new Item("Gem of brightness", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 80: return new Item("Gloves of missile snaring", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 81: return new Item("Gloves of swimming", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 82: return new Item("Gloves of thievery", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 83: return new Item("Headband of intellect (19)", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 84: return new Item("Helm of telepathy", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 85: return new Item("Doss lute", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 86: return new Item("Fochlucan bandore", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 87: return new Item("Mac-Fuimidh cittern", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 88: return new Item("Medallion of thoughts", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 89: return new Item("Necklace of adaptation", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 90: return new Item("Periapt of wound close", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 91: return new Item("Pipes of haunting", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 92: return new Item("Pipes of the sewers", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 93: return new Item("Ring of jumping", Type.RING, Rarity.UNCOMMON, true, 500);
         case 94: return new Item("Ring of mind shielding", Type.RING, Rarity.UNCOMMON, true, 500);
         case 95: return new Item("Ring of warmth", Type.RING, Rarity.UNCOMMON, true, 500);
         case 96: return new Item("Ring of water walking", Type.RING, Rarity.UNCOMMON, false, 500);
         case 97: return new Item("Quiver of Ehlonna", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 98: return new Item("Stone of good luck", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         case 99: return new Item("Wind fan", Type.WONDROUS, Rarity.UNCOMMON, false, 500);
         case 100: return new Item("Winged boots", Type.WONDROUS, Rarity.UNCOMMON, true, 500);
         default: return new Item("Magic weapon +1", Type.WEAPON, Rarity.UNCOMMON, false, 500);
      }
   }
   
   public static Item selectTableG() {
      switch (Dice.deeRoll(1,100)) {
         case 11: return new Item("Magic weapon (+2)", Type.WEAPON, Rarity.RARE, false, 5000);
         case 12: 
         case 13: 
         case 14: return new Item("Figurine (1d8)", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 15: 
         case 16: return new Item("Adamantine armor", Type.ARMOR, Rarity.RARE, false, 5000);
         case 17: return new Item("Amulet of health (19)", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 18: return new Item("Armor of vulnerability", Type.ARMOR, Rarity.RARE, true, 5000);
         case 19: return new Item("Arrow-catching shield", Type.ARMOR, Rarity.RARE, true, 5000);
         case 20: return new Item("Belt of dwarvenkind", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 21: return new Item("Belt of hill giant (21)", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 22: return new Item("Berserker axe", Type.WEAPON, Rarity.RARE, true, 5000);
         case 23: return new Item("Boots of levitation", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 24: return new Item("Boots of speed", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 25: return new Item("Bowl of water elementals", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 26: return new Item("Brazier of fire elementals", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 27: return new Item("Censer of air elementals", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 28: return new Item("Stone of earth elementals", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 29: return new Item("Bracers of defense", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 30: return new Item("Cape of the mountebank", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 31: return new Item("Cloak of displacement", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 32: return new Item("Cloak of the bat", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 33: return new Item("Cube of force", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 34: return new Item("Daern's instant fort", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 35: return new Item("Dagger of venom", Type.WEAPON, Rarity.RARE, false, 5000);
         case 36: return new Item("Dimensional shackles", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 37: return new Item("Dragon slayer", Type.WEAPON, Rarity.RARE, false, 5000);
         case 38: return new Item("Elven chain shirt", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 39: return new Item("Flame tongue", Type.WEAPON, Rarity.RARE, true, 5000);
         case 40: return new Item("Gem of seeing", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 41: return new Item("Giant slayer (+1)", Type.WEAPON, Rarity.RARE, false, 5000);
         case 42: return new Item("Glamoured leather", Type.ARMOR, Rarity.RARE, false, 5000);
         case 43: return new Item("Helm of teleportation", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 44: return new Item("Horn of blasting", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 45: return new Item("Horn of Valhalla (silver)", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 46: return new Item("Canaith mandolin", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 47: return new Item("Cli lyre", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 48: return new Item("Ioun stone (awareness)", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 49: return new Item("Ioun stone (protection)", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 50: return new Item("Ioun stone (reserve)", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 51: return new Item("Ioun stone (sustenance)", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 52: return new Item("Iron bands of Bilarro", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 53: return new Item("Mace of disruption", Type.WEAPON, Rarity.RARE, true, 5000);
         case 54: return new Item("Mace of smiting (+1)", Type.WEAPON, Rarity.RARE, false, 5000);
         case 55: return new Item("Mace of terror", Type.WEAPON, Rarity.RARE, true, 5000);
         case 56: return new Item("Mantle of spell resistance", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 57: return new Item("Necklace of prayer beads", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 58: return new Item("Periapt against poison", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 59: return new Item("Ring of animal influence", Type.RING, Rarity.RARE, true, 5000);
         case 60: return new Item("Ring of evasion", Type.RING, Rarity.RARE, true, 5000);
         case 61: return new Item("Ring of feather fall", Type.RING, Rarity.RARE, true, 5000);
         case 62: return new Item("Ring of free action", Type.RING, Rarity.RARE, true, 5000);
         case 63: return new Item("Ring of protection (+1)", Type.RING, Rarity.RARE, true, 5000);
         case 64: return new Item("Ring of resistance", Type.RING, Rarity.RARE, true, 5000);
         case 65: return new Item("Ring of spell storing", Type.RING, Rarity.RARE, true, 5000);
         case 66: return new Item("Ring of the ram", Type.RING, Rarity.RARE, true, 5000);
         case 67: return new Item("Ring of x-ray vision", Type.RING, Rarity.RARE, true, 5000);
         case 68: return new Item("Robe of eyes", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 69: return new Item("Rod of rulership", Type.ROD, Rarity.RARE, true, 5000);
         case 70: return new Item("Magic rod (+2)", Type.ROD, Rarity.RARE, true, 5000);
         case 71: return new Item("Rope of entanglement", Type.WONDROUS, Rarity.RARE, false, 5000);
         case 72: return new Item("Magic shield (+2)", Type.ARMOR, Rarity.RARE, false, 5000);
         case 73: return new Item("Shield of missile attract", Type.ARMOR, Rarity.RARE, true, 5000);
         case 74: return new Item("Staff of charming", Type.STAFF, Rarity.RARE, true, 5000);
         case 75: return new Item("Staff of healing", Type.STAFF, Rarity.RARE, true, 5000);
         case 76: return new Item("Staff of swarming insects", Type.STAFF, Rarity.RARE, true, 5000);
         case 77: return new Item("Staff of the woodlands", Type.STAFF, Rarity.RARE, true, 5000);
         case 78: return new Item("Staff of withering", Type.STAFF, Rarity.RARE, true, 5000);
         case 79: return new Item("Sun blade (+2)", Type.WEAPON, Rarity.RARE, true, 5000);
         case 80: return new Item("Sword of life stealing", Type.WEAPON, Rarity.RARE, true, 5000);
         case 81: return new Item("Sword of wounding", Type.WEAPON, Rarity.RARE, true, 5000);
         case 82: return new Item("Tentacle rod", Type.ROD, Rarity.RARE, true, 5000);
         case 83: return new Item("Vicious weapon", Type.WEAPON, Rarity.RARE, true, 5000);
         case 84: return new Item("Wand of binding", Type.WAND, Rarity.RARE, true, 5000);
         case 85: return new Item("Wand of enemy detect", Type.WAND, Rarity.RARE, true, 5000);
         case 86: return new Item("Wand of fear", Type.WAND, Rarity.RARE, true, 5000);
         case 87: return new Item("Wand of fireballs", Type.WAND, Rarity.RARE, true, 5000);
         case 88: return new Item("Wand of lightning bolts", Type.WAND, Rarity.RARE, true, 5000);
         case 89: return new Item("Wand of paralysis", Type.WAND, Rarity.RARE, true, 5000);
         case 90: return new Item("Magic wand (+2)", Type.WAND, Rarity.RARE, true, 5000);
         case 91: return new Item("Wand of wonder", Type.WAND, Rarity.RARE, true, 5000);
         case 92: return new Item("Wings of flying", Type.WONDROUS, Rarity.RARE, true, 5000);
         case 93: 
         case 94: 
         case 95: 
         case 96: return new Item("Magic armor (+1)", Type.ARMOR, Rarity.RARE, false, 5000);
         case 97: 
         case 98: 
         case 99: 
         case 100: return new Item("Armor of resistance", Type.ARMOR, Rarity.RARE, true, 5000);
         default: return new Item("Magic weapon (+2)", Type.WEAPON, Rarity.RARE, false, 5000);
      }
   }
   
   public static Item selectTableH() {
      switch (Dice.deeRoll(1,100)) {
         case 10: return new Item("Magic weapon (+3)", Type.WEAPON, Rarity.VERY_RARE, false, 50000);
         case 11: 
         case 12: return new Item("Amulet of the planes", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 13: 
         case 14: return new Item("Carpet of flying", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 15: 
         case 16: return new Item("Crystal ball", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 17: 
         case 18: return new Item("Ring of regeneration", Type.RING, Rarity.VERY_RARE, true, 50000);
         case 19: 
         case 20: return new Item("Ring of shooting stars", Type.RING, Rarity.VERY_RARE, true, 50000);
         case 21: 
         case 22: return new Item("Ring of telekinesis", Type.RING, Rarity.VERY_RARE, true, 50000);
         case 23: 
         case 24: return new Item("Robe of scintillating colors", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 25: 
         case 26: return new Item("Robes of stars", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 27: 
         case 28: return new Item("Rod of absorption", Type.ROD, Rarity.VERY_RARE, true, 50000);
         case 29: 
         case 30: return new Item("Rod of alertness", Type.ROD, Rarity.VERY_RARE, true, 50000);
         case 31: 
         case 32: return new Item("Rod of security", Type.ROD, Rarity.VERY_RARE, false, 50000);
         case 33: 
         case 34: return new Item("Magic rod (+3)", Type.ROD, Rarity.VERY_RARE, true, 50000);
         case 35: 
         case 36: return new Item("Scimitar of speed (+3)", Type.WEAPON, Rarity.VERY_RARE, true, 50000);
         case 37: 
         case 38: return new Item("Magic shield (+3)", Type.ARMOR, Rarity.VERY_RARE, false, 50000);
         case 39: 
         case 40: return new Item("Staff of fire", Type.STAFF, Rarity.VERY_RARE, true, 50000);
         case 41: 
         case 42: return new Item("Staff of frost", Type.STAFF, Rarity.VERY_RARE, true, 50000);
         case 43: 
         case 44: return new Item("Staff of power", Type.STAFF, Rarity.VERY_RARE, true, 50000);
         case 45: 
         case 46: return new Item("Staff of striking", Type.STAFF, Rarity.VERY_RARE, true, 50000);
         case 47: 
         case 48: return new Item("Staff of thunder and lightning", Type.STAFF, Rarity.VERY_RARE, true, 50000);
         case 49: 
         case 50: return new Item("Sword of sharpness", Type.WEAPON, Rarity.VERY_RARE, true, 50000);
         case 51: 
         case 52: return new Item("Wand of polymorph", Type.WAND, Rarity.VERY_RARE, true, 50000);
         case 53: 
         case 54: return new Item("Magic wand (+3)", Type.WAND, Rarity.VERY_RARE, true, 50000);
         case 55: 
         case 56: return new Item("Adamantine armor", Type.ARMOR, Rarity.UNCOMMON, true, 500);
         case 57: return new Item("Animated shield", Type.ARMOR, Rarity.VERY_RARE, true, 50000);
         case 58: return new Item("Belt of fire giant (25)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 59: return new Item("Belt of frost giant (27)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 60: return new Item("Candle of invocation", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 61: return new Item("Cloak of arachnida", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 62: return new Item("Dancing sword", Type.WEAPON, Rarity.VERY_RARE, true, 50000);
         case 63: return new Item("Demon plate armor", Type.ARMOR, Rarity.VERY_RARE, true, 50000);
         case 64: return new Item("Dragon scale mail", Type.ARMOR, Rarity.VERY_RARE, false, 50000);
         case 65: return new Item("Dwarven plate armor", Type.ARMOR, Rarity.VERY_RARE, false, 50000);
         case 66: return new Item("Dwarven thrower", Type.WEAPON, Rarity.VERY_RARE, true, 50000);
         case 67: return new Item("Efreeti bottle", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 68: return new Item("Figurine (obsidian steed)", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 69: return new Item("Frost brand", Type.WEAPON, Rarity.VERY_RARE, true, 50000);
         case 70: return new Item("Helm of brilliance", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 71: return new Item("Horn of Valhalla (bronze)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 72: return new Item("Anstruth harp", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 73: return new Item("Ioun stone (absorption)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 74: return new Item("Ioun stone (agility)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 75: return new Item("Ioun stone (fortitude)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 76: return new Item("Ioun stone (insight)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 77: return new Item("Ioun stone (intellect)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 78: return new Item("Ioun stone (leadership)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 79: return new Item("Ioun stone (strength)", Type.WONDROUS, Rarity.VERY_RARE, true, 50000);
         case 80: return new Item("Manual of bodily health", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 81: return new Item("Manual of gainful exercise", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 82: return new Item("Manual of quickness of action", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 83: return new Item("Manual of golems", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 84: return new Item("Mirror of life trapping", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 85: return new Item("Nine lives stealer", Type.WEAPON, Rarity.VERY_RARE, true, 50000);
         case 86: return new Item("Oathbow", Type.WEAPON, Rarity.VERY_RARE, true, 50000);
         case 87: return new Item("Spellguard shield", Type.ARMOR, Rarity.VERY_RARE, false, 50000);
         case 88: return new Item("Tome of clear thought", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 89: return new Item("Tome of leadership", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 90: return new Item("Tome of understanding", Type.WONDROUS, Rarity.VERY_RARE, false, 50000);
         case 91: 
         case 92: 
         case 93: return new Item("Magic armor (+1)", Type.ARMOR, Rarity.RARE, true, 5000);
         case 94: 
         case 95: 
         case 96: return new Item("Armor of resistance", Type.ARMOR, Rarity.RARE, true, 5000);
         case 97: 
         case 98: 
         case 99: 
         case 100: return new Item("Magic armor (+2)", Type.ARMOR, Rarity.RARE, true, 5000);
         default: return new Item("Magic weapon (+3)", Type.WEAPON, Rarity.VERY_RARE, false, 50000);
      }
   }
   
   public static Item selectTableI() {
      switch (Dice.deeRoll(1,100)) {
         case 5: return new Item("Defender (+3)", Type.WEAPON, Rarity.LEGEND, true, 99999);
         case 6: 
         case 7: 
         case 8: 
         case 9: 
         case 10: return new Item("Hammer of thunderbolts (+1)", Type.WEAPON, Rarity.LEGEND, true, 99999);
         case 11: 
         case 12: 
         case 13: 
         case 14: 
         case 15: return new Item("Luck blade (+1)", Type.WEAPON, Rarity.LEGEND, true, 99999);
         case 16: 
         case 17: 
         case 18: 
         case 19: 
         case 20: return new Item("Sword of answering (+3)", Type.WEAPON, Rarity.LEGEND, true, 99999);
         case 21: 
         case 22: 
         case 23: return new Item("Holy avenger (+3)", Type.WEAPON, Rarity.LEGEND, true, 99999);
         case 24: 
         case 25: 
         case 26: return new Item("Ring of djinni summoning", Type.RING, Rarity.LEGEND, true, 99999);
         case 27: 
         case 28: 
         case 29: return new Item("Ring of invisibility", Type.RING, Rarity.LEGEND, true, 99999);
         case 30: 
         case 31: 
         case 32: return new Item("Ring of spell turning", Type.RING, Rarity.LEGEND, true, 99999);
         case 33: 
         case 34: 
         case 35: return new Item("Rod of lordly might", Type.ROD, Rarity.LEGEND, true, 99999);
         case 36: 
         case 37: 
         case 38: return new Item("Staff of the magi", Type.STAFF, Rarity.LEGEND, true, 99999);
         case 39: 
         case 40: 
         case 41: return new Item("Vorpal sword (+3)", Type.WEAPON, Rarity.LEGEND, true, 99999);
         case 42: 
         case 43: return new Item("Belt of giant, cloud", Type.WONDROUS, Rarity.LEGEND, true, 99999);
         case 44: 
         case 45: return new Item("Cloak of invisibility", Type.WONDROUS, Rarity.LEGEND, true, 99999);
         case 46: 
         case 47: return new Item("Crystal ball (legendary)", Type.WONDROUS, Rarity.LEGEND, true, 99999);
         case 48: 
         case 49: return new Item("Iron flask", Type.WONDROUS, Rarity.LEGEND, false, 99999);
         case 50: 
         case 51: return new Item("Robe of the archmage", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 52: 
         case 53: return new Item("Rod of resurrection", Type.ROD, Rarity.LEGEND, true, 99999);
         case 54: 
         case 55: return new Item("Scarab of protection", Type.WONDROUS, Rarity.LEGEND, true, 99999);
         case 56: 
         case 57: return new Item("Well of many worlds", Type.WONDROUS, Rarity.LEGEND, false, 99999);
         case 58: 
         case 59: 
         case 60: 
         case 61: 
         case 62: 
         case 63: 
         case 64: return new Item("Magic armor (+1)", Type.ARMOR, Rarity.RARE, false, 99999);
         case 65: 
         case 66: 
         case 67: 
         case 68: 
         case 69: 
         case 70: 
         case 71: return new Item("Magic armor (+2)", Type.ARMOR, Rarity.VERY_RARE, false, 99999);
         case 72: 
         case 73: 
         case 74: 
         case 75: 
         case 76: 
         case 77: 
         case 78: return new Item("Magic armor (+3)", Type.ARMOR, Rarity.LEGEND, false, 99999);
         case 79: return new Item("Apparatus of Kwalish", Type.WONDROUS, Rarity.LEGEND, false, 99999);
         case 80: return new Item("Armor of invlunerability", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 81: return new Item("Belt of storm giant (29)", Type.ARMOR, Rarity.LEGEND, false, 99999);
         case 82: return new Item("Cubic gate)", Type.ARMOR, Rarity.LEGEND, false, 99999);
         case 83: return new Item("Deck of many things", Type.ARMOR, Rarity.LEGEND, false, 99999);
         case 84: return new Item("Efreeti chain", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 85: return new Item("Horn of Valhalla (iron)", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 86: return new Item("Ollamh harp", Type.ARMOR, Rarity.LEGEND, false, 99999);
         case 87: return new Item("Ioun stone (absorb, greater)", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 88: return new Item("Ioun stone (mastery)", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 89: return new Item("Ioun stone (regeneration)", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 90: return new Item("Armor of etherealness", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 91: return new Item("Ring of air elementals", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 92: return new Item("Ring of earth elementals)", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 93: return new Item("Ring of fire elementals", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 94: return new Item("Ring of water elementals", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 95: return new Item("Ring of three wishes", Type.ARMOR, Rarity.LEGEND, false, 99999);
         case 96: return new Item("Sphere of annihilation", Type.ARMOR, Rarity.LEGEND, false, 99999);
         case 97: return new Item("Talisman of the sphere", Type.ARMOR, Rarity.LEGEND, false, 99999);
         case 98: return new Item("Talisman of pure good)", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 99: return new Item("Talisman of ultimate evil", Type.ARMOR, Rarity.LEGEND, true, 99999);
         case 100: return new Item("Tome of the stilled tongue)", Type.ARMOR, Rarity.LEGEND, true, 99999);
         default: return new Item("Defender (+3)", Type.WEAPON, Rarity.LEGEND, true, 99999);
      }
   }
   
   public static String hoardToString(ArrayList<Item> items) {
      String hoard = String.format("%nTreasure: %n(coins, gems, jewels are per-Character)");
      for (Item el : items) {
         hoard += String.format("%n%s", el.toString());
      }
      
      return hoard;
   }
   
   @Override
   public String toString() {
      if (type == Type.COINS)
         return String.format("%s (%s)", name, value);
      else if (type == Type.ART || type == Type.GEMS)
         return String.format("%s (%s GP)", name, value);
      else if (type != Type.POTION && type != Type.SCROLL)
         return String.format("%s (%s)", name, attuned);
      else
         return String.format("%s", name);
   }
   
   // END OF CODE
}