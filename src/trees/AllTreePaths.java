package trees;

import java.util.*;

public class AllTreePaths {

    public static void main(String[] args) {
        BinaryNode head = TreeDataGenerator.generateBinaryTree();
        AllTreePaths treePaths = new AllTreePaths();
        // treePaths.printAllPaths(head, new ArrayList<>(Arrays.asList(head.data)));
        treePaths.printAllPathsIterative(head);
    }

    public void printAllPaths(BinaryNode node, List<Integer> path) {
        if(node.left == null && node.right == null) {
            path.stream().forEach(System.out::print);
            System.out.println();
        }
        else {
            if(node.left != null) {
                path.add(node.left.data);
                printAllPaths(node.left, path);
                path.remove(path.size()-1);
            }
            if(node.right != null) {
                path.add(node.right.data);
                printAllPaths(node.right, path);
                path.remove(path.size() - 1);
            }
        }

    }

    public void printAllPathsIterative(BinaryNode head) {
        Stack<BinaryNode> stack = new Stack<>();
        LinkedList<BinaryNode> path = new LinkedList<>();
        LinkedList<BinaryNode> parent = new LinkedList<>();
        BinaryNode curr;
        stack.add(head);
        parent.add(null);
        while(!stack.isEmpty()) {
            curr = stack.pop();
            parent.removeLast();
            path.add(curr);
            if(curr.left == null && curr.right == null) {
                path.stream().forEach(d -> System.out.print(d.data + " "));
                System.out.println();
                path.removeLast();
                if(!parent.isEmpty()) {
                    while (parent.getLast() != path.getLast()) {
                        path.removeLast();
                    }
                }
            }
            if(curr.right != null) {
                stack.push(curr.right);
                parent.add(curr);
            }
            if(curr.left != null) {
                stack.push(curr.left);
                parent.add(curr);
            }
        }
    }

}
