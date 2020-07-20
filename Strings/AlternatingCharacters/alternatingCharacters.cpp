#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

int alternatingCharacters(string s){
  int minimumSteps = 0;
  int previous = 0;

  for(int i=1; i<s.size(); i++){
    if(s[previous] == s[i]){
      minimumSteps++;
    } else {
      previous = i;
    }
  }

  return minimumSteps;
}

int main(){
  int q;
  scanf("%d\n", &q);

  while(q--){
    string s;
    getline(cin, s);
    int result = alternatingCharacters(s);
    printf("%d\n", result);
  }
}
