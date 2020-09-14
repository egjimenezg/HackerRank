// Complete the reverse function below.

/*
 * For your reference:
 *
 * DoublyLinkedListNode {
 *     data int32
 *     next *DoublyLinkedListNode
 *     prev *DoublyLinkedListNode
 * }
 *
 */
func reverse(head *DoublyLinkedListNode) *DoublyLinkedListNode {
  if(head == nil){
    head = &DoublyLinkedListNode{data: head.data}
  }

  var headIterator *DoublyLinkedListNode

  for headIterator = head; headIterator.next != nil; headIterator = headIterator.prev {
    next := headIterator.next
    headIterator.next = headIterator.prev
    headIterator.prev = next
  }

  headIterator.next = headIterator.prev
  headIterator.prev = nil

  return headIterator;
}
