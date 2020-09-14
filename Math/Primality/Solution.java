import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String... args){
    Integer cases = Integer.parseInt(scanner.nextLine());

    while(cases-- > 0){
      Long number = Long.valueOf(scanner.nextLong());
      System.out.println(isPrime(number) ? "Prime" : "Not prime");
    }
  }

  public static Boolean isPrime(Long n){
    for(Long i=Long.valueOf(2); i<=Math.sqrt(n); i++){
      if(n % i == 0){
        return false;
      }
    }
    return true;
  }

}

