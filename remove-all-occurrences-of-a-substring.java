// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/

class Solution {

    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int targetStartIndex = s.indexOf(part);

            s = s.substring(0, targetStartIndex) + s.substring(targetStartIndex + part.length());
        }
        
        return s;
    }
}
