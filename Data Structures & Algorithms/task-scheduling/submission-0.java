class Solution {
    public int leastInterval(char[] tasks, int n) {
        // storage freq in array, index 1 - 26 representing the character A - Z
        int[] count = new int[26];
        for (char task: tasks) {
            count[task - 'A']++;
        }

        // storage tasks ready to execute in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt: count) {
            if (cnt > 0) {
                maxHeap.offer(cnt);
            }
        }

        int time = 0;
        // storage executed task and idle time when available
        Queue<int[]> q = new LinkedList<>();
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            }else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            // idle task is available back to maxHeap
            if (!q.isEmpty() && q.peek()[1] == time) {
                int[] task = q.poll();
                maxHeap.offer(task[0]);
            }
        }

        return time;
    }
}
