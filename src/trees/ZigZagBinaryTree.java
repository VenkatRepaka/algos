package trees;

import java.util.*;
import java.util.stream.Collectors;

public class ZigZagBinaryTree {

    public static void main(String[] args) {
        BinaryNode head = TreeDataGenerator.generateBinaryTree();
        ZigZagBinaryTree zigZagBinaryTree = new ZigZagBinaryTree();
        zigZagBinaryTree.printZigZag(head);
    }

    public void printZigZag(BinaryNode node) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.offer(node);
        queue.offer(null);
        List<List<Integer>> result = new ArrayList<>();
        List<BinaryNode> curr = new ArrayList<>();
        BinaryNode currData;
        Stack<BinaryNode> stack = new Stack<>();
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            currData = queue.poll();
            if(currData != null) {
                curr.add(currData);
                if(currData.left != null) {
                    queue.offer(currData.left);
                }
                if(currData.right != null) {
                    queue.offer(currData.right);
                }
            }
            else {
                if(leftToRight) {
                    result.add(curr.stream().map(n -> n.data).collect(Collectors.toList()));
                    curr.clear();
                }
                else {
                    stack.addAll(curr);
                    curr.clear();
                    while (!stack.isEmpty()) {
                        curr.add(stack.pop());
                    }
                    result.add(curr.stream().map(n -> n.data).collect(Collectors.toList()));
                    curr.clear();
                }
                if(!queue.isEmpty()) {
                    queue.offer(null);
                    leftToRight = !leftToRight;
                }
            }
        }
        System.out.println(result);
    }

}
