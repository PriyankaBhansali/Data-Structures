// Time Complexity: O(1)
// Space Complexity: O(1)

import java.util.*;
class Queue {
  int front = -1;
  int rear = -1;
  int a[];

  public Queue() {
    a = new int[5];
  }

  public Queue(int n) {
    a = new int[n];
  }

  public boolean isEmpty() {
    return (front == -1 && rear == -1);
  }

  void add(int v) {
    if ((rear + 1) % a.length == front) {
      System.out.println("Queue is Full");
    } else if (isEmpty()) {
      front++;
      rear++;
      a[rear] = v;
    } else {
      rear = (rear + 1) % a.length;
      a[rear] = v;
    }
  }

  int remove() {
    int v = 0; // needs initialization
    if (isEmpty()) {
      System.out.println("Queue is Empty");
    } else if (rear == front) {
      v = a[front];
      front = -1;
      rear = -1;
    } else {
      v = a[front];
      front = (front + 1) % a.length;		
    }
    return v;
  }

  public String toString() {
    return "Queue (front = " + front + ", rear = " + rear + ", size = " + a.length + ", queue = " + Arrays.toString(a) + ")";
  }
}

public class Solution {
  public static void main(String[] args) {
    Queue queue = new Queue(6);
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.add(40);
    queue.add(50);
    System.out.println(queue.toString());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.toString());
    queue.add(60);
    queue.add(70);
    System.out.println(queue.toString());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    queue.add(80);
    System.out.println(queue.remove());
    System.out.println(queue.toString());
  }
}

/* OUTPUT:
Queue (front = 0, rear = 4, size = 6, queue = [10, 20, 30, 40, 50, 0])
10
20
Queue (front = 2, rear = 4, size = 6, queue = [10, 20, 30, 40, 50, 0])
Queue (front = 2, rear = 0, size = 6, queue = [70, 20, 30, 40, 50, 60])
30
40
50
60
70
Queue (front = 1, rear = 1, size = 6, queue = [70, 80, 30, 40, 50, 60])
*/