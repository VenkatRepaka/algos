package trees;

public class BinaryTreeDiameter {

    public static void main(String[] args) {
        // BinaryNode head = TreeDataGenerator.generateBinaryTree();
        BinaryTreeDiameter diameter = new BinaryTreeDiameter();
        BinaryNode head = diameter.generateData1();
//        System.out.println(diameter.getDiameter(head));
        System.out.println(diameter.getDiameterHeightOptimized(head, new Height()));
    }

    int diameter = 0;

    /*public int getDiameter(BinaryNode node) {
        int left, right;
        if(node == null) {
            return 0;
        }
        left = getDiameter(node.left);
        right = getDiameter(node.right);
        if(left + right > diameter) {
            diameter = left + right;
        }
        return Math.max(left, right) + 1;
    }*/

    public static class Height {
        public int height;
    }

    public int getDiameterHeightOptimized(BinaryNode node, Height height) {
        if(node == null) {
            return 0;
        }
        Height lHeight = new Height();
        Height rHeight = new Height();
        int lDiameter = getDiameterHeightOptimized(node.left, lHeight);
        int rDiameter = getDiameterHeightOptimized(node.right, rHeight);
        height.height = Math.max(lHeight.height, rHeight.height) + 1;
        int finalDiameter = Math.max(lHeight.height + rHeight.height + 1, Math.max(lDiameter, rDiameter));
        return finalDiameter;
    }

    public int getDiameter(BinaryNode node) {
        if(node == null) {
            return 0;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        int lDiameter = getDiameter(node.left);
        int rDiameter = getDiameter(node.right);
        int finalDiameter = Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
        return finalDiameter;
    }

    public int height(BinaryNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public BinaryNode generateData1() {
        BinaryNode head = new BinaryNode(1);
        head.right = new BinaryNode(7);
        head.right.right = new BinaryNode(8);
        head.right.right.right = new BinaryNode(9);
        head.right.right.right.right = new BinaryNode(10);
        head.right.right.right.left = new BinaryNode(11);
        head.right.right.right.left.left = new BinaryNode(12);
        head.right.right.right.left.right = new BinaryNode(13);
        head.left = new BinaryNode(2);
        head.left.left = new BinaryNode(3);
        head.left.right = new BinaryNode(4);
        head.left.right.left = new BinaryNode(5);
        head.left.right.right = new BinaryNode(6);
        return head;
    }

}
