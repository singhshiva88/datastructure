package com.company;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeDifferentViews
{
  public static void main(String[] args)
  {
    FindIfBTreeIsBSTNode root = new FindIfBTreeIsBSTNode(5);
    root.left = new FindIfBTreeIsBSTNode(3);
    root.right = new FindIfBTreeIsBSTNode(6);

    root.left.left = new FindIfBTreeIsBSTNode(1);
    root.left.right = new FindIfBTreeIsBSTNode(4);

    root.right.left = new FindIfBTreeIsBSTNode(5);
    root.right.right = new FindIfBTreeIsBSTNode(8);

    root.left.left.left = new FindIfBTreeIsBSTNode(0);
    root.left.left.right = new FindIfBTreeIsBSTNode(2);

    root.right.right.left = new FindIfBTreeIsBSTNode(7);
    root.right.right.right = new FindIfBTreeIsBSTNode(9);
    printTopView(root);
    printRightView(root);
    printLeftView(root);

  }

  private static void printLeftView(FindIfBTreeIsBSTNode root)
  {
    System.out.println("\nRight View");
    Queue<QueueForTreeView> q = new LinkedBlockingQueue();
    q.add(new QueueForTreeView(root, 0));

    while (!q.isEmpty())
    {
      int n = q.size();
      for (int i = 1; i <= n; i++)
      {
        QueueForTreeView currentNode = q.poll();
        if (i == n)
        {
          System.out.print(currentNode.node.data);
        }
        if (currentNode.node.right != null)
        {
          q.add(new QueueForTreeView(currentNode.node.right, 0));
        }
        if (currentNode.node.left != null)
        {
          q.add(new QueueForTreeView(currentNode.node.left, 0));
        }
      }
    }
  }

  private static void printRightView(FindIfBTreeIsBSTNode root)
  {
    System.out.println("\nRight View");
    Queue<QueueForTreeView> q = new LinkedBlockingQueue();
    q.add(new QueueForTreeView(root, 0));

    while (!q.isEmpty())
    {
      int n = q.size();
      for (int i = 1; i <= n; i++)
      {
        QueueForTreeView currentNode = q.poll();
        if (i == n)
        {
          System.out.print(currentNode.node.data);
        }
        if (currentNode.node.left != null)
        {
          q.add(new QueueForTreeView(currentNode.node.left, 0));
        }
        if (currentNode.node.right != null)
        {
          q.add(new QueueForTreeView(currentNode.node.right, 0));
        }
      }
    }
  }

  private static void printTopView(FindIfBTreeIsBSTNode root)
  {
    System.out.println("Top View");
    Queue<QueueForTreeView> q = new LinkedBlockingQueue();
    int i = 0;
    q.add(new QueueForTreeView(root, i));
    Map<Integer, FindIfBTreeIsBSTNode> map = new HashMap<>();
    map.put(i, root);
    while (!q.isEmpty())
    {
      QueueForTreeView queueForTreeView = q.poll();
      if (map.get(queueForTreeView.height) == null)
      {
        map.put(queueForTreeView.height, queueForTreeView.node);
      }
      if (queueForTreeView.node.left != null)
      {
        q.add(new QueueForTreeView(queueForTreeView.node.left, queueForTreeView.height - 1));
      }
      if (queueForTreeView.node.right != null)
      {
        q.add(new QueueForTreeView(queueForTreeView.node.right, queueForTreeView.height + 1));
      }
    }
    for (Map.Entry<Integer, FindIfBTreeIsBSTNode> entry : map.entrySet())
    {
      System.out.print(entry.getValue().data);
    }
  }
}

class QueueForTreeView
{
  FindIfBTreeIsBSTNode node;
  int height;

  public QueueForTreeView(FindIfBTreeIsBSTNode node, int height)
  {
    this.node = node;
    this.height = height;
  }
}
