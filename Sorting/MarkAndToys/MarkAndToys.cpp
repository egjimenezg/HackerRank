#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

// Complete the maximumToys function below.
int maximumToys(vector<long> prices, long k) {
  int maximumToys = 0, index = 0;
  long sum = 0;

  sort(prices.begin(),prices.end());

  while(sum <= k && index < prices.size()){
    sum += prices[index++];
    maximumToys += 1;
  }

  return maximumToys-1;
}

int main(){
  int n;
  long k;

  scanf("%d %ld", &n, &k);

  vector<long> prices(n);

  while(n--){
    scanf("%ld", &prices[prices.size()-n-1]);
  }
  
  long result = maximumToys(prices, k);

  printf("%ld\n", result);

  return 0;
}
