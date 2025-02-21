// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

class FindElements {

    HashSet<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        traverse(root, 0);
    }

    public boolean find(int number) {
        return values.contains(number);
    }

    private void traverse(TreeNode node, int value) {
        if (node == null) return;
        values.add(value);
        traverse(node.left, value * 2 + 1);
        traverse(node.right, value * 2 + 2);
    }
}
