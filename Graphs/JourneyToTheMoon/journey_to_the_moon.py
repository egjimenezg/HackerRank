import collections
import os
from collections import deque

class Node:
  def __init__(self, value):
    self.neighbors = []
    self.value = value
    self.visited = False

class Graph:
  def __init__(self, n):
    self.adjacency_list = list(map(lambda value: Node(value), range(0,n)))

def count_astronauts(node):
  astronauts = 1
  queue = deque()
  node.visited = True
  queue.append(node)

  while queue:
    u = queue.popleft()

    for neighbor in u.neighbors:
      if neighbor.visited == False:
        neighbor.visited = True
        astronauts += 1
        queue.append(neighbor)

  return astronauts

def journey_to_moon(n, astronaut):
  graph = Graph(n)
  valid_pairs = 0
  astronaut_ids = {id: id for id in range(0, n)}

  for edge in astronaut:
    [u,v] = edge
    graph.adjacency_list[u].neighbors.append(graph.adjacency_list[v])
    graph.adjacency_list[v].neighbors.append(graph.adjacency_list[u])

  for node in graph.adjacency_list:
    if node.visited  == False:
      number_of_neighbors = count_astronauts(node)
      valid_pairs += (number_of_neighbors *  (n - number_of_neighbors))

  return valid_pairs // 2

if __name__ == '__main__':
  fptr = open(os.environ['OUTPUT_PATH'], 'w')
  first_multiple_input = input().rstrip().split()
  n = int(first_multiple_input[0])
  p = int(first_multiple_input[1])
  astronaut = []

  for _ in range(p):
    astronaut.append(list(map(int, input().rstrip().split())))

  result = journey_to_moon(n, astronaut)
  fptr.write(str(result) + '\n')
  fptr.close()
