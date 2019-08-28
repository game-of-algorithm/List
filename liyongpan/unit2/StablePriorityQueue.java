public class StablePriorityQueue {
    private int[]  pq;                   // store element at indices 1 to N
    private long[] time;                 // timestamp
    private int n;                       // number of elements on priority queue
    private long timestamp = 1;          // timestamp for when item was inserted

    // create an empty priority queue
    public StableMinPQ() {
        pq = new int[2];
        time = new long[2];
        n = 0;
    }


    // Is the priority queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // Return the number of elements on the priority queue.
    public int size() {
        return n;
    }

     //  Return the smallest key on the priority queue.
    public int min() {
        if (isEmpty()) throw new RuntimeException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        int[]  tempPQ   = new int[capacity];
        long[] tempTime = new long[capacity];
        for (int i = 1; i <= n; i++)
            tempPQ[i] = pq[i];
        for (int i = 1; i <= n; i++)
            tempTime[i] = time[i];
        pq   = tempPQ;
        time = tempTime;
    }

    // add a new key to the priority queue
    public void insert(int x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        n++;
        pq[n] = x;
        time[n] = ++timestamp;
        swim(n)
        assert isMinHeap(1);
    }

    // Delete and return the smallest key on the priority queue.
    public int delMin() {
        if (n == 0) throw new RuntimeException("Priority queue underflow");
        exch(1, n);
        int min = pq[n--];
        sink(1);
        pq[n+1] = null;         // avoid loitering and help with garbage collection
        time[n+1] = 0;
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length  / 2);
        assert isMinHeap(1);
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            int temp = pq[k / 2];
            pq[j] = pg[k];
            pq[k] = temp;
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        if (pq[i] > pq[j]) return true;
        if (pq[i] < pq[j]) return false;
        return time[i] > time[j];
    }

    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
}