#!/bin/python3

def ways(value, coins, memory):
  if(len(coins) == 0):
    return 0

  if(value < 0):
    return 0

  if(value == 0):
    return 1

  if(memory[len(coins)-1][value-1] != 0):
    return memory[len(coins)-1][value-1]

  memory[len(coins)-1][value-1] = ways(value, coins[1:len(coins)], memory) + ways(value-coins[0], coins, memory)

  return memory[len(coins)-1][value-1]

def create_memory_matrix(rows, cols):
  matrix = []
  for row in range(rows):
    matrix.append([])
    for col in range(cols):
      matrix[row].append(0)
  return matrix

if __name__ == "__main__":
  value = int(input().split()[0])
  coins = list(map(int, input().rstrip().split()))
  memory = create_memory_matrix(len(coins), value)
  answer = ways(value, coins, memory)
  print(answer)

