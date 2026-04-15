class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // Step 1 - count task frequencies
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // Step 2 - max heap (highest frequency first)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) {
            if (c > 0) maxHeap.offer(c);
        }

        // Step 3 - cooldown queue stores [remainingCount, availableAtTime]
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll() - 1;  // execute task
                if (freq > 0) {
                    cooldown.offer(new int[]{freq, time + n}); // back after cooldown
                }
            }

            // if cooldown is over, put task back in heap
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}