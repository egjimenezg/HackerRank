#!/bin/python3

import math
import os
import random
import re
import sys

def maxMin(k, arr):
    arr.sort()
    minUnfairness = 10e7
    if len(arr) < k:
        return arr[-1] - arr[0]
    
    for idx, number in enumerate(arr):
        if (idx + k - 1) < len(arr):
            minUnfairness = min(minUnfairness, abs(arr[idx + k - 1] - number))
    return minUnfairness

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    n = int(input().strip())
    k = int(input().strip())
    arr = []

    for _ in range(n):
        arr_item = int(input().strip())
        arr.append(arr_item)

    result = maxMin(k, arr)
    fptr.write(str(result) + '\n')
    fptr.close()
