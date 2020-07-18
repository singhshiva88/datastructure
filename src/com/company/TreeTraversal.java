package com.company;

public class TreeTraversal
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

    System.out.println("-------------In Order Traversal-------------------");
    printInOrderTraversal(root);
    System.out.println();
    System.out.println("-------------In Pre Traversal-------------------");
    printPreOrderTraversal(root);
    System.out.println();
    System.out.println("-------------In Post Traversal-------------------");
    printPostOrderTraversal(root);
  }

  private static void printPostOrderTraversal(FindIfBTreeIsBSTNode root)
  {
    if(root == null) {
      return;
    }
    printPostOrderTraversal(root.left);
    printPostOrderTraversal(root.right);
    System.out.print(root.data);
  }

  private static void printPreOrderTraversal(FindIfBTreeIsBSTNode root)
  {
    if(root == null) {
      return;
    }
    System.out.print(root.data);
    printPreOrderTraversal(root.left);
    printPreOrderTraversal(root.right);
  }

  private static void printInOrderTraversal(FindIfBTreeIsBSTNode root)
  {
    if(root == null) {
      return;
    }
    printInOrderTraversal(root.left);
    System.out.print(root.data);
    printInOrderTraversal(root.right);
  }
}
