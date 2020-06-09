import java.util.Stack;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Solution {

  static Boolean isClosingChar(char top, char current){
    return ((top == '(' && current == ')') || (top == '[' && current == ']') || (top == '{' && current == '}'));
  }

  // Complete the isBalanced function below.
  static String isBalanced(String s) {
    Stack<Character> stack = new Stack<Character>();
    s.chars().forEach(c -> {
      if(!stack.isEmpty() && isClosingChar(stack.peek(), (char)c)){
        stack.pop();
      }
      else{
        stack.push((char)c);
      }
    });

    if(stack.isEmpty())
      return "YES";

    return "NO";
  }

  private static final Scanner scanner = new Scanner(System.in);
  private static final PrintWriter printWriter = new PrintWriter(new BufferedWriter(
    new OutputStreamWriter(System.out)));

  public static void main(String[] args) throws IOException {

    int cases = Integer.parseInt(scanner.nextLine());
    
    while(cases-- > 0){
      String s = scanner.nextLine();
      String result = isBalanced(s);
      printWriter.println(result);
    }

    scanner.close();
    printWriter.close();
  }

}
