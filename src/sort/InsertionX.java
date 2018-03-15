package sort;

import java.util.Arrays;

/**
 * Created by sinyuk on 2018/3/11.
 */
public class InsertionX {
    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{6, 3, 2, 5, 1, 4};
        System.out.println(Arrays.toString(sort(a)));
    }

    public static Comparable[] sort(Comparable[] a) {
        int N = a.length;
        int min = 0;
        for (int i = 1; i < a.length; i++) {
            if (Utils.less(a[i], a[min])) min = i;
        }
        Utils.exchange(a, 0, min);
        System.out.println("Put smallest element in position to serve as sentinel\n" + Arrays.toString(a));

        // insertion sort with half-exchanges
        for (int i = 2; i < N; i++) {
            Comparable v = a[i];
            int j = i;
            while (Utils.less(v, a[j - 1])) {
                Utils.exchange(a, j, j - 1);
                j--;
            }
        }
        return a;
    }
}
