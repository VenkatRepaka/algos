package trees;

public class AVLTree {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        BinaryNode root = null;
        root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);
    }

    public BinaryNode insert(BinaryNode root, int data) {
        if(root == null) {
            return new BinaryNode(data);
        }
        if(data < root.data) {
            root.left = insert(root.left, data);
        }
        else {
            root.left = insert(root.left, data);
        }
        int balance = balance(root);
        if(balance > 1) {
            if(height(root.left.left) > height(root.left.right)) {
                root = rightRotate(root);
            }
            else {
                root.left = leftRotate(root);
                root = rightRotate(root);
            }
        }
        else if(balance < -1) {
            if(height(root.right.right) > height(root.right.left)) {
                root = leftRotate(root);
            }
            else {
                root.right = rightRotate(root);
                root = leftRotate(root);
            }
        }
        return root;
    }

    private int height(BinaryNode node) {
        return node == null ? 0 : node.height;
    }

    public int balance(BinaryNode node) {
        return height(node.left) - height(node.right);
    }

    private int getHeight(BinaryNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
    }

    private BinaryNode leftRotate(BinaryNode root) {
        BinaryNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = getHeight(root);
        newRoot.height = getHeight(newRoot);
        return newRoot;
    }

    private BinaryNode rightRotate(BinaryNode root) {
        BinaryNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = getHeight(root);
        newRoot.height = getHeight(newRoot);
        return newRoot;
    }

}
