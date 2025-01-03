// https://leetcode.com/problems/maximum-score-after-splitting-a-string

class Solution {
    public static HashMap<Character, Integer> getCharMap(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if(map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) + 1);
            } else {
                map.put(currentChar, 1);
            }
        }

        return map;
    }

    public static int getScore(String s1, String s2) {
        HashMap<Character, Integer> s1Map = getCharMap(s1);
        HashMap<Character, Integer> s2Map = getCharMap(s2);

        int scoreS1 = s1Map.getOrDefault('0', 0);
        int scoreS2 = s2Map.getOrDefault('1', 0);

        return scoreS1 + scoreS2;
    }

    public int maxScore(String s) {
        int max = Integer.MIN_VALUE;

        for(int i = 1; i < s.length(); i++) {
            int score = getScore(s.substring(0, i), s.substring(i, s.length()));

            if(score > max) {
                max = score;
            }
        }

        return max;
    }
}
