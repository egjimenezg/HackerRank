import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class GreedyFlorist {

  private static final Scanner scanner = new Scanner(System.in);
  private static final PrintWriter printWriter = new PrintWriter(new BufferedWriter(
    new OutputStreamWriter(System.out)));

  private static Integer getMinimumCost(Integer k, Integer[] costs){
    Integer minimumCost=0, multiplier=1;

    Arrays.sort(costs);

    for(int i=0; i < costs.length; i++){
      minimumCost += costs[costs.length-1-i]*multiplier;
      
      if((i+1) % k == 0){
        multiplier++;
      }
    } 

    return minimumCost;
  }

  public static void main(String... args){
    Integer n, k;
    n = scanner.nextInt();
    k = scanner.nextInt();
    scanner.nextLine(); 
    
    Integer[] costs = new Integer[n];

    IntStream.rangeClosed(1, n).boxed().forEach( i -> {
      costs[i-1] = scanner.nextInt();
    });

    printWriter.println(getMinimumCost(k, costs));

    printWriter.close();
    scanner.close();
  }

}
