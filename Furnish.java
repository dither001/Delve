/********************************************************
* Author: Nick Foster
*
* Last edited: 9/10/2017
********************************************************/

public class Furnish {
   // fields
   private enum Theme {GENERAL, DEATH_TRAP, LAIR, MAZE, MINE,
                        PLANAR_GATE, STRONGHOLD, TEMPLE, TOMB, VAULT}
   private static int dungeonTheme = Dice.deeRoll(1,9);
   
   // constructors
   
   // methods
   public static String getTheme() {
      return getTheme(dungeonTheme);
   }
   
   public static String getTheme(int theme) {
      switch (theme) {
         case 1: return "Death Trap";
         case 2: return "Lair";
         case 3: return "Maze";
         case 4: return "Mine";
         case 5: return "Planar Gate";
         case 6: return "Stronghold";
         case 7: return "Temple";
         case 8: return "Tomb";
         case 9: return "Vault";
         default: return "General";
      }
   }
   
   public static String setTheme() {
      return setTheme(Dice.deeRoll(1,9));
   }
   
   public static String setTheme(int choice) {
      if (choice >= 1 && choice <= 10) dungeonTheme = choice;
      else dungeonTheme = Dice.deeRoll(1,9);
      
      return getTheme(dungeonTheme);
   }
   
   public static String furnishChamber() {
      switch (dungeonTheme) {
         case 1: return String.format("Appears to be: %s %n%s", furnishDeathTrap(), chamberState());
         case 2: return String.format("Appears to be: %s %n%s", furnishLair(), chamberState());
         case 3: return String.format("Appears to be: %s %n%s", furnishMaze(), chamberState());
         case 4: return String.format("Appears to be: %s %n%s", furnishMine(), chamberState());
         case 5: return String.format("Appears to be: %s %n%s", furnishPlanarGate(), chamberState());
         case 6: return String.format("Appears to be: %s %n%s", furnishStronghold(), chamberState());
         case 7: return String.format("Appears to be: %s %n%s", furnishTemple(), chamberState());
         case 8: return String.format("Appears to be: %s %n%s", furnishTomb(), chamberState());
         case 9: return String.format("Appears to be: %s %n%s", furnishVault(), chamberState());
         default: return String.format("Appears to be: %s %n%s", furnishGeneral(), chamberState());
      }
   }
   
   public static String chamberState() {
      switch (Dice.deeRoll(1,20)) {
         case 1: 
         case 2: 
         case 3: return "RUBBLE: ceiling partially collapsed";
         case 4: 
         case 5: return "HOLES: floor partially collapsed";
         case 6: 
         case 7: return "ASHES: contents mostly burned";
         case 8: 
         case 9: return "DEBRIS: used as a campsite";
         case 10: 
         case 11: return "POOL: room contents water-damaged";
         case 17: 
         case 18: return String.format("Converted to new use %nNow appears to be: %s", furnishGeneral());
         case 19: return "EMPTY: stripped of useful contents";
         case 20: return "PRISTINE: still in original state";
         default: return "DAMAGE: furniture present but ruined";
      }
   }
   
   public static String furnishGeneral() {
      switch (Dice.deeRoll(1,100)) {
         case 1: return "Antechamber";
         case 2: 
         case 3: return "Armory";
         case 4: return "Audience chamber";
         case 5: return "Aviary";
         case 6: 
         case 7: return "Banquet room";
         case 11: return "Bath or latrine";
         case 12: return "Bedroom";
         case 13: return "Bestiary";
         case 14: 
         case 15: 
         case 16: return "Cell";
         case 17: return "Chantry";
         case 18: return "Chapel";
         case 19: 
         case 20: return "Cistern";
         case 21: return "Classroom";
         case 22: return "Closet";
         case 23: 
         case 24: return "Conjuring room";
         case 25: 
         case 26: return "Court";
         case 27: 
         case 28: 
         case 29: return "Crypt";
         case 30: 
         case 31: return "Dining room";
         case 32: 
         case 33: return "Divination room";
         case 34: return "Dormitory";
         case 35: return "Dressing room";
         case 36: return "Entry room or vestibule";
         case 37: 
         case 38: return "Gallery";
         case 39: 
         case 40: return "Game room";
         case 41: 
         case 42: 
         case 43: return "Guardroom";
         case 44: 
         case 45: return "Hall";
         case 46: 
         case 47: return "Great hall";
         case 48: 
         case 49: return "Hallway";
         case 50: return "Kennel";
         case 51: 
         case 52: return "Kitchen";
         case 53: 
         case 54: return "Laboratory";
         case 55: 
         case 56: 
         case 57: return "Library";
         case 58: 
         case 59: return "Lounge";
         case 60: return "Meditation chamber";
         case 61: return "Observatory";
         case 62: return "Office";
         case 63: 
         case 64: return "Pantry";
         case 65: 
         case 66: return "Pen or prison";
         case 67: 
         case 68: return "Reception room";
         case 69: 
         case 70: return "Refectory";
         case 71: return "Robing room";
         case 72: return "Salon";
         case 73: 
         case 74: return "Shrine";
         case 75: 
         case 76: return "Sitting room";
         case 77: 
         case 78: return "Smithy";
         case 79: return "Stable";
         case 80: 
         case 81: return "Storage room";
         case 82: 
         case 83: return "Strong room or vault";
         case 84: 
         case 85: return "Study";
         case 86: 
         case 87: 
         case 88: return "Temple";
         case 89: 
         case 90: return "Throne room";
         case 91: return "Torture chamber";
         case 92: 
         case 93: return "Training or exercise room";
         case 94: 
         case 95: return "Trophy room or museum";
         case 96: return "Waiting room";
         case 97: return "Nursery or schoolroom";
         case 98: return "Well";
         case 99: 
         case 100: return "Workshop";
         default: return "Barracks";
      }
   }
   
   public static String furnishDeathTrap() {
      switch (Dice.deeRoll(1,20)) {
         case 1: return "Antechamber or waiting room for spectators";
         case 9: 
         case 10: 
         case 11: return "Contains vault behind locked/secret door (75%% trapped)";
         case 12: 
         case 13: 
         case 14: return "Puzzle that must be solved to bypass trap or monster";
         case 15: 
         case 16: 
         case 17: 
         case 18: 
         case 19: return "Contains trap designed to kill or capture creatures";
         case 20: return "Observation room for guards or spectators";
         default: return "Guardroom fortified against intruders";
      }
   }
   
   public static String furnishLair() {
      switch (Dice.deeRoll(1,20)) {
         case 2: return "Audience chamber, used to receive guests";
         case 3: return "Banquet room for important celebrations";
         case 4: return "Barracks where defenders are quartered";
         case 5: return "Bedroom for use by leaders";
         case 6: return "Chapel where inhabitants worship";
         case 7: return "Cistern or well for drinking water";
         case 8: 
         case 9: return "Guardroom for defense of lair";
         case 10: return "Kennel for pets or guard beasts";
         case 11: return "Kitchen for food storage and preparation";
         case 12: return "Pen or prison where captives are held";
         case 13: 
         case 14: return "Storage, mostly nonperishable goods";
         case 15: return "Throne room where the leaders hold court";
         case 16: return "Torture chamber for interrogating captives";
         case 17: return "Training and exercise room";
         case 18: return "Library, study, trophy room, or museum";
         case 19: return "Latrine or bath";
         case 20: return "Workshop for weapons, armor, tools, or other";
         default: return "Armory stocked with weapons and armor";
      }
   }
   
   public static String furnishMaze() {
      switch (Dice.deeRoll(1,20)) {
         case 1: return "Conjuring room, used to summon guardian creatures";
         case 2: 
         case 3: 
         case 4: 
         case 5: return "Guardroom for sentinels that patrol the maze";
         case 11: return "Pen or prison accessible only by secret door, used to hold captives condemned to the maze";
         case 12: return "Shrine dedicated to a god or other entity";
         case 13: 
         case 14: return "Storage for food, as well as tools used by the guardians to keep the maze in working order";
         case 15: 
         case 16: 
         case 17: 
         case 18: return "Trap to confound or kill those sent into the maze";
         case 19: return "Well that provides drinking water";
         case 20: return "Workshop where doors, sconces, and other furnishings are repaired and maintained";
         default: return "Lair for guard beasts that patrol the maze";
      }
   }
   
   public static String furnishMine() {
      switch (Dice.deeRoll(1,20)) {
         case 1: 
         case 2: return "Barracks for miners";
         case 3: return "Bedroom for a supervisor or manager";
         case 4: return "Chapel dedicated to a patron deity of miners, earth, or protection";
         case 5: return "Cistern providing drinking water for miners";
         case 6: 
         case 7: return "Guardroom";
         case 8: return "Kitchen used to feed workers";
         case 9: return "Laboratory used to conduct tests on strange minerals extracted from mine";
         case 16: return "Office used by the mine supervisor";
         case 17: return "Smithy for repairing damaged tools";
         case 18: 
         case 19: return "Storage for tools and other equipment";
         case 20: return "Strong room or vault used to store ore for transport to the surface";
         default: return "Lode where metal ore is mined (75%% chance of being depleted)";
      }
   }
   
   public static String furnishPlanarGate() {
      switch (Dice.deeRoll(1,100)) {
         case 1: 
         case 2: 
         case 3: return "Decorated foyer or antechamber";
         case 4: 
         case 5: 
         case 6: 
         case 7: 
         case 8: return "Armory used by the portal's guardians";
         case 9: 
         case 10: return "Audience chamber for receiving visitors";
         case 20: 
         case 21: 
         case 22: 
         case 23: return "Bedroom for use by high-ranking guards";
         case 24: 
         case 25: 
         case 26: 
         case 27: 
         case 28: 
         case 29: 
         case 30: return "Chapel dedicated to a deity related to the portal and its defenders";
         case 31: 
         case 32: 
         case 33: 
         case 34: 
         case 35: return "Cistern providing fresh water";
         case 36: 
         case 37: 
         case 38: return "Classroom for use of initiates learning the portal's secrets";
         case 39: return "Conjuring room for summong creatures to invesstigate or defend the portal";
         case 40: 
         case 41: return "Crypt where the remains of fallen portal defenders are interred";
         case 42: 
         case 43: 
         case 44: 
         case 45: 
         case 46: 
         case 47: return "Dining room";
         case 48: 
         case 49: 
         case 50: return "Divination room used to investigate portal and events tied to it";
         case 51: 
         case 52: 
         case 53: 
         case 54: 
         case 55: return "Dormitory for visitors and guards";
         case 56: 
         case 57: return "Entry room or vestibule";
         case 58: 
         case 59: return "Gallery for displaying objects and trophies related to the portal and its guardians";
         case 60: 
         case 61: 
         case 62: 
         case 63: 
         case 64: 
         case 65: 
         case 66: 
         case 67: return "Guardroom to protect or watch over the portal";
         case 68: 
         case 69: 
         case 70: 
         case 71: 
         case 72: return "Kitchen";
         case 73: 
         case 74: 
         case 75: 
         case 76: 
         case 77: return "Laboratory for conducting experiments related to the portal and creatures that emerge from it";
         case 78: 
         case 79: 
         case 80: return "Library containing books about the portal's history";
         case 81: 
         case 82: 
         case 83: 
         case 84: 
         case 85: return "Pen or prison for holding captives or creatures that emerge from the portal";
         case 86: 
         case 87: return "Planar junction, where the gate to another plane once stood (25%% chance still active";
         case 88: 
         case 89: 
         case 90: return "Storage";
         case 91: return "Strong room or vault, for guarding treasures connected to the portal, or funds to pay guardians";
         case 92: 
         case 93: return "Study";
         case 94: return "Torture chamber, for questioning creatures that pass through the portal or attempt to use it";
         case 95: 
         case 96: 
         case 97: 
         case 98: return "Latrine or bath";
         case 99: 
         case 100: return "Workshop for constructing tools and gear needed to study the portal";
         default: return "Barracks used by the portal guardians";
      }
   }
   
   public static String furnishStronghold() {
      switch (Dice.deeRoll(1,100)) {
         case 1: 
         case 2: return "Antechamber where visitors seeking access to the stronghold wait";
         case 3: 
         case 4: 
         case 5: return "Armory holding high-quality gear, including light siege weapons such as ballistas";
         case 6: return "Audience chamber used by the master of the stronghold to receive visitors";
         case 7: return "Aviary or zoo for keeping exotic creatures";
         case 8: 
         case 9: 
         case 10: 
         case 11: return "Banquet room for hosting celebrations and guests";
         case 12: 
         case 13: 
         case 14: 
         case 15: return "Barracks used by elite guards";
         case 16: return "Bath outfitted with a marble floor and other luxurious accoutrements";
         case 17: return "Bedroom for use by the stronghold's master or important guests";
         case 18: return "Chapel dedicated to a deity associated with the stronghold's master";
         case 19: 
         case 20: 
         case 21: return "Cistern providing drinking water";
         case 22: 
         case 23: 
         case 24: 
         case 25: return "Dining room featuring a number of wardrobes";
         case 26: return "Dressing room featuring a number of wardrobes";
         case 27: 
         case 28: 
         case 29: return "Gallery for the display of expensive works of art and trophies";
         case 30: 
         case 31: 
         case 32: return "Game room used to entertain visitors";
         case 51: return "Kennel where monsters or trained animals that protect the stronghold are kept";
         case 52: 
         case 53: 
         case 54: 
         case 55: 
         case 56: 
         case 57: return "Kitchen designed to prepared exotic foods for large numbers of guests";
         case 58: 
         case 59: 
         case 60: 
         case 61: return "Library with an extensive collection of rare books";
         case 62: return "Lounge used to entertain guests";
         case 63: 
         case 64: 
         case 65: 
         case 66: 
         case 67: 
         case 68: 
         case 69: 
         case 70: return "Pantry, including cellar for wine or spirits";
         case 71: 
         case 72: 
         case 73: 
         case 74: return "Sitting room for family and intimate guests";
         case 75: 
         case 76: 
         case 77: 
         case 78: return "Stable";
         case 79: 
         case 80: 
         case 81: 
         case 82: 
         case 83: 
         case 84: 
         case 85: 
         case 86: return "Storage for mundane goods and supplies";
         case 87: return "Strong room or vault for protecting treasure (75%% behind secret door)";
         case 88: 
         case 89: 
         case 90: 
         case 91: 
         case 92: return "Study, including a writing desk";
         case 93: return "Throne room, elaborately decorated";
         case 94: 
         case 95: 
         case 96: return "Waiting room where lesser guests are held before receiving an audience";
         case 97: 
         case 98: return "Latrine or bath";
         case 99: 
         case 100: return "Crypt belonging to the stronghold's master or someone else of importance";
         default: return "Guardroom";
      }
   }
   
   public static String furnishTemple() {
      switch (Dice.deeRoll(1,100)) {
         case 1: 
         case 2: 
         case 3: return "Armory filled with weapons and armor, battle banners, and pennants";
         case 4: 
         case 5: return "Audience chamber where priests of the temple receive commoners and low-status visitors";
         case 6: 
         case 7: return "Banquet room used for celebrations and holy days";
         case 8: 
         case 9: 
         case 10: return "Barracks for the temple's military arm or its hired guards";
         case 11: 
         case 12: 
         case 13: 
         case 14: return "Cells where the faithful can sit in quiet contemplation";
         case 25: 
         case 26: 
         case 27: 
         case 28: return "Chapel dedicated to a lesser deity associated with the temple's major deity";
         case 29: 
         case 30: 
         case 31: return "Classroom used to train initiates and priests";
         case 32: 
         case 33: 
         case 34: return "Conjuring room, specially sanctified and used to summon extraplanar creatures";
         case 35: 
         case 36: 
         case 37: 
         case 38: 
         case 39: 
         case 40: return "Crypt for high priest or similar figure, hidden and heavily guarded by creatures and traps";
         case 41: 
         case 42: return "Dining room (large) for the temple's servants and lesser priests";
         case 43: return "Dining room (small) for the temple's high priests";
         case 44: 
         case 45: 
         case 46: return "Divination room, inscribed with runes and stocked with soothsaying implements";
         case 47: 
         case 48: 
         case 49: 
         case 50: return "Dormitory for lesser priests or students";
         case 51: 
         case 52: 
         case 53: 
         case 54: 
         case 55: 
         case 56: return "Guardroom";
         case 57: return "Kennel for animals or monsters associated with the temple's deity";
         case 58: 
         case 59: 
         case 60: return "Kitchen (might bear a disturbing resemblance to a torture chamber in an evil temple)";
         case 61: 
         case 62: 
         case 63: 
         case 64: 
         case 65: return "Library, well-stocked with religious treatises";
         case 66: 
         case 67: 
         case 68: return "Prison for captured enemies (good/neutral), or designated sacrifices (evil)";
         case 69: 
         case 70: 
         case 71: 
         case 72: 
         case 73: return "Robing room containing ceremonial outfits and items";
         case 74: return "Stable for riding horses and mounts belonging to the temple, visiting messengers, caravans";
         case 75: 
         case 76: 
         case 77: 
         case 78: 
         case 79: return "Storage holding mundane supplies";
         case 80: return "Strong room or vault holding relics and ceremonial items, heavily trapped";
         case 81: 
         case 82: return "Torture chamber, used during inquisition (good/neutral), or for inflicting pain (evil)";
         case 83: 
         case 84: 
         case 85: 
         case 86: 
         case 87: 
         case 88: 
         case 89: return "Trophy room where art celebrating key figures and events from mythology is displayed";
         case 90: return "Latrine or bath";
         case 91: 
         case 92: 
         case 93: 
         case 94: return "Well for drinking water, defendable in the case of attack or siege";
         case 95: 
         case 96: 
         case 97: 
         case 98: 
         case 99: 
         case 100: return "Workshop for repairing or creating weapons, religious items, and tools";
         default: return "Central temple built to accomodate rituals";
      }
   }
      
   public static String furnishTomb() {
      switch (Dice.deeRoll(1,20)) {
         case 1: return "Antechamber for those who have come to pay their respects";
         case 2: 
         case 3: return "Chapel dedicated to deities that preside over the dead";
         case 9: return "Divination room, used to contact the dead for guidance";
         case 10: return "False crypt (trapped) to capture or kill thieves";
         case 11: return "Gallery to display the deeds of the deceased";
         case 12: return "Grand crypt for a noble, high priest, or other important individual";
         case 13: 
         case 14: return "Guardroom, with constructs or undead that don't require food or sleep";
         case 15: return "Robing room for priests to prepare for burial rituals";
         case 16: 
         case 17: return "Storage, with tools for maintaining the tomb and preparing the dead for burial";
         case 18: return "Tomb (trapped), accessible by secret door, where the wealthy and important are interred";
         case 19: 
         case 20: return "Workshop for embalming the dead";
         default: return "Crypt for less important burials";
      }
   }
   
   public static String furnishVault() {
      switch (Dice.deeRoll(1,20)) {
         case 1: return "Antechamber for visiting dignitaries";
         case 2: return "Armory containing mundane and magic gear used by the vault guards";
         case 3: 
         case 4: return "Barracks for the guards";
         case 5: return "Cistern providing fresh water";
         case 10: return "Kennel for trained beasts used to guard the treasure vault";
         case 11: return "Kitchen for feeding guards";
         case 12: return "Observation room for guards to monitor approaching intruders";
         case 13: return "Prison for holding captured intruders";
         case 14: 
         case 15: return "Strong room or vault, accessible only by locked/secret door, containing hidden treasure";
         case 16: return "Torture chamber for extracting information from captured intruders";
         case 17: 
         case 18: 
         case 19: 
         case 20: return "Trick or trap designed to capture or kill creatures that enter the dungeon";
         default: return "Guardroom to defend against intruders";
      }
   }
   
   // END OF CODE
}