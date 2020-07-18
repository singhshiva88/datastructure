package com.CodingCrack;

public class NthToLastElementLinkedList
{
  public static void main(String[] args)
  {
    int n = 3;
    // create linked list
    LinkedListNode head = new LinkedListNode(1);
    head.next = new LinkedListNode(2);
    head.next.next = new LinkedListNode(3);
    head.next.next.next = new LinkedListNode(4);
    head.next.next.next.next = new LinkedListNode(5);
    head.next.next.next.next.next = new LinkedListNode(6);
    LinkedListNode current = head;
    LinkedListNode nthMinus1 = null;
    int i = 0;
    while (current != null)
    {
      if (i == 4)
      {
        nthMinus1 = head;
      }
      if (nthMinus1 != null)
      {
        nthMinus1 = nthMinus1.next;
      }
      current = current.next;
      i++;
    }
    // now we know which node to remove
    LinkedListNode nodetoDelete = nthMinus1.next;
    nthMinus1.next = nodetoDelete.next;
    nodetoDelete.next = null;
  }
}
