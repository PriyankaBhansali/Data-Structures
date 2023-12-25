// Time Complexity: O(nlogn)
// Space Complexity: O(logn)

/* QuickSort is a sorting algorithm based on the Divide and Conquer algorithm 
that picks an element as a pivot and partitions the given array around the 
picked pivot by placing the pivot in its correct position in the sorted array.
*/

import java.util.*;
class Qsort {
  void QuickSort(int arr[], int low, int high) {
    if (low < high) {
      int p = partition(arr, low, high);
      QuickSort(arr, low, p - 1);
      QuickSort(arr, p + 1, high);
    }
  }

  int partition(int arr[], int low, int high) {
    int p = arr[low]; // pivot element
    int l = low + 1;
    int r = high;

    while (true) {
      while (l <= high && p >= arr[l]) {
        l++;
      }
      while (p < arr[r]) {
        r--;
      }
  
      if (l < r) {
      /* This takes last element as pivot, places the pivot 
      element at its correct position in sorted array, and places 
      all smaller (smaller than pivot) to left of pivot and all 
      greater elements to right of pivot */
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
      } else {
        arr[low] = arr[r];
        arr[r] = p;
        break; // break the while loop; next step - return r
      }
    }
    return r;
  }
}

class Solution {
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the no of elements for quick sort");
    int n = sc.nextInt();
    int a[] = new int[n];
    Qsort q = new Qsort();
    
    System.out.println("Enter elements for sorting:");
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();

    System.out.println("\nQuick Sort");
    q.QuickSort(a,0,a.length-1);
    
    for (int i: a) 
      System.out.print(i + " ");
  }
}

// Note: for line 25
// p should be compared with >= arr[l] and not just > to handle more than 2 
// duplicate values in an array. Eg int arr[] = {14, 13, 15, 12, 11, 13, 12, 13}

/* OUTPUT:
Enter the no of elements for quick sort
6
Enter elements for sorting:
3
6
8
5
9
2

Quick Sort
2 3 5 6 8 9
*/