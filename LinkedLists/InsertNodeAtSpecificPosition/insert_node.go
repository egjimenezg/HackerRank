// Complete the insertNodeAtPosition function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     data int32
 *     next *SinglyLinkedListNode
 * }
 *
 */
func insertNodeAtPosition(head *SinglyLinkedListNode, data int32, position int32) *SinglyLinkedListNode {
  if(head == nil){
    head = &SinglyLinkedListNode{next: nil, data: data}
  } else {
    headIterator := head
    node := &SinglyLinkedListNode{next: nil, data: data}

    for ;(headIterator.next != nil && position-1 > 0); position-- {
      headIterator = headIterator.next
    }

    node.next = headIterator.next
    headIterator.next = node
  }

  return head
}

