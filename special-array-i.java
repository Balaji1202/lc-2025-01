// https://leetcode.com/problems/special-array-i

class Solution {
    public boolean isArraySpecial(int[] nums) {
        int parity = nums[0] % 2;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] % 2 != parity) {
                parity = nums[i] % 2;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
