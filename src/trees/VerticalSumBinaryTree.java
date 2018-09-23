package trees;

import java.util.HashMap;
import java.util.Map;

public class VerticalSumBinaryTree {

    public static void main(String[] args) {
        VerticalSumBinaryTree verticalSumBinaryTree = new VerticalSumBinaryTree();
        BinaryNode head = TreeDataGenerator.generateBinaryTree();
        verticalSumBinaryTree.verticalSum(head);
    }

    public void verticalSum(BinaryNode node) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        vSum(node, sumMap, 0);
        sumMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        });
    }

    public void vSum(BinaryNode node, Map<Integer, Integer> sumMap, int column) {
        if(node == null) {
            return;
        }
        if(sumMap.get(column) == null) {
            sumMap.put(column, 0);
        }
        sumMap.put(column, node.data+sumMap.get(column));
        vSum(node.left, sumMap, column-1);
        vSum(node.right, sumMap, column+1);
    }

}
