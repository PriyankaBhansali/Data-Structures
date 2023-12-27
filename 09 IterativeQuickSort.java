// Time Complexity: O(nlogn)
// Space Complexity: O(n)

// Using 2 Stacks and Using Stack concept - without push pop operations
import java.util.*;
class IterativeQuickSort { 
  void swap(int arr[], int i, int j) {
    // Try swapping without extra variable 
    if (arr[i] != arr[j]) {
      arr[i] = arr[i] + arr[j];
      arr[j] = arr[i] - arr[j];
      arr[i] = arr[i] - arr[j];
    }
  } 
  
  // This function is same in both iterative and recursive
  int partition(int arr[], int l, int h) {
    // Compare elements and swap.
    int pivot = arr[h];
    int i = (l - 1);
    for (int j = l; j <= h - 1; j++) {
      if (arr[j] <= pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, h);
    return i + 1;
  } 
  // using Stack concept - without push pop operations
  void QuickSort(int arr[], int low, int high) {
    // Try using Stack Data Structure to remove recursion.
    int[] stack = new int[high - low + 1];
    int top = -1;
    stack[++top] = low;
    stack[++top] = high;

    while (top >= 0) {
      high = stack[top--];
      low = stack[top--];
      int p = partition(arr, low, high);

      if (low < p - 1) {
        stack[++top] = low;
        stack[++top] = p - 1;
      }
      if (p + 1 < high) {
        stack[++top] = p + 1;
        stack[++top] = high;
      }
    }
  }

  // using 2 stacks
  void QS_Stack(int arr[], int low, int high) {
    if (low < high) {
      Stack<Integer> l = new Stack<Integer>();
      Stack<Integer> h = new Stack<Integer>();
      l.push(low);
      h.push(high);

      while (!l.empty()) {
        low = l.pop();
        high = h.pop();
        int p = partition(arr, low, high);

        if (p + 1 < high) {
          l.push(p + 1);
          h.push(high);
        }
        if (low < p - 1) {
          l.push(low);
          h.push(p - 1);
        }
      }
    }
  }

  void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  }

  public static void main(String args[]) {
    IterativeQuickSort ob = new IterativeQuickSort();
    int arr[] = { 14, 13, 15, 12, 11, 13, 12, 13 };
    ob.QuickSort(arr, 0, arr.length - 1);
    ob.printArray(arr, arr.length);
    System.out.println("");
    arr = new int[] { 14, 13, 15, 12, 11, 13, 12, 13 };
    ob.QS_Stack(arr, 0, arr.length - 1);
    ob.printArray(arr, arr.length);
  }
}

/* OUTPUT:
11 12 12 13 13 13 14 15 
11 12 12 13 13 13 14 15 
*/