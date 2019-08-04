import java.util.Arrays;

class MergeSort2 {
    static int[] arr = {11, 2, 43, 44, 25, 16, 97, 8, -9};
    static int len = arr.length;
    static int[] aux = new int[len];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        int n = a.length;
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, n - 1));// 最后一次并归的第二个子数组可能比第一个小此时lo+2*sz-1越界
            }
        }
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }

    }
}