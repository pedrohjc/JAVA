import java.util.Scanner;


public class Bank {

    double limit;
    int nbanks, bankID, banksloan;
    double assets, balance,loans;
    boolean safe;

    public Bank(){
       balance = 0;
       bankID = 99;
       banksloan = 0;


    }
    public Bank(double bal){
        this.balance = bal;
    }

    public double getassets(){
        return this.balance += this.loans;
    }

    public boolean isSafe(Bank b){
        if(b.getassets() < limit){
            return b.safe = false;
        }else{
            return b.safe = true;
        }
    }

    public double loaning(double value){
        return this.loans += value;
    }

    public Bank banksStart(Bank b) {

        Scanner bsc = new Scanner(System.in);
        System.out.print("Balance:");
        b.balance = bsc.nextDouble();
        System.out.print("Number of banks Loaned:");
        b.banksloan = bsc.nextInt();
        for (int j = 0; j < banksloan; j++) {
            double temp;
            System.out.print("Bank ID: ");
            b.bankID = bsc.nextInt();
            System.out.print("Amount: ");
            temp = bsc.nextDouble();
            b.loans = loaning(temp);
            b.assets = b.getassets();

        }
        if(isSafe(b)){
            System.out.println("This bank is SAFE.");
        }else{
            System.out.println("This bank is UNSAFE.");
        }
        return b;
    }









}
