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


        System.out.println("Side Quest Başlıyor Kılıcınızı Çektiniz Ve Savaşa Hazırsınız\n");
        System.out.println("Cakeking Geliyorrrr Canı " + sideQuestBossHealth + " HP !");
        Thread.sleep(2000);
        while (sideQuestBossHealth>=0 || playerHealth>=0){
            System.out.println("CakeKing Saldırısını yapıyor");
            Thread.sleep(1000);
            int critChanceB = random.nextInt(10);
            if (critChanceB<=sideQuestBossCritChance){
                System.out.println("Cakeking Crit Hasar vurdu !!!!!!! " + (sideQuestCrit*sideQuestBossDamage)+ "DMG");
                Thread.sleep(2000);
                if (playerArmorHealth<=0 || playerArmorCondition<=0){
                    playerHealth -= sideQuestCrit*sideQuestBossDamage;
                } else{
                    playerArmorCondition -= 1;
                    playerArmorHealth -= sideQuestCrit*sideQuestBossDamage;
                }
                System.out.println(playerName +""+ playerHealth + ""+playerName +"" + playerArmorHealth + " Armor Durumu" + playerArmorCondition);
                Thread.sleep(2000);
            }
            if (critChanceB>sideQuestBossCritChance){
                System.out.println("Cakeking Hasar vurdu ! " + sideQuestBossDamage + " DMG");
                Thread.sleep(2000);
                if (playerArmorHealth<=0 || playerArmorCondition<=0){
                    playerHealth -= sideQuestBossDamage;
                }else {
                    playerArmorCondition -= 1;
                    playerArmorHealth -= sideQuestBossDamage;
                }
                System.out.println(playerName +""+ playerHealth + ""+playerName +"" + playerArmorHealth + " Armor Durumu" + playerArmorCondition);
                Thread.sleep(2000);
            }
            System.out.println( playerName+ " Saldıraya Geçiyor");
            Thread.sleep(2000);
             int critChancePlayer = random.nextInt(10);
            if (critChancePlayer<=playerCritChance){
                System.out.println(playerName+" Crit Hasar Vurdu !!! " + (playerCrit*playerWeaponDamage) +" DMG");
                Thread.sleep(2000);
                sideQuestBossHealth -= playerCrit*playerWeaponDamage;
                System.out.println("Boss'un canı " + sideQuestBossHealth);
                Thread.sleep(2000);
            }
            if (critChancePlayer>= playerCritChance){
                sideQuestBossHealth -= playerWeaponDamage;
                System.out.println(playerName+" Hasar Vurdu " + playerWeaponDamage + "DMG");
                Thread.sleep(2000);
                System.out.println("Boss'un canı " + sideQuestBossHealth);
                Thread.sleep(2000);
            }

            if (playerHealth<=0){
                Thread.sleep(2000);
                System.out.println(" CakeKing son darbeyi vurdu Oyuncu SideBoss a karşı kaybetti ");
                break;
            } else if (sideQuestBossHealth<=0) {
                System.out.println("CakeKing yere düşüyor oyuncu kazandı !!!! ödülünüz ---> " + sideQuestPrize);
                Thread.sleep(2000);
                playerBalance += sideQuestPrize;
                System.out.println("Yeni bakiye "+ playerBalance);
                Thread.sleep(2000);
                break;
            }


        }


    }





    public void Upgrade() throws InterruptedException {
        System.out.println("İyi günler savaşçı Weapon ve Armor Upgrade etmek için en iyi yerdesin");
        Thread.sleep(2000);
        System.out.println("Armor upgrade için 'armor' Weapon upgrade için 'weapon' Armor Repair için 'repair' Çıkış için 'Çıkış' yazınız");
        String upgradeDecision = scanner.nextLine();
        while (!upgradeDecision.equalsIgnoreCase("çıkış")){
            if (upgradeDecision.equalsIgnoreCase("armor")){
                Thread.sleep(2000);
                String armorPrices = "Mağazamızda Armor Upgrade Fiyatları Aşağıda Gösterildiği Gibidir! \n"
                        + "Lvl2 Ateşten geçen armor -----> 50 Gold ve Armor Canı 80 \n"
                        + "Lvl3 Rüzgarın nefesi armor -----> 150 gold ve Armor Canı 120 \n "
                        + "Lvl4 TEK armor ----> 400 gold ve Armor Canı 160 \n"
                        + "Lvl5 Kaiser İmpact armor ------> 2500 gold vs Armor canı 200 \n";
                System.out.println(armorPrices);
                Thread.sleep(1000);
                System.out.println("Anlık Armorunuz " + playerArmorHealth + " Armor Lvlınız " + playerArmorLvl + " Yükseltmek ister misiniz ? (Y/N)");
                String armorUpgradeDecision = scanner.next();
                if (armorUpgradeDecision.equalsIgnoreCase("y")){
                    if (playerArmorLvl == 1 && playerBalance>=playerArmorUpgradePrice2 ){
                        playerBalance -= playerArmorUpgradePrice2;
                        playerArmorLvl += 1;
                        playerArmorHealth = playerArmorHealtLvl2;
                        Thread.sleep(2000);
                        System.out.println("Armorunuz başarı ile yükseltilmiştir yeni Lvl2 armorunuzun 80 canı vardır");
                        Thread.sleep(2000);
                        System.out.println("Yeni Balance = " + playerBalance + " Gold");
                    } else if (playerArmorLvl == 2 && playerBalance>=playerArmorUpgradePrice3) {
                        playerBalance -= playerArmorUpgradePrice3;
                        playerArmorLvl += 1;
                        playerArmorHealth = playerArmorHealtLvl3;
                        Thread.sleep(2000);
                        System.out.println("Armorunuz başarı ile yükseltilmiştir yeni Lvl3 armorunuzun 120 canı vardır");
                        Thread.sleep(2000);
                        System.out.println("Yeni Balance = " + playerBalance + " Gold");
                    } else if (playerArmorLvl == 3 && playerBalance>=playerArmorUpgradePrice4) {
                        playerBalance -= playerArmorUpgradePrice4;
                        playerArmorLvl += 1;
                        playerArmorHealth = playerArmorHealtLvl4;
                        Thread.sleep(2000);
                        System.out.println("Armorunuz başarı ile yükseltilmiştir yeni Lvl4 armorunuzun 160 canı vardır");
                        Thread.sleep(2000);
                        System.out.println("Yeni Balance = " + playerBalance + " Gold");
                    } else if (playerArmorLvl == 4 && playerBalance >= playerArmorUpgradePrice5) {
                        playerBalance -= playerArmorUpgradePrice5;
                        playerArmorLvl += 1;
                        playerArmorHealth = playerArmorHealtLvl5;
                        Thread.sleep(2000);
                        System.out.println("Armorunuz başarı ile yükseltilmiştir yeni Lvl4 armorunuzun 160 canı vardır");
                        Thread.sleep(2000);
                        System.out.println("Yeni Balance = " + playerBalance + " Gold");
                    }else {
                        Thread.sleep(2000);
                        System.out.println("Üzgünüz Görünüşe Göre Bakiyeniz yetersiz");
                    }
                }

            }
            if (upgradeDecision.equalsIgnoreCase("weapon")){
                Thread.sleep(2000);
                String weaponPrices = "Mağazamızda Weapon Upgrade Fiyatları Aşağıda Gösterildiği Gibidir!\n"
                        + "Lvl2 Ateşten geçen weapon -----> 50 Gold ve Weapon Hasarı 30\n "
                        + "Lvl3 Rüzgarın nefesi weapon -----> 150 gold ve Weapon Hasarı 60\n"
                        + "Lvl4 TEK weapon ----> 400 gold ve Weapon Hasarı\n "
                        + "Lvl5 Kaiser weapon armor ------> 2500 gold vs Weapon Hasarı\n";
                System.out.println(weaponPrices);
                Thread.sleep(2000);
                System.out.println("Anlık Weapon Lvlınız" + playerWeaponLvl + " Anlık Weapon Hasarınız " + playerWeaponDamage + "Yükseltmek ister misiniz ? (Y/N)");
                String weaponUpgradeDecision = scanner.next();
                if (weaponUpgradeDecision.equalsIgnoreCase("y")){
                    if (playerWeaponLvl == 1 && playerBalance >= playerWeaponUpgradePrice2){
                        playerWeaponLvl += 1;
                        playerBalance -= playerWeaponUpgradePrice2;
                        playerWeaponDamage = playerWeaponDamageLvl2;
                        Thread.sleep(2000);
                        System.out.println("Weapon Başarı ile yükseltilmiştir yeni Lvl " + playerWeaponLvl + " yeni Weapon hasarı " + playerWeaponDamage);
                        Thread.sleep(2000);
                        System.out.println("Yeni Balance = " + playerBalance + " Gold");
                    } else if (playerWeaponLvl == 2 && playerBalance >= playerWeaponUpgradePrice3) {
                        playerWeaponLvl += 1;
                        playerBalance -= playerWeaponUpgradePrice3;
                        playerWeaponDamage = playerWeaponDamageLvl3;
                        Thread.sleep(2000);
                        System.out.println("Weapon Başarı ile yükseltilmiştir yeni Lvl " + playerWeaponLvl + " yeni Weapon hasarı " + playerWeaponDamage);
                        Thread.sleep(2000);
                        System.out.println("Yeni Balance = " + playerBalance + " Gold");
                    } else if (playerWeaponLvl == 3 && playerBalance>= playerWeaponUpgradePrice4) {
                        playerWeaponLvl += 1;
                        playerBalance -= playerWeaponUpgradePrice4;
                        playerWeaponDamage = playerWeaponDamageLvl4;
                        System.out.println("Weapon Başarı ile yükseltilmiştir yeni Lvl " + playerWeaponLvl + " yeni Weapon hasarı " + playerWeaponDamage);
                        Thread.sleep(2000);
                        System.out.println("Yeni Balance = " + playerBalance + " Gold");
                        Thread.sleep(2000);

                    } else if (playerWeaponLvl == 4 && playerBalance>= playerWeaponUpgradePrice5) {
                        playerWeaponLvl += 1;
                        playerBalance -= playerWeaponUpgradePrice5;
                        playerWeaponDamage = playerWeaponDamageLvl5;
                        System.out.println("Weapon Başarı ile yükseltilmiştir yeni Lvl " + playerWeaponLvl + " yeni Weapon hasarı " + playerWeaponDamage);
                        Thread.sleep(2000);
                        System.out.println("Yeni Balance = " + playerBalance + " Gold");
                        Thread.sleep(2000);
                    }else {
                        Thread.sleep(2000);
                        System.out.println("Üzgünüz Görünüşe Göre Bakiyeniz yetersiz");
                    }
                }

            }
            if (upgradeDecision.equalsIgnoreCase("repair")){
                System.out.println("Repair yapılıyor...");
                Thread.sleep(2000);
                if (playerBalance>= playerArmorRepairPrice){
                    playerArmorCondition = 20;
                    playerBalance -= playerArmorRepairPrice;
                    System.out.println("Armor başarı ile yenilendi!");
                    System.out.println("Yeni Balance = " + playerBalance + " Gold");
                } else if (playerBalance<= playerArmorRepairPrice) {
                    System.out.println("Üzgünüm işlem gerçekleştirelemedi yetersiz bakiye");
                }
            }
            Thread.sleep(1000);
            System.out.println("Armor upgrade için 'armor' Weapon upgrade için 'weapon' Armor Repair için 'repair' Çıkış için 'Çıkış' yazınız");
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
        System.out.println(bossName +" Saldırısını yapıyor");
        Thread.sleep(1000);
        int critChanceB = random.nextInt(10);
        if (critChanceB <= bossCritChance) {
            System.out.println(bossName +" Crit Hasar vurdu !!!!!!! " + (bossCrit * bossDamage) + "DMG");
            Thread.sleep(2000);
            if (playerArmorHealth <= 0 || playerArmorCondition <= 0) {
                playerHealth -= bossCrit * bossDamage;
            } else {
                playerArmorCondition -= 2;
                playerArmorHealth -= bossCrit * bossDamage;
            }
            System.out.println(playerName+" Canı " + playerHealth +" HP "+ playerName+"  Armoru " + playerArmorHealth + " HP Armor Durumu" + playerArmorCondition);
            Thread.sleep(2000);
        }
        if (critChanceB > bossCritChance) {
            System.out.println(bossName+" Hasar vurdu ! " + bossDamage + " DMG");
            Thread.sleep(2000);
            if (playerArmorHealth <= 0 || playerArmorCondition <= 0) {
                playerHealth -= bossDamage;
            } else {
                playerArmorCondition -= 2;
                playerArmorHealth -= bossDamage;
            }
            System.out.println(playerName+" Canı " + playerHealth + " HP "+playerName+" Armoru " + playerArmorHealth + " HP Armor Durumu" + playerArmorCondition);
            Thread.sleep(2000);
        }
        System.out.println(playerName+" Saldıraya Geçiyor");
        Thread.sleep(2000);
        int critChancePlayer = random.nextInt(10);
        if (critChancePlayer <= playerCritChance) {
            System.out.println(playerName+" Crit Hasar Vurdu !!! " + (playerCrit * playerWeaponDamage) + " DMG");
            Thread.sleep(2000);
            bossHealth -= playerCrit * playerWeaponDamage;
            System.out.println(bossName+" canı " + bossHealth);
            Thread.sleep(2000);
        }
        if (critChancePlayer >= playerCritChance) {
            bossHealth -= playerWeaponDamage;
            System.out.println(playerName+" Hasar Vurdu " + playerWeaponDamage + "DMG");
            Thread.sleep(2000);
            System.out.println(bossName+" canı " + bossHealth);
            Thread.sleep(2000);
        }

        if (playerHealth <= 0) {
            Thread.sleep(2000);
            System.out.println(bossName+" son darbeyi vurdu Oyuncu SideBoss a karşı kaybetti ");
            break;
        } else if (bossHealth <= 0) {
            System.out.println(bossName+" yere düşüyor oyuncu kazandı !!!! ödülünüz ---> " + sideQuestPrize);
            Thread.sleep(2000);
            bossLvl += bossLvlUpgrade ;
            System.out.println(bossLvl);
            playerBalance += bossPrize;
            System.out.println("Yeni bakiye " + playerBalance);
            Thread.sleep(2000);
            break;
        }


    }
}else{
    System.out.println("Bu boss a girmek için yeterli bakiyeye sahip değilsin gereken bakiye ---> "+bossEntryPrice+" Gold");
}

    }

    public void GuideBook(){
        do {

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            String guideBook = ">------------------------------------------------------------<\n"+
                    "Merhaba " + playerName + " ihtiyacın olan tüm bilgiler bu metinde \n" +
                    "Oyunda sidequestler para kazanman için yapılmış yan görevlerdir ve her biri (50 Gold) verir\n" +
                    "5 adet boss ve her birinin farklı özellikleri vardır 5'ini de yen ve oyunu kazan\n" +
                    "Market weapon ve armor yükseltmeleri için kullanılır ayrıca armor durumunu da yenileyebilirsin\n" +
                    "Bosslara giriş ücretleri şu şekildedir\n " +
                    ">------------------------------------------------------------<\n"+
                    "1---> 100 Gold\n" +
                    "2---> 300 Gold\n" +
                    "3---> 600 Gold\n" +
                    "4---> 1200 Gold\n" +
                    "5---> 2200 Gold\n" +
                    ">------------------------------------------------------------<\n"+
                    "OYUN İÇİ KOMUTLAR AŞAĞIDAKİ GİBİDİR\n" +
                    "Boss a girmek için 'BOSS' yazılmalı\n" +
                    "Markete girmek için 'Market' yazılmalı\n" +
                    "SideQuest için 'SideQuest' yazılmalı\n" +
                    "Rehbere girmek için 'Rehber' yazılmalı\n" +
                    "Oyunu kapatmak için 'Çıkış' Yazılmalı\n" +
                    ">------------------------------------------------------------<\n"+
                    "HER ŞEY ANLAŞILDIĞINA GÖRE REHBERDEN ÇIKMAK İÇİN (KAPAT) YAZABİLİRSİN ---->";
            System.out.print(guideBook);
            guideBookExit = scanner.next();
        }while (!guideBookExit.equalsIgnoreCase("kapat"));




    }
    public void DeBugger(){
        int bug = bossLvl+bossHealth+bossLvlUpgrade+bossCrit+bossPrize+bossDamage+bossEntryPrice+BossCritChance;
        String buggy = bossName;
    }



}

