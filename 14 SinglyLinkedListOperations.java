class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

class LL {
  Node head;

  // add elements to the list
  void add(int v) {
    Node p = new Node(v);

    if (head == null)
      head = p;
    else {
      Node q = head;
      while (q.next != null) {
        q = q.next;
      }
      q.next = p;
    }
  }

  // display elements in the list
  void display() {
    System.out.print("List: ");
    Node q = head;
    while (q != null) {
      System.out.print(q.data + "  ");
      q = q.next;
    }
    System.out.println();
  }

  // count the nodes in list or to find the Nth node
  int count() {
    Node p = head;
    int count = 0;
    while (p != null) {
      count++;
      p = p.next;
    }
    return count;
  }

  // count the number of times a given int/number occurs in the list
  void count(int v) {
    Node p = head;
    int count = 0;
    while (p != null) {
      if (p.data == v) {
        count++;
      }
      p = p.next;
    }
    System.out.println("Count of " + v + " is: " + count);
  }

  // largest element in the list
  int max() {
    Node p = head;
    int largest = p.data; // It will throw an error when p.data is null because return type of max() is int type

    while (p != null) {
      if (p.data > largest) {
        largest = p.data;
      }
      p = p.next;
    }
    return largest;
  }

  // add element at the beginning of the list
  void addB(int v) {
    Node p = new Node(v);
    p.next = head;
    head = p;
  }

  // insert an element at a given position. If position does not exist, insert at the end
  void addE(int v, int pos) {
    Node p = new Node(v);
    int c = 1;
    Node q = head;
    // or
    // int c = 0;
    // Node q = null;

    if (pos == 1) { // position starts with count 1 in list
      p.next = head;
      head = p;
    }
    // else {
    // c = 1;
    // q = head;
    //}

    while (c != pos - 1 && q.next != null) {
      q = q.next;
      c++;
    }
    p.next = q.next;
    q.next = p;
  }

  // delete an element from the list
  void delete(int v) {
    Node q = head;
    Node prev = null;
    while (q != null) {
      if (v == q.data) {
        break;
      }
      prev = q;
      q = q.next;
    }
    if (q == null)
      System.out.println("Element does not exist");
    else if (q == head) // to delete 1st element
      head = q.next;
    else
      prev.next = q.next;
  }

  /* Given only a pointer/reference to a node to be deleted in a singly linked
  list, how do you delete it?
  --> A simple solution is to traverse the linked list until you find the
  node you want to delete. But this solution requires pointer to the head
  node which contradicts the problem statement.
  
  Fast solution is to copy the data from the next node to the node to be
  deleted and delete the next node.
  */
  void deleteNode(Node v) {
    Node p = v.next;
    v.data = p.data;
    v.next = p.next;
    p = null;
  }

  /* Write a function to delete a Linked List
  In Java, automatic garbage collection happens, so deleting a linked list is easy.
  We just need to change head to null.
  */

  void deleteList() {
    head = null;
  }

  /* To print the middle of a given linked list
  Method 1:
  Traverse the whole linked list and count the no. of nodes. Now traverse
  the list again till count/2 and return the node at count/2.

  Method 2:
  Traverse linked list using two pointers (fast and slow pointers).
  Move one pointer by one and other pointer by two.
  When fast pointer reaches end, slow pointer will reach middle of LL
  */

  void printMiddle1() {
    int count = count();
    Node p = head;

    for (int i = 0; i < count/2; i++) // if int i = 1; it will not give correct middle for odd count of list
      p = p.next;

    System.out.println("Method1: The middle element is: " + p.data);
  }

  void printMiddle2() {
    if (head == null) {
      return;
    }
    Node slowPointer = head, fastPointer = head;
    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }
    System.out.println("Method2: The middle element is: " + slowPointer.data);
  }

  // Function to detect loop in a linked list
  int detectLoop() {
    Node slowPointer = head, fastPointer = head;
    while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
      if (slowPointer == fastPointer) {
        System.out.println("Found loop");
        return 1;
      }
    }
    return 0;
  }

  // search an element in the list
  boolean search(int n) {
    Node q = head;
    while (q != null) {
      int v = q.data;
      if (n == v)
        return true;
      else
        q = q.next;
    }
    return false;
  }

  // reverse the elements of the list
  void reverse() {
    Node q = head;
    Node prev = null;
    while (q != null) {
      Node t = q.next;
      q.next = prev;
      prev = q;
      q = t;
    }
    head = prev;
  }

  // copy a list
  LL copy() {
    LL y = new LL();
    Node q = head;
    while (q != null) {
      y.add(q.data);
      q = q.next;
    }
    return y;
  }

  // intersecting/common elements from 2 lists
  LL intersection(LL t) {
    LL z = new LL();
    Node p1, p2;
    p1 = head;
    p2 = t.head;

    while (p1 != null) {
      while (p2 != null) {
        if (p1.data == p2.data)
          break;
        p2 = p2.next;
      }
      if (p2 != null)
        z.add(p1.data);

      p1 = p1.next;
      p2 = t.head;
    }
    return z;
  }

  // union of 2 lists - can have duplicates
  LL union(LL t) {
    LL z = new LL();
    Node p1, p2;
    p1 = head;
    p2 = t.head;

    while (p1 != null) {
      z.add(p1.data);
      p1 = p1.next;
    }

    while (p2 != null) {
      z.add(p2.data);
      p2 = p2.next;
    }
    return z;
  }

  // sort the list
  void sort() {
    for (Node p = head; p.next != null; p = p.next) {
      for (Node t = head; t.next != null; t = t.next) {
        if (t.data > t.next.data) {
          int x = t.data;
          int y = t.next.data;
          t.data = y;
          t.next.data = x;
        }
      }
    }
  }

  // insert element in an ordered list
  void insertOrder(int v) {
    Node q = new Node(v);
    Node p = head;
    Node prev = null;

    while (p != null) {
      if (p.data > v)
        break;

      prev = p;
      p = p.next;
    }

    if (p == head) {
      q.next = head;
      head = q;
    } else {
      q.next = prev.next;
      prev.next = q;
    }
  }

  /* Function to check if a singly linked list is palindrome
    1) Make a copy of the Linked List. (LL y = x.copy())
    2) Reverse the new Linked List. (y.reverse())
  */
  void isPalindrome() {
    LL y = copy();
    y.reverse();
    Node p = head;
    Node q = y.head;
    boolean x = true;
    while (p != null) {
      if (p.data != q.data) {
        x = false;
        System.out.println("Not Palindrome");
        break;
      }
      p = p.next;
      q = q.next;
    }
    if(x)
      System.out.println("Palindrome");
  }
}

public class Solution {
  public static void main(String[] args) throws Exception {
    LL x = new LL();
    x.add(40);
    x.add(80);
    x.add(20);
    x.add(50);
    x.add(20);
    x.display();
    System.out.println();
    System.out.println("Count of the nodes in the list: " + x.count());
    x.count(20);

    int m = x.max();
    System.out.println("Maximum number from the list is: " + m);
    System.out.println();

    System.out.println("Add at beginning");
    x.addB(70);
    x.display();
    System.out.println();

    System.out.println("Add at end/position");
    x.addE(60, 4);
    x.display();
    x.addE(30, 8);
    x.display();
    System.out.println();

    System.out.println("Delete");
    x.delete(70);
    x.display();
    x.delete(20);
    x.display();
    x.delete(20);
    x.display();
    x.delete(20);
    x.display();

    System.out.println();
    
    x.printMiddle1();
    x.printMiddle2();
    System.out.println(x.detectLoop());
    
    System.out.println();
    
    System.out.println("Search");
    boolean b = x.search(5);
    if (b)
      System.out.println("Found");
    else
      System.out.println("Not Found");
    System.out.println();

    System.out.println("Reverse");
    x.reverse();
    x.display();
    System.out.println();

    System.out.println("Copy list");
    LL y = new LL();
    y = x.copy();
    System.out.print("Original List: ");
    x.display();
    System.out.print("Copied List: ");
    y.display();
    System.out.println();

    System.out.println("Original List After Deleting An Element: ");
    x.delete(80);
    x.display();

    System.out.println("Copied List After Deleting An Element: ");
    y.delete(50);
    y.display();

    System.out.println();
    System.out.println("List intersection");
    LL intersect = x.intersection(y);
    intersect.display();

    System.out.println();
    System.out.println("List union");
    System.out.print("List 1: ");
    x.display();
    System.out.print("List 2: ");
    y.display();
    LL union = x.union(y);
    System.out.print("Union of 2 lists: ");
    union.display();

    System.out.println();
    System.out.println("Sorting of List 1:");
    x.sort();
    x.display();

    System.out.println();
    System.out.println("Sorting of the UNION list: ");
    union.sort();
    union.display();

    System.out.println();
    System.out.println("Add element in ordered list(union list) ");
    union.insertOrder(55);
    union.display();
    
    System.out.println();
    System.out.println("Check if the list is Palindrome: ");
    x.isPalindrome();

    System.out.println();
    System.out.println("Delete List and display (it will display an empty list): ");
    x.deleteList();
    x.display();
  }
}


/* OUTPUT:
List: 40  80  20  50  20  

Count of the nodes in the list: 5
Count of 20 is: 2
Maximum number from the list is: 80

Add at beginning
List: 70  40  80  20  50  20  

Add at end/position
List: 70  40  80  60  20  50  20  
List: 70  40  80  60  20  50  20  30  

Delete
List: 40  80  60  20  50  20  30  
List: 40  80  60  50  20  30  
List: 40  80  60  50  30  
Element does not exist
List: 40  80  60  50  30  

Method1: The middle element is: 60
Method2: The middle element is: 60
0

Search
Not Found

Reverse
List: 30  50  60  80  40  

Copy list
Original List: List: 30  50  60  80  40  
Copied List: List: 30  50  60  80  40  

Original List After Deleting An Element: 
List: 30  50  60  40  
Copied List After Deleting An Element: 
List: 30  60  80  40  

List intersection
List: 30  60  40  

List union
List 1: List: 30  50  60  40  
List 2: List: 30  60  80  40  
Union of 2 lists: List: 30  50  60  40  30  60  80  40  

Sorting of List 1:
List: 30  40  50  60  

Sorting of the UNION list: 
List: 30  30  40  40  50  60  60  80  

Add element in ordered list(union list) 
List: 30  30  40  40  50  55  60  60  80  

Check if the list is Palindrome: 
Not Palindrome

Delete List and display (it will display an empty list): 
List: 
*/