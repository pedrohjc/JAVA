//**********************************************
//
//        Workshop 2
//
//        Course:JAC44 - 4th Semester
//
//        Last Name: Carvalho
//
//        First Name: Pedro Henrique
//
//        ID: 118495167
//
//        Section: SCD
//
//        This assignment represents my own work in accordance with Seneca Academic Policy.
//
//        Pedro Henrique Carvalho
//
//        Date:Jun - 21 - 2018
//
//        **********************************************/


import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){

        int usrinit = 0;
        boolean flag;

        //Checks for input error
        do {
            System.out.println("Hangman Game!");

            System.out.println("Press 1 to run game with randomly generated word.");
            System.out.println("Press 2 to run game by reading the word from the text file.");
            System.out.print("Enter Enter your choice:");

            try {
                Scanner sc = new Scanner(System.in);
                usrinit = sc.nextInt();
                if (usrinit != 1 && usrinit != 2) {
                    System.out.println("Please enter a valid number!");
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }catch(InputMismatchException e){
                System.out.print("Enter a NUMBER NOT A CHARACTER");
                flag = true;
            }
        } while (flag == true) ;
        //Initialize the chosen program
        if(usrinit == 1){
            PartA starA = new PartA();
        }
        else if(usrinit == 2){
            PartB starB = new PartB();
        }

    }
}
