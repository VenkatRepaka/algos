package trees;

import java.util.*;

public class PathsOfGivenSum {

    public static void main(String[] args) {
        BinaryNode head = TreeDataGenerator.generateBinaryTree();
        PathsOfGivenSum paths = new PathsOfGivenSum();
        // paths.pathsOfGivenSum(head, new ArrayList<>(), 0, 7);
        paths.pathsOfGivenSum(head, 7);
    }

    public void pathsOfGivenSum(BinaryNode node, List<Integer> path, int sumPath, int sum) {
        if(node == null) {
            return;
        }
        path.add(node.data);
        sumPath = sumPath + node.data;
        if(sumPath == sum) {
            path.stream().forEach(System.out::print);
        }
        if(node.left != null) {
            pathsOfGivenSum(node.left, path, sumPath, sum);
            path.remove(path.size()-1);
        }
        if(node.right != null) {
            pathsOfGivenSum(node.right, path, sumPath, sum);
            path.remove(path.size()-1);
        }
    }

    public void pathsOfGivenSum(BinaryNode node, int sum) {
        Stack<BinaryNode> stack = new Stack<>();
        LinkedList<BinaryNode> path = new LinkedList<>();
        LinkedList<BinaryNode> parent = new LinkedList<>();
        parent.addFirst(null);
        stack.add(node);
        BinaryNode curr;
        int sumPath = 0;
        while(!stack.isEmpty()) {
            curr = stack.pop();
            path.add(curr);
            parent.removeLast();
            sumPath = sumPath + curr.data;
            if(sumPath == sum) {
                path.stream().forEach(nd -> System.out.print(nd.data));
                System.out.println();
            }
            if(curr.left == null && curr.right == null) {
                sumPath = sumPath - path.removeLast().data;
                if(!parent.isEmpty() && parent.getLast() != path.getLast()) {
                    sumPath = sumPath - path.removeLast().data;
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
