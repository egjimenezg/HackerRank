import java.util.*;

public class Solution {

  public static int fibonacci(int n, int[] memory) {
    if(n == 0)
      return 0;
    
    if(memory[n] != 0)
      return memory[n];
    
    if(n == 1){
      memory[n] = 1;
    } else{
      memory[n] = fibonacci(n-1,memory) + fibonacci(n-2,memory);
    }
        
    return memory[n];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    
    int[] memory = new int[n+1];
        
    System.out.println(fibonacci(n,memory));
    scanner.close();
  }

}
