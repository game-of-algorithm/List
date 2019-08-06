import java.util.Arrays;

class QuickSort{
    public static void main(String[] args) {
        int[] arr = {11, 2, 43, 44, 25, 16, 97, 8, 19};
        System.out.println(Arrays.toString(arr));
        quick_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quick_sort(int arr[], int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        int key = arr[l];

        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }

            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] < key) {
                i++;
            }

            if (i < j) {
                arr[j] = arr[i];
                j--;
            }

            arr[i] = key;
            quick_sort(arr, l, i - 1);
            quick_sort(arr, i + 1, r);
        }
    }
}