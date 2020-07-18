package com.company;

public class LinkedListReversal
{
  public static void main(String[] args)
  {
    LinkedListReversalNode head = new LinkedListReversalNode(1);
    head.next = new LinkedListReversalNode(2);
    head.next.next = new LinkedListReversalNode(3);
    head.next.next.next = new LinkedListReversalNode(4);
    head.next.next.next.next = new LinkedListReversalNode(5);
    head.next.next.next.next.next = new LinkedListReversalNode(6);
    head.next.next.next.next.next.next = new LinkedListReversalNode(7);
    head.next.next.next.next.next.next.next = new LinkedListReversalNode(8);
    head.next.next.next.next.next.next.next.next = new LinkedListReversalNode(9);
    printList(head);
    LinkedListReversalNode newHead = reverseLinkedList(head);
    printList(newHead);
  }

  private static LinkedListReversalNode reverseLinkedList(LinkedListReversalNode node)
  {
    if (node == null)
    {
      return null;
    }
    LinkedListReversalNode next = null;
    LinkedListReversalNode current = node;
    LinkedListReversalNode prev = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  private static void printList(LinkedListReversalNode node)
  {
    if (node == null)
    {
      return;
    }
    System.out.print("-> " + node.data);
    printList(node.next);
  }
}

class LinkedListReversalNode
{
  int data;
  LinkedListReversalNode next;

  public LinkedListReversalNode(int data)
  {
    this.data = data;
  }
}