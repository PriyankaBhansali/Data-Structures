// Time complexity: O(1)

public class LinkedList {
  Node rear;
  Node front;

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void add(int data) {
    Node p = new Node(data);
    if (front == null) {
      front = p;
      rear = p;
    } else {
      rear.next = p;
      rear = p;
    }
  }

  public int remove() {
    int v = front.data;
    front = front.next;
    if (front == null) {
      rear = null;
    }
    return v;
  }

  public int peek() {
    if (front == null)
      return -1;
    else {
      return front.data;
    }
  }

  public boolean isEmpty() {
    return front == null;
  }


  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list.remove() + " removed from queue"); // 10 removed from queue
    System.out.println("Top element is " + list.peek()); // Top element is 20
  }
}