class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                pq.add(count[i]);
            }
        }

        while (pq.size() > 0) {
            List<Integer> temp = new ArrayList<>(); // it is used to store frequency which will
                                                    // be pushed back in the queue
            for (int i = 1; i <= n + 1; i++) { // We can do the n+1 task
                if (pq.size() > 0) {
                    int freq = pq.peek();
                    freq--;
                    pq.remove();
                    temp.add(freq);
                }
            }

            // Iterate on the temp list and insert it in the priority queue
            for (int x : temp) {
                if (x > 0) {
                    pq.add(x);
                }
            }

            if (pq.size() == 0) {
                time = time + temp.size();
            } else {
                time = time + (n + 1);
            }
        }

        return time;
    }
}
