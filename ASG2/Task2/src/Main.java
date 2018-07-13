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


import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        double limit;
        int nbanks;

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Number of Banks: ");
        nbanks = sc.nextInt();
        System.out.print("Minimum asset limit: ");
        limit = sc2.nextDouble();
        for (int i = 0; i < nbanks; i++){
            Bank bank = new Bank();
            System.out.print("Bank #" + i + " -> ");
            bank = bank.banksStart(bank);
        }
    }
}
