// https://leetcode.com/problems/count-number-of-bad-pairs/

class Solution {
    public long countBadPairs(int[] arr) {
        long result = 0;
        Map<Integer, Integer> differenceFrequency = new HashMap<>();

        for (int index = 0; index < arr.length; index++) {
            int diff = index - arr[index];
            int validPairs = differenceFrequency.getOrDefault(diff, 0);
            result += index - validPairs;
            differenceFrequency.put(diff, validPairs + 1);
        }

        return result;
    }
}
