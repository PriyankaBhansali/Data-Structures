// Time Complexity: O(1)
// Space Complexity: O(1)

class Stack {
  static final int MAX = 1000;
  int top;
  int a[] = new int[MAX]; // Maximum size of Stack

  Stack() {
    top = -1;
  }

  boolean isEmpty() {
    return top == -1;
  }
  
  boolean push(int x) {
    if (top == MAX - 1) {
      System.out.println("Stack Overflow/Stack is full");
      return false;
    } else {
      a[++top] = x;
      return true;
    }
  }
  
  int pop() {
    if (top == -1) {
      System.out.println("Stack Underflow/Stack is empty");
      return 0;
    } else {
      return a[top--];
    }
  }
  
  int peek() {
    return a[top];
  }
} 


// difference in constructor initialization and slight modification in push function
class Stack {
  int top = -1;
  int a[];

  Stack() {
    a = new int[5];
  }

  Stack(int n) {
    a = new int[n];
  }

  void display() {
    for (int i = 0; i <= top; i++) {
      System.out.println(a[i]);
    }
  }
  
  boolean push(int x) {
    if (top == a.length - 1) { // check array length
      System.out.println("Stack Overflow/Stack is full");
      return false;
    } else {
      a[++top] = x;
      return true;
    }
  }
}

public class Solution {
  public static void main(String args[]) {
    Stack s = new Stack();
    s.push(10);
    s.push(20);
    s.push(30);
    System.out.println("Top of the stack: " + s.peek());
    System.out.println("Popped from stack: " + s.pop());
  }
}

/* OUTPUT:
Top of the stack: 30
Popped from stack: 30
*/