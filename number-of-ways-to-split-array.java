// https://leetcode.com/problems/number-of-ways-to-split-array
class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSum = new long[nums.length + 1];

        for(int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int noOfValidSplits = 0;

        for(int i = 1; i < nums.length; i++) {
            long leftSum = prefixSum[i];
            long rightSum = prefixSum[nums.length] - prefixSum[i];

            if(leftSum >= rightSum) {
                noOfValidSplits++;
            }
        }

        return noOfValidSplits;
    }
}
