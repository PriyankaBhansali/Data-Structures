// Time Complexity: O(n), where n is the size of the list/array.
// Space Complexity: O(1) since we are not using any extra space.

import java.util.*;
class Search {
  int a[];

  Search(int n) {
    a = new int[n];
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the elements");
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
  }

  int linear(int v) { // also called as sequential search
    int i = 0;
    while (i < a.length && a[i] != v) {
      i++;
    }

    if (i < a.length && a[i] == v)
      return 1;
    else 
      return -1;
  }

  void sort() {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - 1; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }
    System.out.print("After sorting: ");
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println("");
  }

  int linearOrder(int v) {
    sort();

    int i = 0;
    while (i < a.length && a[i] < v) {
      i++;
    }

    if (i < a.length && a[i] == v)
      return 1;
    else 
      return -1;
  }
}

public class Solution {
  public static void main(String[] args) {
    int result;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n = sc.nextInt();
    Search s = new Search(n);
    
    System.out.println("Enter the value to be searched");
    int v = sc.nextInt();

    System.out.println("\nLinear/Sequential Search:");
    result = s.linear(v);
    if (result == -1)
      System.out.println("Not Found");
    else
      System.out.println("Found");

    System.out.println("\nLinearOrder Search:");
    result = s.linearOrder(v);
    if (result == -1)
      System.out.println("Not Found");
    else
      System.out.println("Found");
    
  }
}

/* 
OUTPUT 1:
Enter the size of array
7
Enter the elements
4
8
2
9
3
6
1
Enter the value to be searched
5

Linear/Sequential Search:
Not Found

LinearOrder Search:
After sorting: 1 2 3 4 6 8 9
Not Found


OUTPUT 2:
Enter the size of array
4
Enter the elements
8
5
1
6
Enter the value to be searched
5
Linear/Sequential Search:
Found

LinearOrder Search:
After sorting: 1 5 6 8 
Found
*/