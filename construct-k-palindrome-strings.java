// https://leetcode.com/problems/construct-k-palindrome-strings/

class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();

        if(n < k) return false;
        if(n == k) return true;

        int[] frequency = new int[26];

        for(int i = 0; i < n; i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        int noOfOddChars = 0;

        for(int i = 0; i < frequency.length; i++) {
            if(frequency[i] % 2 != 0) {
                noOfOddChars++;
            }
        }

        return noOfOddChars <= k;
    }
}
