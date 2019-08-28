import java.util.Arrays;

public class LPT {

    int m = 12;
    int n = 5;
    public static void main(String[] args) {

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            String name = 'process' + i;
            double time = (int) (Math.random() * 100) * 0.2;
            jobs[i] = new Job(name, time);
        }

        // sort jobs in ascending order of processing time
        Arrays.sort(jobs);

        // generate m empty processors and put on priority queue
        MinPQ<Processor> pq = new MinPQ<Processor>(m);
        for (int i = 0; i < m; i++)
            pq.insert(new Processor());
        // assign each job (in decreasing order of time) to processor that is least busy
        for (int j = n-1; j >= 0; j--) {
            Processor min = pq.delMin();
            min.add(jobs[j]);
            pq.insert(min);
        }

        // print out contents of each processor
        while (!pq.isEmpty())
            StdOut.println(pq.delMin());
    }

}

class Job {

    public String name;
    public String time;

    public static Job(name, time) {
        this.name = name;
        this.time = time;
    }
}