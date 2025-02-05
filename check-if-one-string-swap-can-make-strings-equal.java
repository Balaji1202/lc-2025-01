// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(char c: s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        for(char c: s2.toCharArray()) {
            s2Freq[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }

        int slipCount = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else if(s1.charAt(i) != s2.charAt(i)) {
                slipCount++;
            }

            if(slipCount > 2) {
                return false;
            }
        }

        return slipCount <= 2;
    }
}
