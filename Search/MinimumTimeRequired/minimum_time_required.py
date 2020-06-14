#!/bin/python3
import math

def get_frequencies(times):
  frequencies = {}

  for time in times:
    frequencies[time] = frequencies.get(time,0)+1

  return frequencies

def produced_items(days, frequencies):
  produced_items = 0

  for item in frequencies.keys():
    produced_items += (days//item)*frequencies[item]

  return (produced_items)

# O(n * lg(n))
def search_min_days(goal, frequencies, low, high):
  min_days = 0

  while low <= high:
    days = (low+high) // 2

    # O(n)
    items = produced_items(days, frequencies)

    if items >= goal:
      min_days = days
      high = days-1
    elif items < goal:
      low = days+1 
    else: 
      high = days-1

  return min_days

def minimum_time(times, goal):
  frequencies = get_frequencies(times)
  sorted_times = list(map(int,frequencies.keys())) 
  sorted_times.sort() # O(nlg(n))

  items_per_machine = math.ceil(goal/len(times))

  low = items_per_machine*sorted_times[0]
  high = items_per_machine*sorted_times[-1]

  if low == high:
    return low

  return search_min_days(goal,frequencies,low, high)

def main():
  goal = input().split()
  times = list(map(int,input().split()))
  print(minimum_time(times, int(goal[1])))
  
if __name__ == "__main__":
  main()
