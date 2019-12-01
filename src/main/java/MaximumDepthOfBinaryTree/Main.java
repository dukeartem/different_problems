package MaximumDepthOfBinaryTree;

public class Main {

    public static void main(String[] argc) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        System.out.println(maxDepth(root, 1));

        TreeNode rootSecond = new TreeNode(1);
        rootSecond.left = new TreeNode(2);
        System.out.println(maxDepth(rootSecond, 1));
    }


    private static int maxDepth(TreeNode root, int depth) {
        int depthR = 1;
        int depthL = 1;

        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return depth;
        }
        if (root.left != null) {
            depthL = maxDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            depthR = maxDepth(root.right, depth + 1);
        }
        if (depthL > depthR) {
            depth = depthL;
        } else {
            depth = depthR;
        }

        return depth;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
