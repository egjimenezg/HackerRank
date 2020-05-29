import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Candies {

  private static final Scanner scanner = new Scanner(System.in);
  private static final PrintWriter printWriter = new PrintWriter(new BufferedWriter(
    new OutputStreamWriter(System.out)));

  static long getCandies(int[] A){
    long candiesNumber = 1;
    int[] candies = new int[A.length];
    candies[0] = 1;
      
    for(int index=1; index<A.length; index++){
      if(A[index] > A[index-1]){
        candies[index] = candies[index-1]+1;
        candiesNumber += candies[index];
      } else {
        candies[index] = 1;
        candiesNumber += 1;
        if(A[index-1] > A[index] && candies[index] == candies[index-1]){
          candies[index-1] = candies[index]+1;
          candiesNumber += 1;
        }
      }
    }

    for(int index=A.length-1; index > 0; index--){
      if(A[index-1] > A[index] && candies[index-1] <= candies[index]){
        candiesNumber += (candies[index]+1)-candies[index-1];
        candies[index-1] = candies[index]+1;
      }
    }

    return candiesNumber;
  }

  public static void main(String... args){
    Integer n = Integer.parseInt(scanner.nextLine());
    int[] A = new int[n];

    for(int index=0; index<n; index++){ 
      A[index] = Integer.parseInt(scanner.nextLine()); 
    }

    long candiesNumber = getCandies(A);

    printWriter.println(candiesNumber);
    printWriter.close();
    scanner.close();
  }

}
