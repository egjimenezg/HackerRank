"""class Node:
    def __init__(self, freq,data):
        self.freq= freq
        self.data=data
        self.left = None
        self.right = None
"""        

def decodeChar(root, s):
  if(root.left == None and root.right == None):
    print(root.data, end = '')
    return s
  
  if(s[0] == "1"):
    return decodeChar(root.right, s[1:len(s)])
  elif(s[0] == "0"):
    return decodeChar(root.left, s[1:len(s)])

# Enter your code here. Read input from STDIN. Print output to STDOUT
def decodeHuff(root, s):
  if s == "":
    return

  s = decodeChar(root, s)
  decodeHuff(root, s)

