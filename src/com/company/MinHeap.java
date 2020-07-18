package com.company;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinHeap
{
  public static void main(String[] args)
  {
    //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    priorityQueue.add(545345);
    priorityQueue.add(90);
    priorityQueue.add(234);
    priorityQueue.add(14);
    priorityQueue.add(7);
    priorityQueue.add(15465);
    priorityQueue.add(63);
    System.out.println(priorityQueue.poll());
    priorityQueue.remove(14);
    System.out.println(priorityQueue.poll());
  }
}
