import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

class Vertex {
  int weight;
  int label;

  public Vertex(int label, int weight){
    this.label = label;
    this.weight = weight;
  }
}

class Graph {

  ArrayList<HashMap<Integer, Vertex>> adjacencyList;
  private int size;

  public Graph(int size){
    adjacencyList = new ArrayList<HashMap<Integer, Vertex>>();
    this.size = size;

    IntStream.range(0, size).boxed().forEach( i -> {
      adjacencyList.add(new HashMap<Integer, Vertex>());
    });
  }

  public void addEdge(int u, int v, int weight){
    if(adjacencyList.get(u).containsKey(v)){
      if(adjacencyList.get(u).get(v).weight > weight){
        adjacencyList.get(u).put(v, new Vertex(v, weight));
      }
    } else {
      adjacencyList.get(u).put(v, new Vertex(v, weight));
    }
  }

  public int[] dijkstra(int source){
    int[] distances = new int[this.size];
    int[] visited = new int[this.size];

    Arrays.fill(distances, Integer.MAX_VALUE);
    Arrays.fill(visited, -1);
    distances[source] = 0;

    PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(
      new Comparator<Vertex>(){
        @Override
        public int compare(Vertex v1, Vertex v2){
          if(v1.weight == v2.weight){
            return v1.label - v2.label;
          }
          return v1.weight - v2.weight;
        }
      }
    );

    queue.add(new Vertex(source, 0));

    while(!queue.isEmpty()){
      Vertex u = queue.poll();
      visited[u.label] = distances[u.label];

      if(u.weight <= distances[u.label]){
        for(Vertex v : adjacencyList.get(u.label).values()){
          if(visited[v.label] == -1){
            if(distances[u.label]+v.weight < distances[v.label]){
              distances[v.label] = distances[u.label]+v.weight;
              queue.add(new Vertex(v.label, distances[v.label]));
            }
          }
        }
      }
    }

    return visited;
  }
}

class Reader {

  BufferedReader bufferedReader;
  StringTokenizer stringTokenizer;
  
  public Reader(){
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }

  String nextToken(){
    while(stringTokenizer == null || !stringTokenizer.hasMoreElements()){
      try {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      }
      catch(IOException exception){
        exception.printStackTrace();
      }
    }

    return stringTokenizer.nextToken();
  }

  int nextInt() {
    return Integer.parseInt(nextToken());
  }
}

public class Dijkstra {
  
  private static final Reader reader = new Reader();
  private static final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String... args){
    int cases = reader.nextInt();
    int nodes, edges;

    while(cases-- > 0){
      nodes = reader.nextInt();
      edges = reader.nextInt();

      Graph graph = new Graph(nodes);

      for(int edge=0; edge<edges; edge++){
        int u = reader.nextInt();
        int v = reader.nextInt();
        int weight = reader.nextInt();

        graph.addEdge(u-1, v-1, weight);
        graph.addEdge(v-1, u-1, weight);
      }

      int source = reader.nextInt();
      int[] distances = graph.dijkstra(source-1);
      
      for(int i=0; i<distances.length; i++){
        if(i != source-1){
          printWriter.print(distances[i] + " ");
        }
      }
      printWriter.println(); 
    }
    printWriter.close();
  }

}
