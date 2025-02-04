// https://leetcode.com/problems/maximum-ascending-subarray-sum/

class Solution {

    public int maxAscendingSum(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int localMax = nums[i];

            for (
                int j = i + 1;
                j < nums.length && nums[j] > nums[j - 1];
                j++
            ) {
                localMax += nums[j];
            }

            max = Math.max(max, localMax);
        }

        return max;
    }
}
