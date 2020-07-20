from collections import deque

class Rectangle:

  def __init__(self, height):
    self.width = 1
    self.height = height

def largest_rectangle(heights):
  stack = deque()
  max_area = 0

  for h in heights:
    if(len(stack) > 0 and stack[-1].height >= h):
      if(stack[-1].height == h):
        stack[-1].width += 1
      else:
        rectangle = Rectangle(h)
        width = 0

        while(len(stack) > 0 and stack[-1].height >= h):
          width += stack[-1].width
          max_area = max(max_area, stack.pop().height*width)

        rectangle.width += width
        stack.append(rectangle)
    else:
      stack.append(Rectangle(h))

  width = 0 

  while(len(stack) > 0):
    rectangle = stack.pop()
    width += rectangle.width
    max_area = max(max_area, rectangle.height*width)

  return max_area

if __name__ == "__main__":
  input()
  heights = list(map(int, input().rstrip().split()))
  max_area = largest_rectangle(heights)
  print(max_area)
