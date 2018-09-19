package trees;

import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        BinaryNode head = TreeDataGenerator.generateBinaryTree();
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        // inOrderTraversal.inOrderTraversalRecursive(head);
        inOrderTraversal.inOrderTraversalIterative(head);
    }

    public void inOrderTraversalRecursive(BinaryNode node) {
        if(node != null) {
            inOrderTraversalRecursive(node.left);
            System.out.println(node.data);
            inOrderTraversalRecursive(node.right);
        }
    }

    public void inOrderTraversalIterative(BinaryNode node) {
        Stack<BinaryNode> stack = new Stack<>();
        while(true) {
            if(node != null) {
                stack.add(node);
                node = node.left;
            }
            else {
                if(stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }

}
