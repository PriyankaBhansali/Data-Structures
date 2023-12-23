// Time Complexity: O(nlogn)
// Space Complexity: O(n)

/* Merge sort is one of the most efficient sorting algorithms. 
It works on the principle of Divide and Conquer based on the idea of breaking 
down a list into several sub-lists until each sublist consists of a single element 
and merging those sublists in a manner that results into a sorted list.
*/

import java.util.*;
class MSort {
  int arr[];

  void mergeSort(int arr[], int low, int high) {
    if (low < high) {
      int mid = low + (high - low) / 2;
      System.out.println("mid = " + mid);
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
  }
  // Merges two subarrays of arr[]
  // First subarray is arr[low..mid]
  // Second subarray is arr[mid+1..high]
  void merge(int arr[], int low, int mid, int high) {
    int k = 0;
    int i = low;
    int j = mid + 1;
    int t[] = new int[high - low + 1];

    while (i <= mid && j <= high) {
      // compare arr[i] with arr[j] and then assign value to t[k]
      // Last, increment the value of k(k++)
      t[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) {
      t[k++] = arr[i++];
    }

    while (j <= high) {
      t[k++] = arr[j++];
    }

    // Copy "t.length" number of elements from "array t" with starting point 0
    // into "array a" with starting point low
    System.arraycopy(t, 0, arr, low, t.length);
  }
}
/* Can use below loop instead if you want to avoid arraycopy!!
  int tindex = 0, aindex = low;
  while (tindex < t.length && aindex < arr.length) {
    arr[aindex] = t[tindex];
    tindex++;
    aindex++;
  }
*/

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the no of elements for merge sort");
    int n = sc.nextInt();
    int a[] = new int[n];
    
    MSort ms = new MSort();
    System.out.println();

    System.out.println("Enter elements for sorting:");
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();

    System.out.println("Merge Sort:");
    ms.mergeSort(a, 0, a.length - 1);

    for (int i = 0; i < n; i++)
      System.out.print(a[i] + " ");
	}
}

/* OUTPUT:
Enter the no of elements for merge sort
6

Enter elements for sorting:
3
6
8
5
9
2
Merge Sort:
mid = 2
mid = 1
mid = 0
mid = 4
mid = 3
2 3 5 6 8 9
*/