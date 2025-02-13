// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

class Solution {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long) num);
        }

        int numOperations = 0;

        while (minHeap.peek() < k) {
            if (minHeap.size() < 2) {
                return -1;
            }

            long x = minHeap.poll();
            long y = minHeap.poll();

            minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));

            numOperations++;
        }

        return numOperations;
    }
}
