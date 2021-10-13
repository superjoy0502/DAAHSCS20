package io.github.superjoy0502.daahscs20;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    Scanner scanner = new Scanner(System.in);
    String userName;
    String cmd;
    int score = 0;

    //region DICE

    final String DICE_ONE = """
            -----
            |   |
            | o |
            |   |
            -----
            """;

    final String DICE_TWO = """
            -----
            |o  |
            |   |
            |  o|
            -----
            """;

    final String DICE_THREE = """
            -----
            |o  |
            | o |
            |  o|
            -----
            """;

    final String DICE_FOUR = """
            -----
            |o o|
            |   |
            |o o|
            -----
            """;

    final String DICE_FIVE = """
            -----
            |o o|
            | o |
            |o o|
            -----
            """;

    final String DICE_SIX = """
            -----
            |o o|
            |o o|
            |o o|
            -----
            """;

    //endregion

    void Initialize() {

        cmd = "";
        userName = "";

        // Setup username

        Clear();
        System.out.print("Enter username >> ");

        userName = scanner.nextLine();  // Read user input
        System.out.print("Would you like to set your username as: " + userName + "? (Y/N) >> ");  // Output user input

        cmd = scanner.nextLine();

        while (true) {

            if (cmd.equalsIgnoreCase("n")) {

                Initialize();
                break;

            }
            else if (cmd.equalsIgnoreCase("y")) {

                System.out.println("Your username is set to: " + userName + "!");
                Menu();
                break;

            }
            else {

                System.out.print("Enter a proper option (Y/N) >> ");
                cmd = scanner.nextLine();

            }

        }

    }

    void Menu() {

        Clear();
        System.out.printf("""
                        Welcome to the Game, %s! Your current score is: %d
                        Please select an option:
                        \t|| Play a Game:
                        \t\t* Rock Paper Scissors Game (RPS)
                        \t|| Some Fun Stuffs:
                        \t\t* Roll a Dice (RaD)
                        \t* Quit (Quit)%n
                        """,
                userName,
                score);
        System.out.print(">> ");

        cmd = scanner.nextLine();

        while (true) {

            if (cmd.equalsIgnoreCase("rps")) {

                RPS();
                break;

            }
            else if (cmd.equalsIgnoreCase("rad")) {
                RAD();
                break;
            }
            else if (cmd.equalsIgnoreCase("quit")) {

                System.out.println("Thank you for playing.");
                break;

            }
            else {

                System.out.print("Enter a proper option >> ");
                cmd = scanner.nextLine();

            }

        }

    }

    void RPS() {

        Scanner rpsScanner = new Scanner(System.in);

//        System.out.println("RPS function called.");

        while (true) {

            Clear();
            System.out.println("""
                    Make your move:
                    \tRock (R)
                    \tPaper (P)
                    \tScissors (S)
                    """);

            System.out.print("To return to menu, enter \"quit\" >> ");

            String move = rpsScanner.nextLine();

            if (move.equalsIgnoreCase("quit")) {

                Menu();
                break;

            } else if (!move.equalsIgnoreCase("r") && !move.equalsIgnoreCase("p") && !move.equalsIgnoreCase("s")) {

                System.out.println("Make a valid move!");

            } else {

                int x = (int) (Math.random() * 3); // this produces options (0, 1, 2)
//                System.out.println("rand: " + x);

                String computerMove = switch (x) {

                    case 0 -> "Rock";
                    case 1 -> "Paper";
                    case 2 -> "Scissors";
                    default -> throw new IndexOutOfBoundsException("Random number is not 0, 1, or 2! (This should not happen)");

                };

                System.out.println("Opponent's move >> " + computerMove);

                String CM = computerMove.substring(0, 1);

                if (move.equalsIgnoreCase(CM)){

                    System.out.println("Game tied!");

                } else if (move.equalsIgnoreCase("s") && CM.equalsIgnoreCase("p")
                        || move.equalsIgnoreCase("r") && CM.equalsIgnoreCase("s")
                        || move.equalsIgnoreCase("p") && CM.equalsIgnoreCase("r")){

                    score += 2;
                    System.out.println("Game won!");

                } else {

                    score -= 1;
                    System.out.println("Game lost :(");

                }

                System.out.print("Enter \"R\" to play again, else to return to menu >> ");
                cmd = scanner.nextLine();

                if (!cmd.equalsIgnoreCase("r")){

                    Menu();
                    break;

                }

            }

        }

    }

    void RAD() {

        try{

            for (int i = 0; i < 2; i++) {

                System.out.println("Rolling.");
                TimeUnit.SECONDS.sleep(1);
                Clear();
                System.out.println("Rolling..");
                TimeUnit.SECONDS.sleep(1);
                Clear();
                System.out.println("Rolling...");
                TimeUnit.SECONDS.sleep(1);
                Clear();

            }

            int x = (int) (Math.random() * 6) + 1;

            String printDice = switch (x) {

                case 1 -> DICE_ONE;
                case 2 -> DICE_TWO;
                case 3 -> DICE_THREE;
                case 4 -> DICE_FOUR;
                case 5 -> DICE_FIVE;
                case 6 -> DICE_SIX;
                default -> throw new IndexOutOfBoundsException("Random number is not 1 ~ 6! (This should not happen)");

            };

            System.out.println(printDice);

            System.out.print("To go back to menu, press any Enter >> ");

            cmd = scanner.nextLine();
            Menu();

        }
        catch (Exception e){
            System.out.println("ERROR");
        }

    }

    void Clear() {

        for (int i = 0; i < 100; i++) {

            System.out.println("\n");

        }

    }

}
