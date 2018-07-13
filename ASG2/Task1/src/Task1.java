/**********************************************
 Workshop #2
 Course:JAC444 - Summer
 Last Name:Kiguru
 First Name:Raymond
 ID:126967165
 Section:C
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature RK
 Date:21/06/2018
 **********************************************/

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Task1 {
    private static Scanner inputSystem = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean inputFlag;
        int menuOption = 0;

        System.out.println("DONT FORGET TO CHANGE THE PATH OF THE WORDS.TT FILE TO YOUR PC.");

        out.println("Press 1 to run game with randomly generated word.");
        out.println("Press 2 to run game by reading the word from the text file.");
        do {
            inputFlag = false;

            out.print("Enter your choice: ");
            try {
                menuOption = inputSystem.nextInt();
            } catch (InputMismatchException ime) {
                inputFlag = true;
            } finally {
                inputSystem.nextLine();
            }
        } while (inputFlag || menuOption <= 0 || menuOption >= 3);
        if (menuOption == 1)
            while(hangman(randomWord()));
        else
            while(hangman(fileWord()));
    }

    private static char[] randomWord() {
        String[] words = {"apple", "banana", "cheese", "doughnut", "eclair", "fondue", "gratin"};
        return words[new Random().nextInt(words.length)].toCharArray();
    }

    private static char[] fileWord() {
        String[] words = null;
        String word;
        try {
            File file = new File("C:\\Users\\PC\\Desktop\\New folder\\task2\\src\\words.txt");
            FileReader inputFile = new FileReader(file);
            BufferedReader inputBuffer = new BufferedReader(inputFile);
            words = (inputBuffer.readLine()).split(" ");
        } catch (FileNotFoundException fnfe) {
            out.println("The file couldn't be found.");
        } catch (IOException ioe) {
            out.println("There was a problem with I/O operations.");
        } catch (Exception e) {
            out.println("An error occurred.");
        }
        word = words[new Random().nextInt(words.length)];
        return word.toCharArray();
    }

    private static boolean hangman(char[] word) {
        Vector<Character> guesses = new Vector<>(1, 1);
        char[] displayWord = new char[word.length];
        Arrays.fill(displayWord, '*');
        boolean inputFlag, winFlag;
        char guess = '*';
        int misses = 0;
        do {
            // Make sure only valid characters
            do {
                inputFlag = false;
                out.print("[" + new String(displayWord) + "] Guess > ");
                try {
                    guess = inputSystem.next().charAt(0);
                } catch (InputMismatchException ime) {
                    inputFlag = true;
                } finally {
                    inputSystem.nextLine();
                }
                guess = Character.toLowerCase(guess);
            } while (inputFlag || (int)guess < 97 || (int)guess > 122);
            // Check if already guessed
            for (char comp: guesses) {
                if (comp == guess) {
                    inputFlag = true;
                    out.println("You've already guessed " + guess);
                }
            }
            // Check win / loss
            if (!inputFlag) {
                guesses.add(guess);
                winFlag = false;
                for (int i = 0; i < word.length; i++) {
                    if (word[i] == guess) {
                        displayWord[i] = guess;
                        winFlag = true;
                    }
                }
                if (!winFlag) {
                    out.println(guess + " is not in the word.");
                    misses++;
                }
            }
            // Characters left? (loop again)
            for (char comp: displayWord) {
                if (comp == '*')
                    inputFlag = true;
            }
        } while (inputFlag && misses < 9);

        if (misses == 9)
            out.print("Game Over! ");
        out.println("The word was " + new String(word) + ". You missed " + misses + " times.");

        do {
            inputFlag = false;
            out.print("Do you want to play again? [Y][N]:");
            try {
                guess = inputSystem.next().charAt(0); // recycle guess
            } catch (InputMismatchException ime) {
                inputFlag = true;
            } finally {
                inputSystem.nextLine();
            }
            guess = Character.toLowerCase(guess);
        } while (inputFlag || (guess != 'y' && guess != 'n'));
        return (guess == 'y');
    }
}