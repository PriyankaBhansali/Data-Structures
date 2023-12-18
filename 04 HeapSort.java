// Time Complexity: O(nlogn)
// Space Complexity: O(1)

import java.util.*;
class HSort {
  int a[];

  void heapify (int a[], int p, int n) {
    int t = a[p], i;
    for (i = 2 * p + 1; i < n; i = 2 * i + 1) {
      if ((i + 1) < n && a[i] < a[i + 1]) {
        i++;
      }

      if (a[i] > t) {
        a[(i - 1) / 2] = a[i];
      } else {
        break;
      }
    }

    a[(i - 1) / 2] = t;
  }

  void heapSort(int a[]) {
    for (int i = a.length / 2 - 1; i >= 0; i--) {
      heapify(a, i, a.length);
      System.out.println(Arrays.toString(a));
    }

    for (int i = a.length - 1; i > 0; i--) {
      int t = a[0];
      a[0] = a[i];
      a[i] = t;
      heapify(a, 0, i);
      System.out.println(Arrays.toString(a));
    }
  }
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements for heap sort");
		int n = sc.nextInt();

		HSort h = new HSort();
		System.out.println();

		int a[] = new int[n];
		System.out.println("Enter elements for sorting:");
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		System.out.println("Heap Sort");
    h.heapSort(a);
	}
}

/* OUTPUT:
Enter the no of elements for heap sort
5

Enter elements for sorting:
6
4
5
7
3
Heap Sort
[6, 7, 5, 4, 3]
[7, 6, 5, 4, 3]
[6, 4, 5, 3, 7]
[5, 4, 3, 6, 7]
[4, 3, 5, 6, 7]
[3, 4, 5, 6, 7]
*/