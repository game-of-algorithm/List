import java.util.Arrays;
import java.util.Collections;

public class InsertSort {

	public static void main(String[] args) {
		Integer[] a = randoms();
//		System.out.println(Arrays.toString(a));
		Arrays.sort(a, Collections.reverseOrder());
		System.out.println(Arrays.toString(a));
		long start = System.currentTimeMillis();
		System.out.println(start);
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					int temp = a[j];
					int k = j - i;
					while (k > 0) {
						a[k + i] = a[k + i - 1];
						k--;
					}
					a[i] = temp;
				}
			}
		}
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(Arrays.toString(a));
	}

	public static Integer[] randoms() {
		Integer[] arr = new Integer[10000];
		for(int i = 0, len = arr.length; i < len; i++) {
			int ran = (int) (Math.random() * 100000);
			arr[i] = ran;
		}
		return arr;
	}
}
