import java.util.stream.IntStream;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);
  private static final PrintWriter printWriter = new PrintWriter(
    new BufferedWriter(
      new OutputStreamWriter(System.out)
    )
  );

  public static void main(String... args){
    String s1 = scanner.nextLine();    
    String s2 = scanner.nextLine();
    printWriter.println(LCS(s1,s2)); 
    scanner.close();
    printWriter.close();
  }

  public static Integer LCS(String a, String b){
    int rows = a.length();
    int cols = b.length();
    int length = 0;

    int[][] lcsMatrix = new int[rows+1][cols+1];

    IntStream.rangeClosed(1, rows).forEach( row -> {
      lcsMatrix[row][0] = 0;
    });

    IntStream.rangeClosed(1,cols).forEach( col -> {
      lcsMatrix[0][col] = 0;
    });

    for(int row=1; row <= rows; row++){
      for(int col=1; col <= cols; col++){
        if(a.charAt(row-1) == b.charAt(col-1)){
          lcsMatrix[row][col] = lcsMatrix[row-1][col-1]+1;
          length = Math.max(length, lcsMatrix[row][col]);
        }
        else if(lcsMatrix[row-1][col] >= lcsMatrix[row][col-1]){
          lcsMatrix[row][col] = lcsMatrix[row-1][col];
        } else {
          lcsMatrix[row][col] = lcsMatrix[row][col-1];
        }
      }
    }

    return length;
  }

}
