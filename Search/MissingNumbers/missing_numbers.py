import os

def binary_search(array, value):
  left = 0
  right = len(array) - 1

  while left <= right:
    middle = (left + right) // 2

    if array[middle] == value:
      return middle;

    if array[middle] < value:
      left = middle + 1;
    else:
      right = middle - 1;

  return -1;


def missingNumbers(array, brr):
  array.sort()
  missing_numbers = set([])

  for number in brr:
    number_idx = binary_search(array, number)

    if number_idx == -1:
      missing_numbers.add(number)
    else:
       array.pop(number_idx)

  missing_numbers = list(missing_numbers)
  missing_numbers.sort()

  return missing_numbers

if __name__ == "__main__":
  fptr = open(os.environ['OUTPUT_PATH'], 'w')
  n = int(input().strip())
  arr = list(map(int, input().rstrip().split()))
  m = int(input().strip())
  brr = list(map(int, input().rstrip().split()))
  result = missingNumbers(arr, brr)
  fptr.write(' '.join(map(str, result)))
  fptr.write('\n')
  fptr.close()

