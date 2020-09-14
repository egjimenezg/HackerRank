// Complete the sortedInsert function below.

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
func sortedInsert(head *DoublyLinkedListNode, data int32) *DoublyLinkedListNode {
  if(head == nil){
    head = &DoublyLinkedListNode{data: data, next: nil, prev: nil}
  }

  var headIterator *DoublyLinkedListNode

  for headIterator = head; (headIterator.next != nil) && (headIterator.data < data) ; headIterator = headIterator.next {}

  node := &DoublyLinkedListNode{data: data}

  if(headIterator.data > node.data && headIterator.prev == nil){
    headIterator.prev = node
    node.next = headIterator
    head = node
  } else if(headIterator.data < node.data) {
    headIterator.next = node
    node.prev = headIterator
  } else {
    node.next = headIterator
    node.prev = headIterator.prev
    headIterator.prev.next = node
    headIterator.prev = node
  }

  return head
}
