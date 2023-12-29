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

  boolean isFull() {
    if (front == 0 && rear == a.length - 1) {
      return true;
    }
    return false;
  }

  boolean isEmpty() {
    if (front == -1) {
      return true;
    } else {
      return false;
    }
  }

  void add(int element) {
    if (isFull()) {
      System.out.println("Queue is full");
    } else {
      if (front == -1) {
        front = 0;
      }
      rear++;
      a[rear] = element;
      System.out.println("Inserted " + element);
    }
  }

  int remove() {
    int element;
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return (-1);
    } else {
      element = a[front];
      if (front >= rear) { // Queue has only one element, so we reset the queue after deleting it
        front = -1;
        rear = -1;
      } else {
        front++;
      }
      System.out.println("Deleted -> " + element);
      return (element);
    }
  }

  void display() {
    if (isEmpty()) {
      System.out.println("Empty Queue");
    } else {
      System.out.println("\nFront index-> " + front);
      System.out.println("Array -> ");
      for (int i = front; i <= rear; i++) {
        System.out.print(a[i] + "  ");
      }

      System.out.println("\nRear index-> " + rear);
    }
  }
}

public class Solution {
  public static void main(String[] args) {
    Queue queue = new Queue(5);
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.add(40);
    queue.add(50);
    queue.display();
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    queue.display();
    queue.add(60); // throws error
    queue.display();
  }
}

/* OUTPUT:
Inserted 10
Inserted 20
Inserted 30
Inserted 40
Inserted 50

Front index-> 0
Array -> 
10  20  30  40  50
Rear index-> 4
Deleted -> 10
10
Deleted -> 20
20

Front index-> 2
Array ->
30  40  50
Rear index-> 4

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
	at Queue.add(Solution.java:36)
	at Solution.main(Solution.java:86)
*/