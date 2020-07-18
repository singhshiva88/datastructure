package com.company;

public class DoubyLinkedListReversal
{
  public static void main(String[] args)
  {
    DoublyLinkedListReversalNode root = new DoublyLinkedListReversalNode(1);
    root.next = new DoublyLinkedListReversalNode(2);
    root.previous = null;

    root.next.next = new DoublyLinkedListReversalNode(3);
    root.next.previous = root;

    root.next.next.next = new DoublyLinkedListReversalNode(4);
    root.next.next.previous = root.next;

    root.next.next.next.previous = root.next.next;

    printList(root);

    DoublyLinkedListReversalNode reversalNode = reverseDoublyLinkedList(root);
    printList(reversalNode);
  }

  private static DoublyLinkedListReversalNode reverseDoublyLinkedList(DoublyLinkedListReversalNode root)
  {
    DoublyLinkedListReversalNode current = root;
    DoublyLinkedListReversalNode previous = null;
    DoublyLinkedListReversalNode next = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      current.previous = next;

      previous = current;
      current = next;
    }

    return previous;
  }

  private static void printList(DoublyLinkedListReversalNode root)
  {
    DoublyLinkedListReversalNode current = root;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }
}
class DoublyLinkedListReversalNode {
  int data;
  DoublyLinkedListReversalNode previous;
  DoublyLinkedListReversalNode next;
  public DoublyLinkedListReversalNode(int data) {
    this.data = data;
  }
}

