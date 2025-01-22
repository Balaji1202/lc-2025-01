// https://leetcode.com/problems/map-of-highest-peak/

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] peaks = new int[m][n];
        for(int[] row: peaks) {
            Arrays.fill(row, -1);
        }


        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    peaks[i][j] = 0;
                }
            }
        }

        int peakHeight = 1;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++) {
                int[] currentCell = queue.poll();

                for(int d = 0; d < 4; d++) {
                    int neighborX = currentCell[0] + dx[d];
                    int neighborY = currentCell[1] + dy[d];
                    
                    if(isValidCell(neighborX, neighborY, m, n) &&
                        peaks[neighborX][neighborY] == -1
                    ) {
                        peaks[neighborX][neighborY] = peakHeight;
                        queue.add(new int[] {neighborX, neighborY });
                    }
                }
            }
            peakHeight++;
        }
        
        return peaks;
    }

    private boolean isValidCell(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
