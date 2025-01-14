// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixArray = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    if (A[j] == B[k]) {
                        count++;
                        break;
                    }
                }
            }

            prefixArray[i] = count;
        }

        return prefixArray;
    }
}
