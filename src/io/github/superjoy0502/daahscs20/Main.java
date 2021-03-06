package io.github.superjoy0502.daahscs20;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                """
                Hello, user! Which project do you want to access?
                \t1. Rock Paper Scissors Project
                \t2. Parallel Arrays Project
                """
        );
        System.out.print(">> ");

        Scanner scanner = new Scanner(System.in);
        int cmd = 0;

        cmd = scanner.nextInt();

        switch (cmd) {
            case 1 -> {
                Game game = new Game();
                game.Initialize();
            }
            case 2 -> {
                ParallelArray parallelArray = new ParallelArray();
                parallelArray.Initialize();
            }
            default -> {
                System.out.println("Please choose a proper option.");
            }
        }

    }

}
