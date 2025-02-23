// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

class Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int totalNodes = preorder.length;
        return constructBinaryTree(0, totalNodes - 1, 0, preorder, postorder);
    }

    private TreeNode constructBinaryTree(
        int preStartIdx,
        int preEndIdx,
        int postStartIdx,
        int[] preorder,
        int[] postorder
    ) {
        if (preStartIdx > preEndIdx) return null;

        if (preStartIdx == preEndIdx) {
            return new TreeNode(preorder[preStartIdx]);
        }

        int leftChildRoot = preorder[preStartIdx + 1];
        int leftSubtreeSize = 1;
        while (postorder[postStartIdx + leftSubtreeSize - 1] != leftChildRoot) {
            leftSubtreeSize++;
        }

        TreeNode currentNode = new TreeNode(preorder[preStartIdx]);

        currentNode.left = constructBinaryTree(
            preStartIdx + 1,
            preStartIdx + leftSubtreeSize,
            postStartIdx,
            preorder,
            postorder
        );

        currentNode.right = constructBinaryTree(
            preStartIdx + leftSubtreeSize + 1,
            preEndIdx,
            postStartIdx + leftSubtreeSize,
            preorder,
            postorder
        );

        return currentNode;
    }
}
