// Time complexity: O(logn)
// Space complexity: O(n)

// ** BinarySearch works only for sorted arrays **

class BinarySearch {
  int binarySearch(int arr[], int x) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2; // OR mid = (low + high) / 2;
      if (arr[mid] == x) {
        return mid;
      } else if (arr[mid] > x) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  int binarySearchRecursive(int arr[], int low, int high, int x) {
    if (low <= high) {
      int mid = low + (high - low) / 2;

      // check if mid element is searched element
      if (arr[mid] == x)
        return mid;

      // Search the left half of mid
      if (arr[mid] > x)
        return binarySearchRecursive(arr, low, mid - 1, x);
      // Search the right half of mid
      return binarySearchRecursive(arr, mid + 1, high, x);
    }
    return -1;
  }

  int binarySearchRecursive(int arr[], int x) {
    return binarySearchRecursive(arr, 0, arr.length - 1, x);
  }
}

public class Solution {
  public static void main(String args[]) {
    BinarySearch obj = new BinarySearch();
    int arr[] = { 2, 3, 4, 10, 40 }; // sorted array
    int x = 10;
    int result = obj.binarySearch(arr, x);
    if (result == -1) {
      System.out.println("Element not present");
    } else {
      System.out.println("Element found at index " + result);
    }

    x = 4;
    result = obj.binarySearchRecursive(arr, x);
    if (result == -1) {
      System.out.println("Element not present");
    } else {
      System.out.println("Element found at index " + result);
    }
  }
}

/* OUTPUT:
Element found at index 3
Element found at index 2
*/