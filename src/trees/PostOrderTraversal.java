package trees;

import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {
        BinaryNode head = TreeDataGenerator.generateBinaryTree();
        PostOrderTraversal traversal = new PostOrderTraversal();
        // traversal.postOrderTraversalRecursive(head);
        traversal.postOrderTraversalIterative(head);
    }

    public void postOrderTraversalRecursive(BinaryNode node) {
        if(node != null) {
            postOrderTraversalRecursive(node.left);
            postOrderTraversalRecursive(node.right);
            System.out.println(node.data);
        }
    }

    public void postOrderTraversalIterative(BinaryNode node) {
        BinaryNode curr = node;
        BinaryNode prev = null;
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(node);
        curr = curr.left;
        while(!stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                curr = stack.peek();
                if(curr.right != null && prev != curr.right) {
                    curr = curr.right;
                }
                else {
                    prev = stack.pop();
                    System.out.println(curr.data);
                    curr = null;
                }
            }
        }
    }

}
