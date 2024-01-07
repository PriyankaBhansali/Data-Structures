// Time Complexity: O(1)

public class LinkedList {
  Node last;

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void push(int data) {
    Node p = new Node(data);
    p.next = last;
    last = p;
  }

  public int pop() {
    if (last == null) {
      System.out.println("Stack Underflow/Stack is empty");
      return 0;
    } else {
      int v = last.data;
      last = last.next;
      return v;
    }
  }

  public int peek() {
    if (last == null)
      return -1;
    else {
      return last.data;
    }
  }

  public boolean isEmpty() {
    return last == null;
  }


  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.push(10);
    list.push(20);
    list.push(30);
    System.out.println(list.pop() + " popped from stack"); // 30 popped from stack
    System.out.println("Top element is " + list.peek()); // Top element is 20
  }
}