#include <stdio.h>
#include <algorithm>

using namespace std;

int maxSum(int*, int, int);
int getSum(int, int, int, int, int*);

int main(){
  int cases, n, target;
  scanf("%d", &cases);

  while(cases--){
    scanf("%d %d", &n, &target);
    int* array = new int[n];

    for(int i=0; i<n; i++){
      scanf("%d", &array[i]);
    }

    int sum = maxSum(array, target, n); 
    printf("%d\n", sum);
  }

  return 0;
}

int maxSum(int* array, int target, int size){
  return getSum(0, 0, target, size, array);
}

int getSum(int index, int sum, int target,int size, int* array){
  if(target == 0)
    return sum;

  if(index == size){
    return sum;
  }

  if(array[index] > target){
    return getSum(index+1, sum, target, size, array); 
  }

  return max(getSum(index, sum+array[index], target-array[index], size, array),
             getSum(index+1, sum, target, size, array));
}
