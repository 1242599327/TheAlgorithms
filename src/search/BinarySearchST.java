package search;

/**
 * 基于有序数组的二分查找;
 * <p>
 * 使用一对平行的数组;
 */
public class BinarySearchST<K extends Comparable<K>, V> {
    private K[] keys;
    private V[] values;
    private int N;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Comparable[capacity];
    }

    /**
     * @param key
     * @return if key exits in the array, return the index of key,
     * otherwise return the count of the keys that less than it
     */
    private int rank(K key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

}
