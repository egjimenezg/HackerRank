import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.stream.Stream;
import java.math.BigDecimal;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);
  private static final PrintWriter printWriter = new PrintWriter(new BufferedWriter(
    new OutputStreamWriter(System.out)
  ));

  private static Boolean isOdd(int n){
    return (n & 1) == 1;
  }

  // O(1)
  private static BigDecimal getMedian(List<BigDecimal> trailingDays, int days){
    if(isOdd(days))
      return trailingDays.get(days/2);

    return trailingDays.get(days/2-1).add(trailingDays.get(days/2)).divide(new BigDecimal(2));
  }

  // O(log(n))
  private static Integer lowerBound(List<BigDecimal> trailingData, BigDecimal entry){
    int low = 0;
    int high = trailingData.size()-1;
    int lowerBound = -1;

    while(low <= high){
      int middle = low+((high-low)/2);

      if(trailingData.get(middle).compareTo(entry) < 1){
        lowerBound = middle;
        low = middle+1;
      } else {
        high = middle-1;
      }
    }

    return lowerBound;
  }

  private static Integer getNotificationsNumber(BigDecimal[] expenditures, Integer days){
    Integer notifications = 0;

    // O(n log(n))
    List<BigDecimal> trailingDays = Stream.of(expenditures)
                                          .limit(days)
                                          .sorted()
                                          .collect(Collectors.toList());

    // O(n log(n))
    for(int from=days; from<expenditures.length; from++){
      BigDecimal median = getMedian(trailingDays, days);
      median = median.multiply(new BigDecimal("2"));

      if(expenditures[from].compareTo(median) > -1){
        notifications++;
      }

      int first = Collections.binarySearch(trailingDays,expenditures[from-days]);
      trailingDays.remove(first);
      
      Integer lowerBound = lowerBound(trailingDays, expenditures[from]);
      trailingDays.add(lowerBound+1, expenditures[from]);
    }

    return notifications;
  }

  public static void main(String... args){
    Integer n = scanner.nextInt();
    Integer days = scanner.nextInt();
    BigDecimal[] expenditures = new BigDecimal[n];

    while(n-- > 0){
      expenditures[expenditures.length-n-1] = scanner.nextBigDecimal()
                                                     .setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    Integer notificationsNumber = getNotificationsNumber(expenditures, days);

    printWriter.println(notificationsNumber);

    printWriter.close();
    scanner.close();
  }

}
