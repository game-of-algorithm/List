package src.search;

public class Test_3_1_6 {

    public static void main(String[] args) {
        /*
         * 输入中的单词总数 W 和不同单词总数 D
         */
//        int minLen = Integer.parseInt(args[0]);
//        ST<String, Integer> st = new ST<String, Integer>();
//        while (!StdIn.isEmpty()) {
//            String word = StdIn.readString();
//            if (word.length() < minLen) continue;
            /*
             * put  W   get W - D
             */
//            if (!st.contains(word)) st.put(word, 1);
//            else                    st.put(word, st.get(word) + 1);
//        }
//        String max = " ";
        /*
         * put 1次
         */
//        st.put(max, 0);
//        for (String word : st.keys())
//            if (st.get(word) > st.get(max)) // get 2 * D
//                max = word;
//        StdOut.println(max + " " + st.get(max)); // get 1
        /*
         * 所以总的 put 次数为 W + 1
         * 总的 get 次数为 W - D + 2 * D + 1 = W + D + 1
         */
    }
}
