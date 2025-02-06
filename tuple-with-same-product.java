// https://leetcode.com/problems/tuple-with-same-product/

class Solution {
    public int tupleSameProduct(int[] nums) {
        int totalNumberOfTuples = 0;
        Map<Integer, Integer> productCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                if (productCount.containsKey(product)) {
                    totalNumberOfTuples += productCount.get(product);
                }
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        return totalNumberOfTuples * 8;
    }
}
