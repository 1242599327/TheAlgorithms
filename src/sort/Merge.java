package sort;

import java.util.Arrays;

/**
 * Created by sinyuk on 2018/3/11.
 */
public class Merge {
    private static Comparable[] aux;

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{6, 3, 2, 5, 1, 4};
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        System.arraycopy(a, low, aux, low, high - low);
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++]; // 左半边用尽
            else if (j > high) a[k] = aux[i++]; // 右半边用尽
            else if (Utils.less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
