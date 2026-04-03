class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone: stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() != 1) {
            if (maxHeap.size() > 1) {
                int s1 = maxHeap.poll();
                int s2 = maxHeap.poll();
                maxHeap.offer(Math.abs(s1 - s2));
            }
        }

        return maxHeap.peek();
    }
}
