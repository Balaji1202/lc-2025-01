// https://leetcode.com/problems/word-subsets/

class Solution {
    private static boolean isUniversal(int[] freq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }

        return true;
    }

    private static int[] getFrequency(String word) {
        int[] freq = new int[26];

        for(char c: word.toCharArray()) {
            freq[c - 'a']++;
        }

        return freq;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        
        for(String word: words2) {
            int[] freq = getFrequency(word);

            for(int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        
        List<String> result = new ArrayList<>();

        for(String word: words1) {
            int[] freq = getFrequency(word);

            if(isUniversal(freq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }
}
