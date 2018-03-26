package sort;

import java.util.Arrays;

import static sort.Utils.exchange;
import static sort.Utils.less;

/**
 * Created by sinyuk on 2018/3/12.
 */
public class Quick {

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{2, 1, 2, 2, 1, 1, 2, 1, 2};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1); // oj8k
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable mid = a[low];
        while (true) {
            // find item on lo to swap
            while (less(a[++i], mid)) {
                if (i == high) break;
            }

            // find item on hi to swap
            while (less(mid, a[--j])) {
                if (j == low) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }

}
