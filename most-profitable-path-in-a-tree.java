// https://leetcode.com/problems/most-profitable-path-in-a-tree/

class Solution {

    public int mostProfitablePath(int[][] connections, int target, int[] values) {
        int nodes = values.length, result = Integer.MIN_VALUE;
        graph = new ArrayList<>();
        targetPath = new HashMap<>();
        visitedNodes = new boolean[nodes];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 0 });
        
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        findTargetPath(target, 0);

        Arrays.fill(visitedNodes, false);
        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int node = currentNode[0], step = currentNode[1], profit = currentNode[2];

            if (!targetPath.containsKey(node) || step < targetPath.get(node)) {
                profit += values[node];
            } else if (step == targetPath.get(node)) {
                profit += values[node] / 2;
            }

            if (graph.get(node).size() == 1 && node != 0) {
                result = Math.max(result, profit);
            }

            for (int neighbor : graph.get(node)) {
                if (!visitedNodes[neighbor]) {
                    queue.add(new int[] { neighbor, step + 1, profit });
                }
            }

            visitedNodes[node] = true;
        }
        return result;
    }

    private Map<Integer, Integer> targetPath;
    private boolean[] visitedNodes;
    private List<List<Integer>> graph;

    private boolean findTargetPath(int currentNode, int step) {
        targetPath.put(currentNode, step);
        visitedNodes[currentNode] = true;

        if (currentNode == 0) {
            return true;
        }

        for (int neighbor : graph.get(currentNode)) {
            if (!visitedNodes[neighbor]) {
                if (findTargetPath(neighbor, step + 1)) {
                    return true;
                }
            }
        }
        targetPath.remove(currentNode);
        return false;
    }
}
