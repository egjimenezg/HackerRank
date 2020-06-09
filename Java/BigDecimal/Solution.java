import java.math.BigDecimal;
import java.util.*;

class Solution{

  public static void main(String []args){
    //Input
    Scanner sc= new Scanner(System.in);
    int n = sc.nextInt();
    String []s = new String[n+2];

    for(int i=0;i<n;i++){
      s[i]=sc.next();
    }
    sc.close();

    for(int index=1;index<n;index++){
      String key = s[index];
      int j = index-1;

      while(j >= 0 && (new BigDecimal(s[j]).compareTo(new BigDecimal(key)) == -1)){
        s[j + 1] = s[j];
        j -= 1;
      }

      s[j + 1] = key;
    }


    //Output
    for(int i=0;i<n;i++){
      System.out.println(s[i]);
    }
  }
}
