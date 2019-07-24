import java.util.Arrays;

public class E2_1_14 {

	public static void main(String[] args) {
		int[] a = randoms();
		System.out.println(Arrays.toString(a));
		int m = a.length - 1;
		while (m > 0) {
			for (int i = 0; i < m; i++) {
				if (a[0] > a[1]) {
					move2Last(1, a);
				} else {
					move2Last(0, a);
				}
			}
			for (int i = 0; i < a.length - m; i++) {
				move2Last(0, a);
			}
			m--;
		}
		System.out.println(Arrays.toString(a));
	}

	public static void move2Last (int index, int[] arr) {
		int temp = arr[index];
		int last = arr.length - 1;
		while (last - index > 0) {
			arr[index] = arr[index + 1];
			index++;
		}
		arr[index] = temp;
	}

	public static int[] randoms() {
		int[] arr = new int[52];
		for(int i = 0, len = arr.length; i < len; i++) {
			int ran = (int) (Math.random() * 1000);
			arr[i] = ran;
		}
		return arr;
	}
}
