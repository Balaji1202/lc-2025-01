// https://leetcode.com/problems/minimum-length-of-string-after-operations/

class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int length = 0;

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) continue;
            
            if(freq[i] % 2 == 0) {
                length += 2;
            } else {
                length += 1;
            }
        }

        return length;
    }
}
