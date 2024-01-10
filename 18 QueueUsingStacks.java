// Time Complexity: push O(1) pop O(n) peek O(n) empty O(1)
// Space Complexity: O(n)

/* Problem Solution:
Using two stack approach - In this we will be pushing all the elements in one of the 
two stacks and will be using the other stack to pop i.e. we will  insert all the 
elements of stack 1 in stack 2 and then remove element from stack 2 which means it removes 
the element from the front of the queue and returns it.
same thing for getting the front element also. We will be accessing it from 2nd stack 
and for checking whether the queue is empty or not we will check both the stacks.
*/

class MyQueue {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public MyQueue() {
  }
  
  public void insert(int x) {
    stack1.push(x);
  }
  
  public int remove() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        int temp = stack1.pop();
        stack2.push(temp);
      }
    }
    return stack2.pop();
  }
  
  public int peek() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        int temp = stack1.pop();
        stack2.push(temp);
      }
    }
    return stack2.peek();
  }
  
  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
}

/*
Alternative way when Using two stack approach:
// Time complexity: push O(n) pop O(1) peek O(1) empty O(1)
// Space complexity: O(n)
*/

class MyQueue {
  Stack<Integer> s = new Stack<Integer>();
  Stack<Integer> temp = new Stack<Integer>();

  // Push element x to the back of queue.
  public void insert(int x) {
    if (s.isEmpty())
      s.push(x);
    else {
      while (!s.isEmpty())
        temp.push(s.pop());

      s.push(x);

      while (!temp.isEmpty())
        s.push(temp.pop());
    }
    System.out.println(s);
  }
  
  // Removes the element from in front of queue.
  public int remove() {
    System.out.println(s);
    return s.pop();
  }

  
  public int peek() {
    return s.peek();
  }
  
  public boolean empty() {
    return s.isEmpty();
  }
}

/*
Using One stack approach: recursion way 
(peek function not implemented!)
*/
class MyQueue {
  Stack<Integer> s = new Stack<Integer>();

  public void insert(int x) {
    s.push(x);
    System.out.println(s);
  }

  public int remove() {
    int top = s.pop();
    if (s.isEmpty())
      return top;
    else {
      int result = remove();
      s.push(top);
      return result;
    }
  }

  // peek() Function -- 

  public boolean empty() {
    return s.isEmpty();
  }
}

public class Solution {
  public static void main(String[] args) {
    System.out.println("Queue using Stack");
    MyQueue qs = new MyQueue();
    qs.insert(10);
    qs.insert(70);
    qs.insert(40);
    System.out.println("Popped element: " + qs.remove());
    qs.insert(60);
    qs.insert(30);
    System.out.println("Popped element: " + qs.remove());
    System.out.println("Peek element: " + qs.peek());
  }
}

/* OUTPUT:
Queue using Stack
Popped element: 10
Popped element: 70
Peek element: 40
*/
