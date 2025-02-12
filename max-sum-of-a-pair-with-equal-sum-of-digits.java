// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

class Solution {

    // Helper function to compute the sum of digits of a number
    private int calculateDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }

    public int maximumSum(int[] nums) {
        // Create a map to group numbers by their digit sums
        Map<Integer, List<Integer>> digitSumMap = new HashMap<>();

        // Populate the map with numbers grouped by their digit sums
        for (int num : nums) {
            int digitSum = calculateDigitSum(num);
            digitSumMap.putIfAbsent(digitSum, new ArrayList<>());
            digitSumMap.get(digitSum).add(num);
        }

        int maxPairSum = -1;

        // Iterate through each digit sum group
        for (List<Integer> group : digitSumMap.values()) {
            if (group.size() > 1) {
                // Sort the numbers within each group in descending order
                Collections.sort(group, Collections.reverseOrder());

                // Calculate the maximum sum of pairs
                int groupSize = group.size();
                for (int i = 1; i < groupSize; i++) {
                    int currentSum = group.get(i) + group.get(i - 1);
                    maxPairSum = Math.max(maxPairSum, currentSum);
                }
            }
        }

        return maxPairSum;
    }
}
