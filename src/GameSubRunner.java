import java.util.Scanner;

public class GameSubRunner {
    public void RunTheGame() {
        Game g1 = new Game();
        Scanner scanner = new Scanner(System.in);
        String menuDecision;
        String gameStart;
        String welcomeMsg = "Hello and welcome to the TeqOrCake game \n" +
                "Please write down a nickname for the journey\n" +
                "Player Name ---------> ";
        System.out.print(welcomeMsg);
        g1.playerName = scanner.next();
        System.out.print("Hello " + g1.playerName + " do you really want to start the game  (Y/N)");
        gameStart = scanner.next();

        if (gameStart.equalsIgnoreCase("y")) {
            System.out.println("Hey " + g1.playerName + " First i will guide you to guidebook for some info  ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Loading...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            g1.GuideBook();
            System.out.print("Now you are ready to play what would you like to do ---->");
            menuDecision = scanner.next();
            while (!menuDecision.equalsIgnoreCase("çıkış")) {
                if (menuDecision.equalsIgnoreCase("market")) {
                    try {
                        g1.Upgrade();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else if (menuDecision.equalsIgnoreCase("sidequest")) {
                    try {
                        g1.SideQuest();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else if (menuDecision.equalsIgnoreCase("rehber")) {
                    g1.GuideBook();
                } else if (menuDecision.equalsIgnoreCase("boss")) {
                    if (g1.bossLvl <= 1) {
                        try {
                            g1.BossFight(2, 120, 150, 100, 2, 10, "FOFANA");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (g1.playerHealth == 1) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("YOU DİED !!!");
                            break;
                        }
                    } else if (g1.bossLvl == 2) {
                        try {
                            g1.BossFight(3, 180, 450, 300, 3, 30, "DANTE");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (g1.playerHealth <= 0) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("YOU DİED !!!");
                            break;
                        }

                    } else if (g1.bossLvl == 3) {
                        try {
                            g1.BossFight(3, 260, 900, 600, 3, 50, "Vasto Lorde");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (g1.playerHealth <= 0) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("YOU DİED !!!");
                            break;
                        }
                    } else if (g1.bossLvl == 4) {
                        try {
                            g1.BossFight(3, 490, 1800, 1200, 4, 70, "Espada");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (g1.playerHealth <= 0) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("YOU DİED !!!");
                            break;
                        }
                    } else if (g1.bossLvl == 5) {
                        try {
                            g1.BossFight(4, 800, 10000, 2200, 5, 100, "KAİSER");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (g1.playerHealth <= 0) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("YOU DİED !!!");
                            break;
                        } else if (g1.bossHealth <= 0) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("You beat KAİSER congrats GAME OVER :) ");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        }

                    }

                }
                System.out.print("What would you like to do now ---->");
                menuDecision = scanner.next();
            }

        }
    }
}
