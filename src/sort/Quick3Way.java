package sort;

import java.util.Arrays;

import static sort.Utils.exchange;

public class Quick3Way {
    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{4, 1, 2, 3, 7, 3, 3, 3, 3, 1, 1, 5, 6};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * <p>
     * a[i] less than v: exchange a[lt] with a[i] and increment both lt and i
     * a[i] greater than v: exchange a[i] with a[gt] and decrement gt
     * a[i] equal to v: increment i
     * <p/>
     *
     * @param a
     * @param low
     * @param high
     */
    @SuppressWarnings("unchecked")
    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int lt = low;
        int gt = high;
        int i = high - 1;
        Comparable v = a[high];
        while (i >= lt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exchange(a, lt++, i);
            } else if (cmp > 0) {
                exchange(a, i--, gt--);
            } else {
                i--;
            }
        }
        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }


}
