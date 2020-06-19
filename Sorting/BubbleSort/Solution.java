import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

  // Complete the countSwaps function below.
  static void countSwaps(int[] a, int n) {
    int swaps = 0;
    boolean isSorted = false;
    int lastUnsortedItem = n-1;

    while(!isSorted){
      isSorted = true;

      for(int i=0; i< lastUnsortedItem;i++){
        if(a[i] > a[i+1]){
          isSorted = false;
          int temporalValue = a[i];
          a[i] = a[i+1];
          a[i+1] = temporalValue;
          swaps++;
        }
      }

      lastUnsortedItem--;
    }

    System.out.println("Array is sorted in " + swaps + " swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[n-1]);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = Integer.parseInt(scanner.nextLine());

    int[] array = new int[n];

    IntStream.range(0,n).forEach( i -> {
      array[i] = scanner.nextInt();
    });

    countSwaps(array,n);
    scanner.close();
  }

}
