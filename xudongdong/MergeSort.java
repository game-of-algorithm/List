import java.util.Arrays;

class MergeSort{
    static int[] arr = {11, 2, 43, 44, 25, 16, 97, 8, -9};
    static int len = arr.length;
    static int[] aux = new int[len];


    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        sort(arr, 0 , len - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] a,int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);//左半边排序
        sort(a, mid + 1, hi);//右半边排序
        merge(a,lo, mid, hi);//归并结果（参考原地归并的抽象方法）
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