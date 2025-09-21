import java.util.Scanner;

public class Solution {

  public static String getSmallestAndLargest(String s, int k) {
    String smallest = "";
    String largest = "";

    for (int i=0; i< s.length()-(k-1); i++) {
      if (i + k <= s.length()) {
        String substr = s.substring(i, i+k);
        if (largest.equals("")) {
          largest = substr;
        } else {
          largest = largest.compareTo(substr) > 0 ? largest : substr;
        }
        if (smallest.equals(""))  {
          smallest = substr;
        } else {
          smallest = smallest.compareTo(substr) < 0 ? smallest : substr;
        }
      }
    }

    return smallest + "\n" + largest;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int k = scan.nextInt();
    scan.close();
    System.out.println(getSmallestAndLargest(s, k));
  }
}
