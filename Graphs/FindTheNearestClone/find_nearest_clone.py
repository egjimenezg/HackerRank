import collections

class Node:

  def __init__(self):
    self.neighbors = []
    self.visited = 0
    self.distance = 0
  
  def set_color(self, color):
    self.color = color

class Graph:

  def __init__(self, n):
    self.adjacencyList = list(map(lambda x: Node(), range(0,n)))

  def find_nearest_clone(self, color):
    min_distance = -1
    
    # O(n)
    for node in self.adjacencyList:
      if node.color == color and node.visited == 0:
        min_distance = self.get_min_distance(node, node.color)

    return min_distance

  # O(V+E)
  def get_min_distance(self, s, color):
    min_distance=-1
    current_distance=0
    s.visited=1

    queue = collections.deque()
    queue.append(s)

    while len(queue) > 0:
      u = queue.popleft() 

      for node in u.neighbors:
        if node.visited == 0:
          node.visited = 1
          node.distance = u.distance+1
          queue.append(node)

          if node.color == color:
            if min_distance == -1:
              min_distance = node.distance

            min_distance = min(min_distance, node.distance)
            node.distance = 0

    return min_distance

def main():
  nodes_number, edges = list(map(int, input().split()))
  graph = Graph(nodes_number)

  for edge in range(0, edges):
    u, v = list(map(int, input().split()))
    graph.adjacencyList[u-1].neighbors.append(graph.adjacencyList[v-1])
    graph.adjacencyList[v-1].neighbors.append(graph.adjacencyList[u-1])

  node_ids = list(map(int, input().split()))

  for node in range(len(node_ids)):
    graph.adjacencyList[node].set_color(node_ids[node])

  color = int(input())
  
  distance = graph.find_nearest_clone(color)
  print(distance)
    
if __name__ == "__main__":
  main()
