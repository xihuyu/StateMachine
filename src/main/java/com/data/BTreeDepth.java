package com.data;

/**
 * @version V1.0
 * @description: 二叉树的高度
 * 分析：先遍历根节点左子树的高度，然后遍历右子树高度，比较，得出最大值
 * @author: fenggaopan
 * @date: 2020-06-16 15:09:53
 */
public class BTreeDepth {

    /**
     *
     * @param root
     * @return 获取树的最高度
     */
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return 0;
        if(root.left != null && root.right != null) {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            depth = Math.max(l, r) + 1;
        } else if(root.left == null) {
            depth = maxDepth(root.right) + 1;
        } else if(root.right == null) {
            depth = maxDepth(root.left) + 1;
        } else {
            depth = 0;
        }
        return depth;
    }
}

/**
 * 二叉树节点类
 */
class TreeNode {
    private int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
