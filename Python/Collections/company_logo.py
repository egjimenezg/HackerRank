#!/bin/python3

import math
import os
import random
import re
import sys
from collections import Counter

if __name__ == '__main__':
    s = input()
    frequencies = Counter(list(s))
    character_frequencies  = [(c, frequency) for c, frequency in frequencies.items()]
    def sort_by_char_and_frequency(character_and_frequency):
        return (-character_and_frequency[1], character_and_frequency[0])
    character_frequencies = sorted(character_frequencies, key=sort_by_char_and_frequency)

    for c, frequency in character_frequencies[:3]:
        print(f"{c} {frequency}")
