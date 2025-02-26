// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

class Solution {

    public int maxAbsoluteSum(int[] nums) {
        int min = 0, max = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        return max - min;
    }
}
