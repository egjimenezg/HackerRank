#include <stdio.h>
#include <algorithm>
#include <vector>

using namespace std;

int LIS(vector<int> A) {
  int longestSubsequence = 0;
  vector<int> LIS(A.size());
  
  for(int index=0; index < A.size(); index++){
    int lowerBoundPosition = lower_bound(LIS.begin(), LIS.begin()+longestSubsequence, A[index])-LIS.begin();

    LIS[lowerBoundPosition] = A[index];
    
    if(lowerBoundPosition == longestSubsequence){
      longestSubsequence += 1;
    }
  }

  return longestSubsequence;
}

int main(){
  int n;
  scanf("%d", &n);

  vector<int> array(n);

  for(int i=0; i<n; i++){
    scanf("%d", &array[i]);
  }

  printf("%d\n", LIS(array));

  return 0;
}

