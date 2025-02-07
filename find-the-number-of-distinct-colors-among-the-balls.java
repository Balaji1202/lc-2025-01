// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/

public class Solution {

    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        
        // Map to track the count of balls for each color
        Map<Integer, Integer> colorCount = new HashMap<>();
        
        // Map to store the color assigned to each ball
        Map<Integer, Integer> ballColor = new HashMap<>();

        // Process each query
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // If the ball has been assigned a color already
            if (ballColor.containsKey(ball)) {
                int prevColor = ballColor.get(ball);
                // Decrease the count of the previous color
                colorCount.computeIfPresent(prevColor, (k, v) -> v - 1);
                
                // If there are no more balls with the previous color, remove it from the map
                if (colorCount.getOrDefault(prevColor, 0) == 0) {
                    colorCount.remove(prevColor);
                }
            }

            // Assign the new color to the ball
            ballColor.put(ball, color);

            // Increase the count of the new color
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            // The result for this query is the number of distinct colors in use
            result[i] = colorCount.size();
        }

        return result;
    }
}
