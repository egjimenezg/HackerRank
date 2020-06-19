#include <stdio.h>
#include <vector>
#include <string>

using namespace std;

vector<string> split_string(string);

void merge(long p, long q, long r, vector<long>* arr,long* swaps) {
  long n1 = q-p+1;
  long n2 = r-q;
  long leftArray[n1];
  long rightArray[n2];

  for(int i=0;i<n1;i++)
    leftArray[i] = arr->at(p+i);

  for(int j=0;j<n2;j++)
    rightArray[j] = arr->at(q+j+1);

  int left = 0, right = 0, k = p;

  while(left < n1 && right < n2){
    if(leftArray[left] <= rightArray[right]){
      arr->at(k++) = leftArray[left];
      left++;
    } else {
      (*swaps) += (n1-left);
      arr->at(k++) = rightArray[right];
      right++;   
    }
  }

  while(left < n1){
    arr->at(k++) = leftArray[left];
    left++;
  }

  while(right < n2){
    arr->at(k++) = rightArray[right];
    right++;
  }

}

void mergeAndSort(long left,long right,vector<long>* arr,long* swaps){
  if(left < right){
    long middle = (left + right)/2;
    mergeAndSort(left,middle,arr,swaps);
    mergeAndSort(middle+1,right,arr,swaps);
    merge(left, middle, right, arr, swaps);
  }
}


// Complete the countInversions function below.
long countInversions(vector<long> arr) {
  long inversions = 0;
  mergeAndSort(0,arr.size()-1,&arr, &inversions);
  return inversions;
}

int main(){
  int d, n;

  scanf("%d", &d);

  while(d--){
    scanf("%d", &n); 

    vector<long> array(n);

    for(int i=0; i<n; i++){
      scanf("%ld", &array[i]);
    }

    long result = countInversions(array);

    printf("%ld\n", result);
  }

  return 0;
}
