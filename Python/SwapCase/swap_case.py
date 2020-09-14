def swap_case(s):
  swapped_string = ""

  for c in s:
    if ord(c) >= ord('A') and ord(c) <= ord('Z'):
      swapped_string += chr(ord(c)+32)
    elif ord(c) >= ord('a') and ord(c) <= ord('z'):
      swapped_string += chr(ord(c)-32);
    else:
      swapped_string += c;

  return swapped_string

if __name__ == "__main__":
  s = input()
  print(swap_case(s))
