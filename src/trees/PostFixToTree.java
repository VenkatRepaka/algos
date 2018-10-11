package trees;

import java.util.Stack;

public class PostFixToTree {

    public static void main(String[] args) {
        PostFixToTree postFixToTree = new PostFixToTree();
        BinaryNode root = postFixToTree.generateTree("ab+ef*g*-".toCharArray());
        postFixToTree.printInOrderTraversal(root);
    }

    public BinaryNode generateTree(char[] pos) {
        Stack<BinaryNode> stack = new Stack<>();
        for(int i=0;i<pos.length;i++) {
            BinaryNode node = new BinaryNode(pos[i]);
            if(!isOperator(node.charData)) {
                stack.push(node);
            }
            else {
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }
        }
        return stack.pop();
    }

    public boolean isOperator(char item) {
        if(item == '+' || item == '-' || item == '*' ||
                item == '/') {
            return true;
        }
        return false;
    }

    public void printInOrderTraversal(BinaryNode root) {
        if(root != null) {
            printInOrderTraversal(root.left);
            System.out.println(root.charData);
            printInOrderTraversal(root.right);
        }
    }

}
