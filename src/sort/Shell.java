package sort;

import java.util.Arrays;

/**
 * Created by sinyuk on 2018/3/10.
 *
 */
public class Shell {
    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{6, 3, 2, 5, 1, 4};
        System.out.println(Arrays.toString(sort(a)));
    }

    public static Comparable[] sort(Comparable[] a) {
        int N = a.length;
        int H = 1;
        while (H < N / 3) H = H * 3 + 1;
        while (H >= 1) {
            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i + 1; j < N; j++) {
                    if (Utils.less(a[j], a[min])) min = j;
                }
                Utils.exchange(a, i, min);
            }
            H = H / 3;
        }
        return a;
    }
}
