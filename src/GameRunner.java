import java.util.Scanner;

public class GameRunner extends Game{
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Game g1 = new Game();
        String menuDecision;
        String gameStart ;
        String welcomeMsg = "Merhaba yolcu buralarda yeni görünüyorsun yeni bir maceraya başlamak \n"+
                "Uçsuz bucaksız bir denizde pusulasız yola çıkmak gibidir yeni oyun için önce adını girmelisiniz \n"+
                "Oyuncu Adı ---------> ";
        System.out.print(welcomeMsg);
        g1.playerName=scanner.next();
        System.out.print("Merhaba "+g1.playerName+" Bu yolculukta senin rehberin ben olacağım oyuna başlamak için (Y/N)");
        gameStart = scanner.next();

        if (gameStart.equalsIgnoreCase("y")){
            System.out.println("Hey "+g1.playerName + " önce seni rehbere aktarılıyorum orada ihtiyacın olan bilgilere ulaşabilirsin ");
            Thread.sleep(1000);
            System.out.println("Rehbere aktarılıyor...");
            Thread.sleep(2000);
            g1.GuideBook();
            System.out.print("Tamamdır artık hazırız ne yapmak istediğini gir lütfen");
            menuDecision = scanner.next();
            while (!menuDecision.equalsIgnoreCase("çıkış")){
                if (menuDecision.equalsIgnoreCase("market")){
                    g1.Upgrade();
                } else if (menuDecision.equalsIgnoreCase("sidequest")) {
                    g1.SideQuest();
                } else if (menuDecision.equalsIgnoreCase("rehber")) {
                    g1.GuideBook();
                } else if (menuDecision.equalsIgnoreCase("boss")) {
                    if (g1.bossLvl <= 1){
                        g1.BossFight(2,120,150,100,2,10,"FOFANA");
                        if (g1.playerHealth == 1){
                            Thread.sleep(2000);
                            System.out.println("YOU DİED !!!");
                            break;
                        }
                    } else if (g1.bossLvl == 2) {
                        g1.BossFight(3,180,450,300,3,30,"DANTE");
                        if (g1.playerHealth <= 0){
                            Thread.sleep(2000);
                            System.out.println("YOU DİED !!!");
                            break;
                        }

                    } else if (g1.bossLvl ==3 ) {
                        g1.BossFight(3,260,900,600,3,50,"Vasto Lorde");
                        if (g1.playerHealth <= 0){
                            Thread.sleep(2000);
                            System.out.println("YOU DİED !!!");
                            break;
                        }
                    } else if (g1.bossLvl==4) {
                        g1.BossFight(3,490,1800,1200,4,70,"Espada");
                        if (g1.playerHealth <= 0){
                            Thread.sleep(2000);
                            System.out.println("YOU DİED !!!");
                            break;
                        }
                    } else if (g1.bossLvl == 5) {
                        g1.BossFight(4,800,10000,2200,5,100,"KAİSER");
                        if (g1.playerHealth <= 0){
                            Thread.sleep(2000);
                            System.out.println("YOU DİED !!!");
                            break;
                        } else if (g1.bossHealth<=0) {
                            Thread.sleep(2000);
                            System.out.println("Kaiser i yendin ve oyun bitti şimdi siktir git");
                            Thread.sleep(2000);
                            break;
                        }

                    }

                }
                System.out.print("Tercihin nedir ---->");
                menuDecision = scanner.next();
            }

        }

    }
}
