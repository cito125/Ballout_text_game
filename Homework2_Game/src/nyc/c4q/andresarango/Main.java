package nyc.c4q.andresarango;

import java.lang.System;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Landscape scapeLand = new Landscape();
        ModifyLandscape modScape = new ModifyLandscape();
        Row newRow = new Row();
        String[][] origiScape = scapeLand.createlandScape();
        int score = 0;
        boolean wantToPlayAgain = true;

        System.out.println("Let's play Ballout!");
        System.out.println("Your ball, o, has a tendency to roll down and to the right!");
        System.out.println("Use your A,S, and D keys to move left, down, and right respectively");
        System.out.println("To get to blocks one below you, enter a double left command");
        System.out.println("After every command press ENTER");
        System.out.println("Pay no mind to your shadow trailing behind you");
        System.out.println("Keep your ball on the rows and, BALLOUT!!!!!! \n");

        while(wantToPlayAgain) {

            while(true) {
                String[][] nextScape = modScape.newRowScape(origiScape);
                modScape.outputLandscape(nextScape);
                System.out.println("Next move: ");
                String userInput = readInput();
                System.out.println("\n");
                if (!modScape.checkMove(nextScape, userInput)) {
                    System.out.println("Your score was " + score +", you probably won't get much better.");
                    break;
                }
                score += 1;
            }


            System.out.println("You almost made it! To what, I don't know!");
            System.out.println("Play again? I hear losing is addicting...");

            while(true) {
                System.out.println("Enter yes or no");
                String playAgain = readInput();
                if (playAgain.equalsIgnoreCase("yes")) {
                    System.out.println("Down the rabbit hole we go!");
                    score = 0;
                    wantToPlayAgain = true;
                    break;
                } else if (playAgain.equalsIgnoreCase("no")) {
                    System.out.println("I wish you had more self-confidence.");
                    wantToPlayAgain = false;
                    break;
                } else {
                    System.out.println("I SAID ENTER YES OR NO!!!!!");
                }
            }
        }
    }

    public static String readInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}