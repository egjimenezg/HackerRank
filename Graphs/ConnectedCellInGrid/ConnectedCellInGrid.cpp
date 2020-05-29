#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <stack>

using namespace std;

typedef struct Point {
  int x;
  int y;
} Point;

int DFS(int**,stack<Point>,int,int);

int main(){
  int n, m;
  int largestRegion = 0;

  scanf("%d",&n);
  scanf("%d",&m);

  int** grid = new int*[n];
  stack<Point> graphStack;

  for(int i=0;i<n;i++){
    grid[i] = new int[m];
  }

  for(int i=0;i<n;i++)
    for(int j=0;j<m;j++)
      scanf("%d",&grid[i][j]);

  for(int row=0;row<n;row++){
    for(int col=0;col<m;col++){
      if(grid[row][col] == 1){
        Point source = {.x = row, .y = col};
        grid[row][col] = 2;
        graphStack.push(source);
        largestRegion = max(largestRegion, DFS(grid,graphStack, n, m));
      }
    }
  }

  printf("%d\n", largestRegion);
}

//Returns the number of items in the section
int DFS(int** grid, stack<Point> graphStack, int n, int m){
  int items = 1;

  while(!graphStack.empty()){
    Point point = graphStack.top();
    graphStack.pop();

    for(int i=-1;i<=1;i++){
      for(int j=-1;j<=1;j++){
        if((point.x+i >= 0 && point.x+i < n) &&
           (point.y+j >= 0 && point.y+j < m)){
          if(grid[point.x+i][point.y+j] == 1){
            Point neighbor = {.x = point.x+i, .y = point.y+j};

            grid[neighbor.x][neighbor.y] = 2;
            graphStack.push(neighbor);
            items++;
          }
        }
      }
    }
  }

  return items;
}
