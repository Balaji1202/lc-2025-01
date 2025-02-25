// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int length = arr.length;

        // Convert elements to 0 (even) or 1 (odd)
        for (int i = 0; i < length; i++) {
            arr[i] %= 2;
        }

        int[] evenCount = new int[length], oddCount = new int[length];

        // Initialization for the last element
        if (arr[length - 1] == 0) evenCount[length - 1] = 1;
        else oddCount[length - 1] = 1;

        for (int i = length - 2; i >= 0; i--) {
            if (arr[i] == 1) {
                oddCount[i] = (1 + evenCount[i + 1]) % MOD;
                evenCount[i] = oddCount[i + 1];
            } else {
                evenCount[i] = (1 + evenCount[i + 1]) % MOD;
                oddCount[i] = oddCount[i + 1];
            }
        }

        int result = 0;
        for (int count : oddCount) {
            result += count;
            result %= MOD;
        }
        return result;
    }
}
