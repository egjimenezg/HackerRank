#include <stdio.h>

using namespace std;

// Complete the stepPerms function below.
int stepPerms(int n, int* memory) {
  if(n == 1 || n == 0)
    return memory[n];
  else if(memory[n] != 0)
    return memory[n];
  else{
    int step = 1;
    int perms = 0;

    while((n-step >= 0) && step <= 3){
      perms +=  stepPerms(n-step,memory);
      step++;
    }

    memory[n] = perms;
    return memory[n];
  }
}

int main(){
  int s, n;
  scanf("%d", &s);

  while(s--){
    scanf("%d", &n);
    int *memory = new int[n+1];
    memory[0] = 1;
    memory[1] = 1;
    printf("%d\n",stepPerms(n,memory));
  }

  return 0;
}
