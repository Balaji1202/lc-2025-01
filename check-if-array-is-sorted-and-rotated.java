// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution {
    public boolean check(int[] nums) {
        boolean rotated = false;
        int i;
        int lastNumber = -1;
        int firstNumber = -1;

        for(i = 0; i < nums.length - 1; i++) {
            if(nums[i] <= nums[i + 1] && lastNumber <= firstNumber) {
                continue;
            } else if(!rotated){
                lastNumber = nums[nums.length - 1];
                firstNumber = nums[0];
                rotated = true;
                continue;
            } else {
                return false;
            }
        }

        return lastNumber <= firstNumber;
    }
}
