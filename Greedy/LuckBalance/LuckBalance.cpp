#include <stdio.h>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

vector<string> split_string(string);

bool sortByColumn(const vector<int>& A, const vector<int>& B){
  return B[0] < A[0];
}

// Complete the luckBalance function below.
int luckBalance(int k, vector<vector<int> > contests) {
  int luckBalance = 0;

  vector<vector<int> > importantContests;
  vector<vector<int> > unimportantContests;

  for (int i = 0; i < contests.size(); i++) {
    if(contests[i][1] == 1) {
      importantContests.push_back(contests[i]);
    } else {
      unimportantContests.push_back(contests[i]);
    }
  }

  sort(importantContests.begin(), importantContests.end(), sortByColumn);

  for(vector<int> contestData : importantContests){
    luckBalance += (k > 0) ? contestData[0] : -contestData[0];
    k--;
  }

  for(vector<int> contestData : unimportantContests){
    luckBalance += contestData[0];
  }

  return luckBalance;
}

int main(){
  int n, k;

  scanf("%d %d", &n, &k);

  vector<vector<int> > contests(n);

  for (int i = 0; i < n; i++) {
    contests[i].resize(2);
    scanf("%d %d", &contests[i][0], &contests[i][1]);
  }

  int result = luckBalance(k, contests);
  printf("%d\n", result);

  return 0;
}

