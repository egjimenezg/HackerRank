#include <iostream>
#include <string>
#include <map>

using namespace std;

// Complete the isValid function below.
string isValid(string s) {
  map<char,int> frequencies;
  for(char c : s){
    map<char, int>::iterator currentFrequency = frequencies.find(c);

    if(currentFrequency != frequencies.end())
      currentFrequency->second += 1;
    else
      frequencies.insert(pair<char,int>(c,1));
  }

  int difference = 0,
      frequency = frequencies.begin()->second;

  for(map<char,int>::iterator it = next(frequencies.begin(),1);it != frequencies.end();it++){    
    if(frequency != 1 && difference == 0 && (it->second) == 1){
      difference += 1;
    }
    else{
      difference += abs((it->second)-frequency);
    }
  }

  return (difference > 1) ? "NO" : "YES";
}

int main(){
  string s;
  getline(cin, s);
  string result = isValid(s);
  cout << result << "\n";
  return 0;
}
