import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] a = randoms();
//		System.out.println(Arrays.toString(a));
		int n = a.length;
		int h = 1;
		long start = System.currentTimeMillis();
		System.out.println(start);
		while (h < n / 3) h = h * 3 + 1;
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h; j -= h) {
//				for (int j = i; j < a.length; j += h) {
					if (a[j] >= a[j - h]) break;
					int temp = a[j];
					a[j] = a[j - h];
					a[j - h] = temp;
//					if (a[j] < a[i]) {
//						int temp = a[j];
//						int k = j - i;
//						while (k > 0) {
//							a[k + i] = a[k + i - h];
//							k -= h;
//						}
//						a[i] = temp;
//					}
				}
			}
			h = h / 3;
		}
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis() - start);
//		System.out.println(Arrays.toString(a));
	}
	public static int[] randoms() {
		int[] arr = new int[100000];
		for(int i = 0, len = arr.length; i < len; i++) {
			int ran = (int) (Math.random() * 100000);
			arr[i] = ran;
		}
		return arr;
	}
}
