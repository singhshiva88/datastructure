package com.company;

public class FindIfBTreeIsBST
{
  public static void main(String[] args)
  {
    FindIfBTreeIsBSTNode root = new FindIfBTreeIsBSTNode(5);
    root.left = new FindIfBTreeIsBSTNode(3);
    root.right = new FindIfBTreeIsBSTNode(6);

    root.left.left = new FindIfBTreeIsBSTNode(1);
    root.left.right = new FindIfBTreeIsBSTNode(4);


    //root.right.left = new FindIfBTreeIsBSTNode(5);
    root.right.right = new FindIfBTreeIsBSTNode(8);

    root.left.left.left = new FindIfBTreeIsBSTNode(0);
    root.left.left.right = new FindIfBTreeIsBSTNode(2);

    root.right.right.left = new FindIfBTreeIsBSTNode(7);
    root.right.right.right = new FindIfBTreeIsBSTNode(9);

    System.out.println(findIfBst(root, null));
  }

  private static boolean findIfBst(FindIfBTreeIsBSTNode node, FindIfBTreeIsBSTNode previous)
  {
    if (node == null)
    {
      return true;
    }

    if (node.left != null && node.right == null)
    {
      return (node.data > node.left.data) && (node.data < previous.data) && findIfBst(node.left, node);
    }
    if (node.left == null && node.right != null)
    {
      return (node.data < node.right.data) && (node.data > previous.data) && findIfBst(node.right, node);
    }

    if (node.left == null && node.right == null)
    {
      return true;
    }

    return (node.data > node.left.data && node.data < node.right.data) && findIfBst(node.left, node) && findIfBst(node.right, node);
  }
}

class FindIfBTreeIsBSTNode
{
  int data;
  FindIfBTreeIsBSTNode left;
  FindIfBTreeIsBSTNode right;

  public FindIfBTreeIsBSTNode(int data)
  {
    this.data = data;
  }
}
