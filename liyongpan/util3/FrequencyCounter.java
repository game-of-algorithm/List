import java.util.HashMap;

public class FrequencyCounter {

	public static void main(String[] args) {
		String s = "2";
		int minlen = Integer.parseInt(s);
		String txt = "it was the best of times it was the worst of times";
		txt += "\nit was the age of wisdom it was the age of foolishness";
		String[] strs = txt.replace("\n", " ").split(" ");
		HashMap<String, Integer> st = new HashMap<String, Integer>();
		for (String w : strs) {
			if (w.length() < minlen) continue;
			if (!st.containsKey(w)) st.put(w, 1);
			else st.put(w, st.get(w) + 1);
		}
		String max = " ";
		st.put(max, 0);
		for (String w : st.keySet()) {
			if (st.get(w) > st.get(max))
				max = w;
		}
		System.out.println(max + " " + st.get(max));
	}
}
