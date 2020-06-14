#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

// Complete the whatFlavors function below.
bool binarySearch(vector<long>* cost, long value){
  int left = 0;
  int right = cost->size()-1;
  
  while(left <= right){
    int middle = (left + (right - left)/2);

    if(cost->at(middle) == value){
      return true;
    }
    else if(value < cost->at(middle)){
      right = middle-1;
    }
    else{
      left = middle+1;
    }
  }

  return false;
}

void whatFlavors(vector<long> cost, long money) {
  vector<long> positions(cost.size());
  
  for(int i=0;i<positions.size();i++){
    positions[i] = cost[i];
  }

  sort(cost.begin(),cost.end());

  long position = 0;
  long secondCost = money-cost[position];

  while(!binarySearch(&cost,secondCost)) {
    position++;
    secondCost = money-cost[position];
  }

  pair<int,int> result;
  result.first = -1;
  result.second = -1;

  int index = 0;

  while(result.first == -1 || result.second == -1) {
    if (cost[position] == positions[index] && result.first == -1) {
      result.first = index+1;
    }

    if (secondCost == positions[index] && ((index+1) != result.first)) {
      result.second = index+1;
    }

    index++;
  }

  if(result.first < result.second){
    printf("%d %d\n", result.first, result.second);
  } else {
    printf("%d %d\n", result.second, result.first);
  }
}

int main() {
  int t, n;
  long money;

  scanf("%d", &t);
  
  while(t--){
    scanf("%ld", &money);
    scanf("%d", &n);

    vector<long> cost(n);

    for(int i=0; i<n; i++){
      scanf("%ld", &cost[i]);
    }

    whatFlavors(cost, money);
  }

  return 0;
}
