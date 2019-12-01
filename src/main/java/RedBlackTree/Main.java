package RedBlackTree;

public class Main {

    public static void main(String[] argc) {
        int[] numOne = new int[]{-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(numOne)); //[0,-3,9,-10,null,5]

    }

    //TODO клёвая визуализация https://www.cs.usfca.edu/~galles/visualization/RedBlack.html

    private static TreeNode insertNewValue(TreeNode treeNode, int value) {
        if (treeNode == null) {
            return new TreeNode(value, 1 , RED);
        }

        if (value < treeNode.val) {
            treeNode.left = insertNewValue(treeNode.left, value);
        } else if (value > treeNode.val) {
            treeNode.right = insertNewValue(treeNode.right, value);
        } else {
            treeNode.val = value;
        }

        if(isRed(treeNode.right) && !isRed(treeNode.left)) {
            treeNode = rotateLeft(treeNode);
        }
        if(isRed(treeNode.left) && isRed(treeNode.left.left)) {
            treeNode = rotateRight(treeNode);
        }
        if(isRed(treeNode.left) && isRed(treeNode.right)) {
            TreeNode.flipColors(treeNode);
        }

        treeNode.N = size(treeNode.left) + size(treeNode.right) + 1;
        return treeNode;

    }

    private static TreeNode sortedArrayToBST(int[] nums) {
//        TreeNode treeNode = new TreeNode(nums[0]);
//        for (int i = 1; i < nums.length; i++) {
//            treeNode = insertNewValue(treeNode, nums[i]);
//        }
//

        TreeNode root = new TreeNode(nums[0], 1, RED);
        for (int i = 1; i < nums.length; i++) {
            root = insertNewValue(root, nums[i]);
            root.color = BLACK;
        }

        inorderRec(root);
        return root;

    }



    private static void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.val);
            inorderRec(root.right);
        }
    }



    private static int size(TreeNode x) {
        if (x == null) return 0;
        else return x.N;
    }

    private static TreeNode rotateLeft(TreeNode h) {
        TreeNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private static TreeNode rotateRight(TreeNode h) {
        TreeNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private static boolean isRed(TreeNode x) {
        return x != null;
    }

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private static class TreeNode {
        int val;        //значение
        TreeNode left;  //левое поддерево
        TreeNode right; //правое поддерево
        int N;          //кол-во узлов в данном поддереве
        boolean color;  //цвет ссылки на данный узел

        TreeNode(int val, int N, boolean color) {
            this.val = val;
            this.N = N;
            this.color = color;
        }

        private static void flipColors(TreeNode h) {
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }
    }
}
