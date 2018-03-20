package priorityqueue;

import java.util.Arrays;

import static sort.Utils.exchange;
import static sort.Utils.less;

public class PriorityQueue {
    private int MAX = 100; // MAX >= size + 1
    private Comparable[] a = new Comparable[MAX];

    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public PriorityQueue() {
    }

    PriorityQueue(Comparable[] aux) {
        if (aux.length >= MAX) a = new Comparable[aux.length + 1];
        a[0] = null;
        System.arraycopy(aux, 0, a, 1, aux.length);
        size = aux.length;
        // 下沉构造一个二叉堆
        for (int k = size / 2; k >= 1; k--) {
            sink(a, k, size);
        }
    }

    public Comparable enqueue(Comparable c) {
        size++;
        increaseCapacity();
        a[size] = c;
        swim(a, size);
        return c;
    }

    public Comparable max() {
        if (size != 0) return a[1];
        return null;
    }

    public Comparable dequeue() {
        if (size == 0) return null;
        Comparable max = a[1];
        exchange(a, 1, size);
        a[size] = null;
        size--;
        sink(a, 1, size);
        reduceCapacity();
        return max;
    }


    private void reduceCapacity() {
        if (size + 1 < MAX / 4) {
            MAX = MAX / 4;
            Comparable[] aux = new Comparable[MAX];
            System.arraycopy(a, 1, aux, 1, size);
            a = aux;
        }
    }

    private void increaseCapacity() {
        if (a == null) {
            a = new Comparable[MAX];
            a[0] = null;
        } else if (size + 1 > MAX) {
            MAX *= 2;
            Comparable[] aux = new Comparable[MAX];
            System.arraycopy(a, 1, aux, 1, a.length);
            a = aux;
        }
    }

    /**
     * 上浮
     *
     * @param a
     * @param k
     */
    private static void swim(Comparable[] a, int k) {
        while (k >= 2 && less(a[k / 2], a[k])) {
            exchange(a, k / 2, k);
            k = k / 2;
        }
    }


    /**
     * 下沉
     *
     * @param a
     * @param k
     */
    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int child = 2 * k;
            if (child < N && less(a[child], a[child + 1])) child++;
            if (less(a[child], a[k])) break;
            exchange(a, k, child);
            k = child;
        }
    }


    @SuppressWarnings("unused")
    private static Comparable[] swimToHeap(Comparable[] a) {
        int N = a.length - 1;
        for (int k = N; k > N / 2; k--) {
            swim(a, k);
        }
        return a;
    }

    /**
     * sorted by sink
     */
    public Comparable[] toSortedArray() {
        int N = size;
        if (N == 0) return null;
        Comparable[] aux = a;
        while (N > 1) {
            exchange(aux, 1, N--);
            sink(aux, 1, N);
        }
        return Arrays.copyOfRange(aux, 1, size + 1); // the to index is exclusive
    }

    @Override
    public String toString() {
        if (size == 0) return null;
        return Arrays.toString(Arrays.copyOfRange(a, 1, size + 1));
    }
}
