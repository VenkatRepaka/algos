package trees;

public class TreeDataGenerator {

    public static BinaryNode generateBinaryTree() {
        BinaryNode head = new BinaryNode();
        head.data = 1;
        BinaryNode curr = null;
        BinaryNode node = new BinaryNode();
        node.data = 2;
        head.left = node;
        curr = head.left;
        node = new BinaryNode();
        node.data = 4;
        curr.left = node;
        node = new BinaryNode();
        node.data = 5;
        curr.right = node;
        node = new BinaryNode();
        node.data = 3;
        head.right = node;
        curr = head.right;
        node = new BinaryNode();
        node.data = 6;
        curr.left = node;
        node = new BinaryNode();
        node.data = 7;
        curr.right = node;
        return head;
    }

}
