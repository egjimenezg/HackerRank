#include <limits.h>
#include <stdio.h>

unsigned int flippingBits(unsigned int n) {
  return n^UINT_MAX;
}

int main() {
  int q;
  unsigned int n, result;
    
  scanf("%d",&q);
    
  while(q--){
    scanf("%u", &n);
    result = flippingBits(n);
    printf("%u\n", result);
  }

  return 0;
}
