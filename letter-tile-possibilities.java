// https://leetcode.com/problems/letter-tile-possibilities/

class Solution {

    public int numTilePossibilities(String str) {
        Set<String> result = new HashSet<>();
        int length = str.length();
        boolean[] visited = new boolean[length];

        findCombinations(str, "", visited, result);

        return result.size() - 1;
    }

    public void findCombinations(
        String str,
        String currentCombination,
        boolean[] visited,
        Set<String> result
    ) {
        result.add(currentCombination);

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                findCombinations(
                    str,
                    currentCombination + str.charAt(i),
                    visited,
                    result
                );
                visited[i] = false;
            }
        }
    }
}
