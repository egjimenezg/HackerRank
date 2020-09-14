import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.lang.StringBuilder;

class Graph<T extends Number /*& Comparable<T>*/> {
  ArrayList<LinkedList<T>> adjacencyList; 
  int[] distances;

  public Graph(Integer n){
    this.adjacencyList = new ArrayList<>();
    distances = new int[n];

    IntStream.rangeClosed(1,n).boxed().forEach( i -> {
      adjacencyList.add(new LinkedList<T>());
      distances[i-1] = -1;
    });
  }

  public void addEdge(T u,T v){
    adjacencyList.get(u.intValue()).add(v);
  } 

  public int[] getDistances(T source){
    Queue<T> queue = new ArrayDeque<>();
    queue.add(source);

    this.distances[source.intValue()] = 0;

    while(!queue.isEmpty()){
      T u = queue.remove();

      LinkedList<T> nodeList = adjacencyList.get(u.intValue());   

      if(!nodeList.isEmpty()){
        for(T node : nodeList){
          if(this.distances[node.intValue()] == -1){
            this.distances[node.intValue()] = distances[u.intValue()]+6;
            queue.add(node);
          }
        }
      }

    }
    
    return this.distances;  
  }

}

public class BSFShortestReachGraph {

  public static void main(String... args){
    Scanner scanner = new Scanner(System.in);
    Integer q,n,m; 

    q = scanner.nextInt();
    
    while((q--) != 0){
      n = scanner.nextInt();
      m = scanner.nextInt();

      Graph<Integer> graph = new Graph<Integer>(n); 
      
      for(Integer i=0;i<m;i++){
        Integer u = scanner.nextInt();
        Integer v = scanner.nextInt();
        graph.addEdge(u-1,v-1);
        graph.addEdge(v-1,u-1);
      }

      Integer s = scanner.nextInt();

      int[] distances = graph.getDistances(s-1);
      StringBuilder output = new StringBuilder();

      for(int i=1;i<= n;i++)
        if(i != s)
          output.append(distances[i-1] + " ");
      
      System.out.println(output.toString().trim());
    }
  }

}

