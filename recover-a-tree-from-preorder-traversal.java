// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

public class Solution {

    static int pos = 0;

    public TreeNode recoverFromPreorder(String str) {
        pos = 0;
        return constructTree(str, 0);
    }

    private TreeNode constructTree(String str, int level) {
        if (pos >= str.length()) return null;
        int dashCount = 0;
        while (
            (pos + dashCount) < str.length() &&
            str.charAt(pos + dashCount) == '-'
        ) {
            dashCount++;
        }

        if (dashCount != level) return null;

        pos += dashCount;

        int val = 0;
        while (
            pos < str.length() &&
            Character.isDigit(str.charAt(pos))
        ) {
            val = val * 10 + (str.charAt(pos++) - '0');
        }

        TreeNode node = new TreeNode(val);

        node.left = constructTree(str, level + 1);
        node.right = constructTree(str, level + 1);

        return node;
    }
}
