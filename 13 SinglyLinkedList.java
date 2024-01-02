// Time Complexity: O(n)
// Space Complexity: O(n)

import java.io.*;
public class LinkedList {
  Node head; // head of list

  // Linked list Node
  // This inner class is made static so that main() can access it
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  // Method to insert a new node
  public static LinkedList insert(LinkedList list, int data) {
    // Create a new node with given data
    Node p = new Node(data);

    if (list.head == null) { // If the Linked List is empty, then make the new node as head
      list.head = p;
    } else { // Else traverse till the last node and insert the new_node there
      Node q = list.head;
      while (q.next != null) {
        q = q.next;
      }
      q.next = p; // Insert the new_node at last node
    }
    return list; // Return the list by head
  }

  public static void printList(LinkedList list) {
    Node p = list.head;
    while (p.next != null) {
      System.out.print(p.data + " ");
      p = p.next;
    }
    System.out.println(p.data);
  }

  public static void main(String[] args) {
    /* Start with the empty list. */
    LinkedList list = new LinkedList();

    // Insert the values
    // main can access insert() directly without doing list.insert(value) because of static
    // but then it needs to pass the list in this case
    list = insert(list, 1);
    list = insert(list, 2);
    list = insert(list, 3);
    printList(list);
    list = insert(list, 4);
    list = insert(list, 5);
    printList(list);
  }
}

/* OUTPUT: 
1 2 3
1 2 3 4 5
*/