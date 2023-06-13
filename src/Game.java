import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String guideBookExit ;
    String playerName;
    int playerBalance = 10000;
    int playerHealth = 100;
    int playerWeaponDamage =20;
    int playerArmorHealth = 50;
    int playerArmorRepairPrice =150;
    int playerCrit = 2;
    int playerCritChance = 3;
    int playerArmorLvl =1;
    int playerWeaponLvl =1;
    int bossLvl =1 ;
    int bossLvlUpgrade =1;
    int bossCrit ;
    int sideQuestBossHealth = 100;
    int sideQuestBossDamage = 20;
    int sideQuestCrit = 2;
    int sideQuestPrize = 50;
    int bossPrize ;
    String bossName ;
    int bossEntryPrice ;
    int bossDamage ;
    int bossHealth;
    int playerArmorCondition = 20;
    int sideQuestBossCritChance = 2;
    int BossCritChance;
    int playerArmorUpgradePrice2 = 50 , playerArmorUpgradePrice3 = 150,playerArmorUpgradePrice4 =400,playerArmorUpgradePrice5 =2500;
    int playerArmorHealtLvl2 = 80, playerArmorHealtLvl3 = 120,playerArmorHealtLvl4 = 160 , playerArmorHealtLvl5 = 200;
    int playerWeaponUpgradePrice2 = 50, playerWeaponUpgradePrice3 = 150,playerWeaponUpgradePrice4 = 400,playerWeaponUpgradePrice5 = 2500;
    int playerWeaponDamageLvl2 = 30 ,playerWeaponDamageLvl3 = 60,playerWeaponDamageLvl4 = 100,playerWeaponDamageLvl5 = 200;
    public void SideQuest() throws InterruptedException {

        if (playerArmorLvl == 1){
            playerArmorHealth= playerHealth;
        } else if (playerArmorLvl==2) {
            playerArmorHealth = playerArmorHealtLvl2;
        }else if (playerArmorLvl==3) {
            playerArmorHealth = playerArmorHealtLvl3;
        }else if (playerArmorLvl==4) {
            playerArmorHealth = playerArmorHealtLvl4;
        }else if (playerArmorLvl==5) {
            playerArmorHealth = playerArmorHealtLvl5;
        }


        System.out.println("Side Quesr Has Began\n");
        System.out.println("Here comes CakeKing " + sideQuestBossHealth + " HP !");
        Thread.sleep(2000);
        while (sideQuestBossHealth>=0 || playerHealth>=0){
            System.out.println("CakeKing Attacking!!");
            Thread.sleep(1000);
            int critChanceB = random.nextInt(10);
            if (critChanceB<=sideQuestBossCritChance){
                System.out.println("Cakeking Strike a Crit  !!!!!!! " + (sideQuestCrit*sideQuestBossDamage)+ "DMG");
                Thread.sleep(2000);
                if (playerArmorHealth<=0 || playerArmorCondition<=0){
                    playerHealth -= sideQuestCrit*sideQuestBossDamage;
                } else{
                    playerArmorCondition -= 1;
                    playerArmorHealth -= sideQuestCrit*sideQuestBossDamage;
                }
                System.out.println(playerName +""+ playerHealth + ""+playerName +"" + playerArmorHealth + " Armor Condition " + playerArmorCondition);
                Thread.sleep(2000);
            }
            if (critChanceB>sideQuestBossCritChance){
                System.out.println("Cakeking made a strike ! " + sideQuestBossDamage + " DMG");
                Thread.sleep(2000);
                if (playerArmorHealth<=0 || playerArmorCondition<=0){
                    playerHealth -= sideQuestBossDamage;
                }else {
                    playerArmorCondition -= 1;
                    playerArmorHealth -= sideQuestBossDamage;
                }
                System.out.println(playerName +""+ playerHealth + ""+playerName +"" + playerArmorHealth + " Armor Condition " + playerArmorCondition);
                Thread.sleep(2000);
            }
            System.out.println( playerName+ " Moves for an attack");
            Thread.sleep(2000);
             int critChancePlayer = random.nextInt(10);
            if (critChancePlayer<=playerCritChance){
                System.out.println(playerName+" Made a crit strike !!! " + (playerCrit*playerWeaponDamage) +" DMG");
                Thread.sleep(2000);
                sideQuestBossHealth -= playerCrit*playerWeaponDamage;
                System.out.println("Boss HP " + sideQuestBossHealth);
                Thread.sleep(2000);
            }
            if (critChancePlayer>= playerCritChance){
                sideQuestBossHealth -= playerWeaponDamage;
                System.out.println(playerName+" made a strike " + playerWeaponDamage + "DMG");
                Thread.sleep(2000);
                System.out.println("Boss HP " + sideQuestBossHealth);
                Thread.sleep(2000);
            }

            if (playerHealth<=0){
                Thread.sleep(2000);
                System.out.println(" CakeKing made his last strike and you have lost ! ");
                break;
            } else if (sideQuestBossHealth<=0) {
                System.out.println("CakeKing falls !!!! Your Reward ---> " + sideQuestPrize);
                Thread.sleep(2000);
                playerBalance += sideQuestPrize;
                System.out.println("New Balance: "+ playerBalance);
                Thread.sleep(2000);
                break;
            }


        }


    }





    public void Upgrade() throws InterruptedException {
        System.out.println("Hello There welcome to the TEK market");
        Thread.sleep(2000);
        System.out.println("for Armor upgrade 'armor' Weapon upgrade 'weapon' Armor Repair 'repair' for exit için 'Çıkış' (Type your choice)");
        String upgradeDecision = scanner.nextLine();
        while (!upgradeDecision.equalsIgnoreCase("çıkış")){
            if (upgradeDecision.equalsIgnoreCase("armor")){
                Thread.sleep(2000);
                String armorPrices = "Here is Armor prices  \n"
                        + "Lvl2 Fire armor -----> 50 Gold ve Armor HP 80 \n"
                        + "Lvl3 Dragon Breath armor -----> 150 gold ve Armor HP 120 \n "
                        + "Lvl4 TEK armor ----> 400 gold ve Armor HP 160 \n"
                        + "Lvl5 Kaiser İmpact armor ------> 2500 gold vs Armor HP 200 \n";
                System.out.println(armorPrices);
                Thread.sleep(1000);
                System.out.println("Current Armor HP " + playerArmorHealth + " Armor Lvl " + playerArmorLvl + " Wanna Upgrade ? (Y/N)");
                String armorUpgradeDecision = scanner.next();
                if (armorUpgradeDecision.equalsIgnoreCase("y")){
                    if (playerArmorLvl == 1 && playerBalance>=playerArmorUpgradePrice2 ){
                        playerBalance -= playerArmorUpgradePrice2;
                        playerArmorLvl += 1;
                        playerArmorHealth = playerArmorHealtLvl2;
                        Thread.sleep(2000);
                        System.out.println("Armor successfully upgraded Lvl2 Has armor 80 HP ");
                        Thread.sleep(2000);
                        System.out.println("New Balance = " + playerBalance + " Gold");
                    } else if (playerArmorLvl == 2 && playerBalance>=playerArmorUpgradePrice3) {
                        playerBalance -= playerArmorUpgradePrice3;
                        playerArmorLvl += 1;
                        playerArmorHealth = playerArmorHealtLvl3;
                        Thread.sleep(2000);
                        System.out.println("Armor successfully upgraded Lvl3 Has armor 120 HP");
                        Thread.sleep(2000);
                        System.out.println("New Balance = " + playerBalance + " Gold");
                    } else if (playerArmorLvl == 3 && playerBalance>=playerArmorUpgradePrice4) {
                        playerBalance -= playerArmorUpgradePrice4;
                        playerArmorLvl += 1;
                        playerArmorHealth = playerArmorHealtLvl4;
                        Thread.sleep(2000);
                        System.out.println("Armor successfully upgraded Lvl4 Has armor 160 HP");
                        Thread.sleep(2000);
                        System.out.println("New Balance = " + playerBalance + " Gold");
                    } else if (playerArmorLvl == 4 && playerBalance >= playerArmorUpgradePrice5) {
                        playerBalance -= playerArmorUpgradePrice5;
                        playerArmorLvl += 1;
                        playerArmorHealth = playerArmorHealtLvl5;
                        Thread.sleep(2000);
                        System.out.println("Armor successfully upgraded Lvl5 Has armor 200 HP");
                        Thread.sleep(2000);
                        System.out.println("New Balance = " + playerBalance + " Gold");
                    }else {
                        Thread.sleep(2000);
                        System.out.println("Not enough balance for that ");
                    }
                }

            }
            if (upgradeDecision.equalsIgnoreCase("weapon")){
                Thread.sleep(2000);
                String weaponPrices = "Here is Armor prices\n"
                        + "Lvl2 Fire weapon -----> 50 Gold ve Weapon DMG 30\n "
                        + "Lvl3 Dragon Breath weapon -----> 150 gold ve Weapon DMG 60\n"
                        + "Lvl4 TEK weapon ----> 400 gold ve Weapon DMG 120\n "
                        + "Lvl5 Kaiser weapon armor ------> 2500 gold vs Weapon DMG 200\n";
                System.out.println(weaponPrices);
                Thread.sleep(2000);
                System.out.println("Current weapon lvl " + playerWeaponLvl + " current weapon dmg " + playerWeaponDamage + "Wanna Upgrade ? (Y/N)");
                String weaponUpgradeDecision = scanner.next();
                if (weaponUpgradeDecision.equalsIgnoreCase("y")){
                    if (playerWeaponLvl == 1 && playerBalance >= playerWeaponUpgradePrice2){
                        playerWeaponLvl += 1;
                        playerBalance -= playerWeaponUpgradePrice2;
                        playerWeaponDamage = playerWeaponDamageLvl2;
                        Thread.sleep(2000);
                        System.out.println("weapon successfully upgraded lvl " + playerWeaponLvl + " new weapon damage " + playerWeaponDamage);
                        Thread.sleep(2000);
                        System.out.println("New Balance = " + playerBalance + " Gold");
                    } else if (playerWeaponLvl == 2 && playerBalance >= playerWeaponUpgradePrice3) {
                        playerWeaponLvl += 1;
                        playerBalance -= playerWeaponUpgradePrice3;
                        playerWeaponDamage = playerWeaponDamageLvl3;
                        Thread.sleep(2000);
                        System.out.println("weapon successfully upgraded lvl " + playerWeaponLvl + " new Weapon damage " + playerWeaponDamage);
                        Thread.sleep(2000);
                        System.out.println("New Balance = " + playerBalance + " Gold");
                    } else if (playerWeaponLvl == 3 && playerBalance>= playerWeaponUpgradePrice4) {
                        playerWeaponLvl += 1;
                        playerBalance -= playerWeaponUpgradePrice4;
                        playerWeaponDamage = playerWeaponDamageLvl4;
                        System.out.println("weapon successfully upgraded lvl " + playerWeaponLvl + " new Weapon damage " + playerWeaponDamage);
                        Thread.sleep(2000);
                        System.out.println("New Balance = " + playerBalance + " Gold");
                        Thread.sleep(2000);

                    } else if (playerWeaponLvl == 4 && playerBalance>= playerWeaponUpgradePrice5) {
                        playerWeaponLvl += 1;
                        playerBalance -= playerWeaponUpgradePrice5;
                        playerWeaponDamage = playerWeaponDamageLvl5;
                        System.out.println("weapon successfully upgraded lvl " + playerWeaponLvl + " new Weapon damage " + playerWeaponDamage);
                        Thread.sleep(2000);
                        System.out.println("New Balance = " + playerBalance + " Gold");
                        Thread.sleep(2000);
                    }else {
                        Thread.sleep(2000);
                        System.out.println("Not enough balance for that");
                    }
                }

            }
            if (upgradeDecision.equalsIgnoreCase("repair")){
                System.out.println("Repairing...");
                Thread.sleep(2000);
                if (playerBalance>= playerArmorRepairPrice){
                    playerArmorCondition = 20;
                    playerBalance -= playerArmorRepairPrice;
                    System.out.println("Completed!");
                    System.out.println("New Balance = " + playerBalance + " Gold");
                } else if (playerBalance<= playerArmorRepairPrice) {
                    System.out.println("Not enough balance for that");
                }
            }
            Thread.sleep(1000);
            System.out.println("for Armor upgrade 'armor' Weapon upgrade 'weapon' Armor Repair 'repair' for exit için 'Çıkış' (Type your choice)");
            upgradeDecision = scanner.nextLine();

        }
    }

    public void BossFight(int bossCrit,int bossHealth,int bossPrize,int bossEntryPrice,int bossCritChance,int bossDamage,String bossName) throws InterruptedException {

        if (playerArmorLvl == 1){
            playerArmorHealth= playerHealth;
        } else if (playerArmorLvl==2) {
            playerArmorHealth = playerArmorHealtLvl2;
        }else if (playerArmorLvl==3) {
            playerArmorHealth = playerArmorHealtLvl3;
        }else if (playerArmorLvl==4) {
            playerArmorHealth = playerArmorHealtLvl4;
        }else if (playerArmorLvl==5) {
            playerArmorHealth = playerArmorHealtLvl5;
        }

if (playerBalance>=bossEntryPrice) {
    playerBalance-=bossEntryPrice;
    while (bossHealth >= 0 || playerHealth >= 0) {
        System.out.println(bossName +" making his move for a strike");
        Thread.sleep(1000);
        int critChanceB = random.nextInt(10);
        if (critChanceB <= bossCritChance) {
            System.out.println(bossName +" strikes a crit hit !!!!!!! " + (bossCrit * bossDamage) + "DMG");
            Thread.sleep(2000);
            if (playerArmorHealth <= 0 || playerArmorCondition <= 0) {
                playerHealth -= bossCrit * bossDamage;
            } else {
                playerArmorCondition -= 2;
                playerArmorHealth -= bossCrit * bossDamage;
            }
            System.out.println(playerName+" HP: " + playerHealth +" HP: "+ playerName+"  Armor: " + playerArmorHealth + " HP Armor Condition" + playerArmorCondition);
            Thread.sleep(2000);
        }
        if (critChanceB > bossCritChance) {
            System.out.println(bossName+" Strikes ! " + bossDamage + " DMG");
            Thread.sleep(2000);
            if (playerArmorHealth <= 0 || playerArmorCondition <= 0) {
                playerHealth -= bossDamage;
            } else {
                playerArmorCondition -= 2;
                playerArmorHealth -= bossDamage;
            }
            System.out.println(playerName+" HP " + playerHealth + " HP "+playerName+" Armor " + playerArmorHealth + " HP Armor Condition" + playerArmorCondition);
            Thread.sleep(2000);
        }
        System.out.println(playerName+" making his move for a strike");
        Thread.sleep(2000);
        int critChancePlayer = random.nextInt(10);
        if (critChancePlayer <= playerCritChance) {
            System.out.println(playerName+" lands a critical strike !!! " + (playerCrit * playerWeaponDamage) + " DMG");
            Thread.sleep(2000);
            bossHealth -= playerCrit * playerWeaponDamage;
            System.out.println(bossName+" HP " + bossHealth);
            Thread.sleep(2000);
        }
        if (critChancePlayer >= playerCritChance) {
            bossHealth -= playerWeaponDamage;
            System.out.println(playerName+" Strikes " + playerWeaponDamage + "DMG");
            Thread.sleep(2000);
            System.out.println(bossName+" HP " + bossHealth);
            Thread.sleep(2000);
        }

        if (playerHealth <= 0) {
            Thread.sleep(2000);
            System.out.println(bossName+" Laughed and hit his final hit YOU HAVE LOST ! ");
            break;
        } else if (bossHealth <= 0) {
            System.out.println(bossName+" FALLS !!!! Your Reward ---> " + sideQuestPrize);
            Thread.sleep(2000);
            bossLvl += bossLvlUpgrade ;
            System.out.println(bossLvl);
            playerBalance += bossPrize;
            System.out.println("New Balance " + playerBalance);
            Thread.sleep(2000);
            break;
        }


    }
}else{
    System.out.println("You cant afford entry price for boss ---> "+bossEntryPrice+" Gold");
}

    }

    public void GuideBook(){
        do {

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            String guideBook = ">------------------------------------------------------------<\n"+
                    "Hi! " + playerName + " We have all the information you need ! \n" +
                    "Sidequest made for some extra cash feel free to play as long as you want (50 Gold) reward \n" +
                    "There are 5 different bosses and each of these bosses have their unique abilities if you somehow manage to beat all of them game will be over!\n" +
                    "Use market for Armor,Weapon upgrade and armor repair\n" +
                    "Boss entry Prices\n " +
                    ">------------------------------------------------------------<\n"+
                    "Fofana ---> 100 Gold\n" +
                    "Dante ---> 300 Gold\n" +
                    "Vasto Lord ---> 600 Gold\n" +
                    "Espada ---> 1200 Gold\n" +
                    "Kaiser ---> 2200 Gold\n" +
                    ">------------------------------------------------------------<\n"+
                    "In game commands \n" +
                    "For boss Write down 'Boss' \n" +
                    "For market Write down 'Market'\n" +
                    "For sidequest Write down 'SideQuest' \n" +
                    "For Guidebook Write down 'Rehber'\n" +
                    "For Exit Write down 'Çıkış' \n" +
                    ">------------------------------------------------------------<\n"+
                    "Everything settled now please write down (Kapat) and game will start ---->";
            System.out.print(guideBook);
            guideBookExit = scanner.next();
        }while (!guideBookExit.equalsIgnoreCase("kapat"));




    }
    public void DeBugger(){
        int bug = bossLvl+bossHealth+bossLvlUpgrade+bossCrit+bossPrize+bossDamage+bossEntryPrice+BossCritChance;
        String buggy = bossName;
    }



}

