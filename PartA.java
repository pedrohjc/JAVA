import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class PartA {

    //Words that will be used!
    String[] words = new String[]{"car","program","college","bag","mouse"};
    boolean right,ngright,flag1 = false;
    int stars, lifes, losses;
    ArrayList <String> fstars = new ArrayList <String>();
    char usrin, newgame;
    String starsright;

    public PartA(){

        Random random = new Random();
        int randomIdx = random.nextInt(words.length);
        //System.out.println(words[randomIdx]);
        //do {
            //System.out.println("(Guess) Enter a letter in word");
            char[] a = words[randomIdx].toCharArray();
            for(char c:a){
                //System.out.print(c);
                stars++;
            }
            //System.out.println("");
        for(int i = 0; i < stars;i++){
            fstars.add("*");
        }
        System.out.println("---====  GOOD LUCK!  ====---");
        do {
            System.out.print("(Guess) Enter a letter in word " + fstars + " >");
            Scanner sc = new Scanner(System.in);
            usrin = sc.next().charAt(0);
            for(int i = 0; i < a.length; i++){
                //int j =+ i+1;
                if(usrin != a[i] && i+1 == a.length){
                    if(right == false) {
                        System.out.println("Wrong");
                        losses++;
                    }
                }
                if(this.usrin == a[i]) {
                    starsright = new StringBuilder().append(this.usrin).toString();
                    fstars.set(i, starsright);
                    right = true;
                    lifes++;
                }
            }
            right = false;
        }while(lifes < stars);

        System.out.println("The word is "+ words[randomIdx].toUpperCase() + ". You missed " + losses + " times.");
        do {
            System.out.print("Do you want to guess another word??  Enter Y or N >");
            Scanner sc = new Scanner(System.in);
            newgame = sc.next().charAt(0);
            if (newgame == 'y'||newgame == 'Y') {
                ngright = true;
                PartA starA = new PartA();
            } else if(newgame == 'n'||newgame == 'N'){
                System.out.println("Thank you for Playing!");
                ngright=true;
                break;
            }else{
                System.out.println("You entered: " + newgame + ". Please enter a valid entry: 'Y' or 'N'");
                ngright = false;
            }
        }while(ngright == false);
        //}while(victory = true);
    }

}
