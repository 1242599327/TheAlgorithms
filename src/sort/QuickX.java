package sort;

import java.util.Arrays;

/**
 * Created by sinyuk on 2018/3/13.
 * <p>
 * 快速排序
 */
public class QuickX {
    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{6, 5, 4, 3, 2, 1};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1); // oj8k
        sort(a, j + 1, high);
    }

    @SuppressWarnings("FieldCanBeLocal")
    private static boolean DEBUG = true;

    private static int partition(Comparable[] a, int low, int high) {
        if (DEBUG) {
            Comparable[] aux = new Comparable[high - low + 1];
            System.arraycopy(a, low, aux, 0, high - low + 1);
            System.out.println("排序: " + Arrays.toString(aux));
        }

        Comparable partition = a[low];
        int i = low;
        int j = high;
        while (i < j) {
            i++;
            System.out.println("======> 扫描,i=" + i);
            if (Utils.less(partition, a[i])) {
                System.out.println("在[" + i + "]处找到大于" + partition + "的: " + a[i]);
                while (i <= j) {
                    System.out.print("<====== 扫描,j=" + j + ", 比较" + a[j] + "和" + partition + "; ");
                    if (Utils.less(a[j], partition)) {
                        System.out.println("位置有误, 交换[" + a[j] + "]和[" + a[i] + "]");
                        Utils.exchange(a, j, i);
                        j--;
                        break;
                    }
                    j--;
                }
            }
        }

        Utils.exchange(a, low, j);
        System.out.println("把 " + partition + " 插入到[" + j + "]处: ");
        return j;
    }
}
