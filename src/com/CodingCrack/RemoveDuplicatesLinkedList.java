package com.CodingCrack;

public class RemoveDuplicatesLinkedList
{
  public static void main(String[] args)
  {
    // create linked list
    LinkedListNode head = new LinkedListNode(1);
    head.next = new LinkedListNode(1);
    head.next.next = new LinkedListNode(1);
    head.next.next.next = new LinkedListNode(1);
    head.next.next.next.next = new LinkedListNode(4);
    head.next.next.next.next.next = new LinkedListNode(3);
    deleteDuplicates(head);
  }

  private static void deleteDuplicates(LinkedListNode head)
  {
    if (head == null || head.next == null)
    {
      return;
    }
    LinkedListNode previous = head;
    LinkedListNode current = head.next;
    while (current != null)
    {
      LinkedListNode runner = head;
      while (runner != current)
      {
        if (runner.data == current.data)
        {
          // remove current
          LinkedListNode tmp = current.next;
          previous.next = tmp;
          current = tmp;
          break;
        }
        runner = runner.next;
      }
      if (runner == current)
      {
        previous = current;
        current = current.next;
      }
    }
  }
}
