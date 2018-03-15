package sort;

import java.util.Arrays;

/**
 * Created by sinyuk on 2018/3/10.
 * <p>
 * 选择排序 复杂度 N²/2
 */
public class Selection {

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{6, 3, 2, 5, 1, 4};
        System.out.println(Arrays.toString(sort(a)));
    }

    public static Comparable[] sort(Comparable[] a) {

        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Utils.less(a[j], a[min])) min = j;
            }
            Utils.exchange(a, i, min);
        }
        return a;
    }
}



