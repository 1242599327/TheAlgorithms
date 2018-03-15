package sort;

import java.util.Arrays;

import static sort.Utils.exchange;

public class Sort2distinct {
    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    @SuppressWarnings("unchecked")
    private static void sort(Comparable[] a, int low, int high) {
        int i = low;
        int lt = low;
        int gt = high;

        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if (cmp < 0) exchange(a, i++, lt++);
            else if (cmp > 0) exchange(a, i, gt--);
            else i++;
        }
    }


}
