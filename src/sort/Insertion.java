package sort;

import java.util.Arrays;

/**
 * Created by sinyuk on 2018/3/10.
 * <p>
 * 插入排序
 */
public class Insertion {

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{6, 3, 2, 5, 1, 4};
        System.out.println(Arrays.toString(sort(a)));
    }

    public static Comparable[] sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Utils.less(a[j], a[j - 1]); j--) {
                Utils.exchange(a, j, j - 1);
            }
        }
        return a;
    }
}
