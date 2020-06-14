import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.math.BigInteger;

public class DigitSum {

  private static final Scanner scanner = new Scanner(System.in);
  private static final PrintWriter printWriter = new PrintWriter(new BufferedWriter(
    new OutputStreamWriter(System.out)
  ));

  private static final Integer MIN_VALUE = 10;

  public static Long getSum(Long digit) {
    Long sum = Long.valueOf(0);

    while(digit >= 1){
      sum += (digit % MIN_VALUE);
      digit /= MIN_VALUE;
    }

    return sum;
  }

  public static Long getSuperDigit(Long digit){
    Long sum = getSum(digit);

    while(sum >= MIN_VALUE){
      sum = getSum(sum);
    }

    return sum;
  }

  public static void main(String... args){
    String digit = scanner.next();
    Integer k = scanner.nextInt();

    Long sum = Stream.of(digit.split(""))
                     .mapToLong(Long::valueOf)
                     .reduce(Long.valueOf(0), Long::sum);

    Long superDigit = getSuperDigit(sum*k);
    printWriter.println(superDigit);

    scanner.close();
    printWriter.close();
  }

}
