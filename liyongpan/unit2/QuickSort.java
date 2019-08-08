import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {

	static Integer[] a = {100,100,100,100,100,100,100,100,100,50,50,50,50,50,50,50,50,28,28,28,28,28,28,28};
//	static Integer[] a = {100,92,84,76,68,60,52,44,36,28,21,14,7,99,91,83,75,67,59,51,43,35,27,20,13,6,98,90,82,74,66,58,50,42,34,26,19,12,5,97,89,81,73,65,57,49,41,33,25,18,11,4,96,88,80,72,64,56,48,40,32,24,17,10,3,95,87,79,71,63,55,47,39,31,23,16,9,2,94,86,78,70,62,54,46,38,30,22,15,8,1,93,85,77,69,61,53,45,37,29};

	public static void main(String[] args) {
		shuffle(a);
		System.out.println(Arrays.toString(a));
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	private static int partition(Integer[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		int c = a[lo];
		while (true) {
			// 从前往后，找到第一个比切分元素大的数
			while (a[++i].equals(c) || a[i] < c) if (i == hi) break;
			// 从后往前，找到第一个比切分元素小的数
			while (a[--j].equals(c) || a[j] > c) if (j == lo) break;
			//一个比切分元素大的数比第一个比切分元素小的数位置靠后，是顺序数组，退出
			if (i >= j) break;
			// 交换
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		System.out.println(i + "   " + j + "   " + lo + "   " + c);
		System.out.println(Arrays.toString(a));
		// 最后交换切分元素和较小数组中的最大数
		a[lo] = a[j];
		a[j] = c;
		return j;
	}

	private static void sort (Integer[] a, int lo, int hi) {
		if (lo >= hi) return;
		int j = partition(a, lo, a.length - 1);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static void shuffle(Integer[] a) {
		List<Integer> l = Arrays.asList(a);
		Collections.shuffle(l);
		a = l.toArray(new Integer[1]);
	}

}
