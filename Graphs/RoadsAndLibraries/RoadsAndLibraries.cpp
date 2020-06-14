#include <stdio.h>
#include <vector>

using namespace std;

class DisjointSet{
  private:
    vector<int> parents;
    vector<int> ranks;
    long roads;

  public:
    DisjointSet(int n){
      parents.resize(n);
      ranks.resize(n);
      roads = 0;

      for(int i=0;i<n;i++){
        parents[i] = i;
        ranks[i] = 0;
      }
    }

    int findParent(int i){
      if(parents[i] == i)
          return i;
      
      parents[i] = findParent(parents[i]);
      return parents[i];
    }

    bool isSameSet(int i,int j){
      return findParent(i) == findParent(j);
    }

    void unionSet(int i,int j){
      if(!isSameSet(i,j)){
        int parentLeft = findParent(i);
        int parentRight = findParent(j);
        roads++;

        if(ranks[parentLeft] > ranks[parentRight]){
          parents[parentRight] = parentLeft;
        }
        else {
          parents[parentLeft] = parentRight;
          
          if(ranks[parentLeft] == ranks[parentRight]){
            ranks[parentRight]++;
          }
        }
      }
    }

    long getRoads(){
      return this->roads;
    }

    long getLibraries(){
      long libraries = 0;
      for(int i=0;i<parents.size();i++){
        if(parents[i] == i){
          libraries++;
        }
      }
      return libraries;
    }

};

// Complete the roadsAndLibraries function below.
long roadsAndLibraries(int n, long c_lib, long c_road, vector<vector<int> > cities) {
  if(!cities.size())
    return c_lib*n;

  DisjointSet set(n);

  for(vector<int> edge : cities){
    int u = edge[0]-1,v = edge[1]-1;
    set.unionSet(u,v);
  }
 
  long minimumCost = ((set.getRoads()*c_road) + (set.getLibraries()*c_lib));

  return (minimumCost < (n * c_lib)) ? minimumCost : (long)(n * c_lib);
}

int main() {
  int q;
  int n, m, c_lib, c_road;

  scanf("%d",&q);

  while(q--){
    scanf("%d %d %d %d", &n, &m, &c_lib, &c_road);

    vector<vector<int> > cities(m);

    for(int i=0; i<m; i++){
      cities[i].resize(2);
      scanf("%d %d", &cities[i][0], &cities[i][1]);
    }

    long result = roadsAndLibraries(n, c_lib, c_road, cities);
    printf("%ld\n", result);
  }

  return 0;
}

