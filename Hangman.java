package HangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("Welcome to Hangman");

        File dict = new File("C:\\Users\\durve\\eclipse-workspace\\Hangman Game\\src\\english2.txt");
        Scanner textScanner = null;
        try {
            textScanner = new Scanner(dict);
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found.");
            return;
        }

        ArrayList<String> words = new ArrayList<>();
        while (textScanner.hasNextLine()) {
            words.add(textScanner.nextLine());
        }
        textScanner.close();

        String hiddenText = words.get((int) (Math.random() * words.size()));
        char[] textArray = hiddenText.toCharArray();

        char[] myAnswer = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswer[i] = '?';
        }

        boolean finished = false;
        int lives = 5;
        Scanner inputScanner = new Scanner(System.in);

        while (!finished) {
            System.out.println("******************");
            System.out.println("Enter a letter: ");
            String input = inputScanner.next();

            // checks for valid input
            while (input.length() != 1 || Character.isDigit(input.charAt(0))) {
                System.out.println("Error Input - Try Again");
                input = inputScanner.next();
            }

            // checks if letter is in the word
            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (input.charAt(0) == textArray[i]) {
                    myAnswer[i] = textArray[i];
                    found = true;
                }
            }
            if (!found) {
                lives--;
                System.out.println("Wrong Letter");
            }

            boolean done = true;
            for (int i = 0; i < myAnswer.length; i++) {
                if (myAnswer[i] == '?') {
                    System.out.print("_ ");
                    done = false;
                } else {
                    System.out.print(myAnswer[i] + " ");
                }
            }
            System.out.println("\nLives Left: " + lives);
            drawHangman(lives);

            // check if the game ends
            if (done) {
                System.out.println("Congratulations!!! You guessed the word: " + hiddenText);
                finished = true;
            }
            if (lives <= 0) {
                System.out.println("You are Dead :(");
                System.out.println("The word was: " + hiddenText);
                finished = true;
            }
        }
        inputScanner.close();
    }

    public static void drawHangman(int l) {
        if (l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
