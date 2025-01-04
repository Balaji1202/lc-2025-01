// https://leetcode.com/problems/unique-length-3-palindromic-subsequences
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        
        int[] firstOccurrence = new int[26];
        int[] lastOccurrence = new int[26];
        
        Arrays.fill(firstOccurrence, -1);
        
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            int charIndex = currentChar - 'a';
            
            if (firstOccurrence[charIndex] == -1) {
                firstOccurrence[charIndex] = i;
            }
            lastOccurrence[charIndex] = i;
        }

        int palindromeCount = 0;

        for (int i = 0; i < 26; i++) {
            if (firstOccurrence[i] == -1) {
                continue;
            }

            Set<Character> uniqueMiddleChars = new HashSet<>();
            
            for (int j = firstOccurrence[i] + 1; j < lastOccurrence[i]; j++) {
                uniqueMiddleChars.add(s.charAt(j));
            }

            palindromeCount += uniqueMiddleChars.size();
        }

        return palindromeCount;
    }
}
