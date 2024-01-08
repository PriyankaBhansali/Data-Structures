// Time Complexity: push O(n) pop O(1) peek O(1) empty O(1)
// Space Complexity: O(n)

import java.util.*;

// USING TWO QUEUES
class MyStack {
  Queue<Integer> q1;
  Queue<Integer> q2;

  // Constructor initializes two queues
  public MyStack() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }

  // Add a new element by pushing it onto q2 first (Linked list has it own add, remove .. functions)
  // then move all elements from q1 to q2
  // Move all elements from q2 back to q1 to maintain the order
  public void push(int x) {
    q2.add(x);

    while (!q1.isEmpty()) {
      q2.add(q1.remove());
    }

    while (!q2.isEmpty()) {
      q1.add(q2.remove());
    }
  }

  // Remove the top element from q1
  public int pop() {
    return q1.remove();
  }

  // Return the top element from q1 without removing it
  public int top() {
    return q1.peek();
  }

  // Check if both queues are empty, meaning the stack is empty
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }
}

// USING ONE QUEUE
class MyStack1 {
  LinkedList<Integer> q1 = new LinkedList<>();

  // Push element x onto stack.
  public void push(int x) {
    q1.add(x);
    int size = q1.size();
    while (size > 1) {
      q1.add(q1.remove());
      size--;
    }
  }

  public int pop() {
    return q1.remove();
  }

  public boolean empty() {
    return q1.isEmpty();
  }

  public int top() {
    return q1.peek();
  }
}