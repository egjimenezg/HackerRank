#!/bin/python3

import math
import os
import random
import re
import sys

def camelcase(s):
    camel_case_str = list(s)
    number_of_strings = 0
    for c in camel_case_str:
        if ord(c) <= 90 and ord(c) >= 65:
            number_of_strings += 1
            
    return number_of_strings + 1

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    s = input()
    result = camelcase(s)
    fptr.write(str(result) + '\n')
    fptr.close()
