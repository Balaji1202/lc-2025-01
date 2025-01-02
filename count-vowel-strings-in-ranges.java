//https://leetcode.com/problems/count-vowel-strings-in-ranges/

class Solution {
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] valid = new int[n];

        for(int i = 0; i < n; i++) {
            String word = words[i];
            if(isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                valid[i] = 1;
            } else {
                valid[i] = 0;
            }
        }

        int[] prefix = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + valid[i - 1];
        }

        int[] result = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            result[i] = prefix[ri + 1] - prefix[li];
        }

        return result;
    }
}
