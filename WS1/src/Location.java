
//Task 1
import java.util.Scanner;

public class Location {

    public static void main(String[] args){

    double[][] mylist = new double[0][0];
    locateLargest(mylist);

    }

    public static Location locateLargest(double[][] a){

      int arow, acolumn;
      double maxValue;

      System.out.print("Enter the number of rows and columns in the array: ");
      Scanner sc = new Scanner(System.in);
      arow = sc.nextInt();
      acolumn = sc.nextInt();
        double[][] matrix = new double[arow][acolumn];
        java.util.Scanner input = new Scanner(System.in);
        System.out.println("Enterthe Array: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextDouble();
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }

      var temp = new Location();
      return temp;


    };

}
