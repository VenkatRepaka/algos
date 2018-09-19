package trees;

import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {
        BinaryNode head = TreeDataGenerator.generateBinaryTree();
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        // preOrderTraversal.preOrderTraversalRecursive(head);
        preOrderTraversal.preOrderTraversalIterative(head);
    }

    public void preOrderTraversalRecursive(BinaryNode head) {
        if(head == null)
            return;
        System.out.println(head.data);
        preOrderTraversalRecursive(head.left);
        preOrderTraversalRecursive(head.right);
    }

    public void preOrderTraversalIterative(BinaryNode head) {
        Stack<BinaryNode> nodeStack = new Stack<>();
        BinaryNode currNode;
        nodeStack.push(head);
        while (!nodeStack.isEmpty()) {
            currNode = nodeStack.pop();
            System.out.println(currNode.data);
            if(currNode.right != null) {
                nodeStack.push(currNode.right);
            }
            if(currNode.left != null) {
                nodeStack.push(currNode.left);
            }
        }
    }

}
