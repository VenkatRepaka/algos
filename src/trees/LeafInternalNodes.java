package trees;

import java.util.LinkedList;

public class LeafInternalNodes {

    public static void main(String[] args) {
        char[] arr = "ILILL".toCharArray();
        LeafInternalNodes leafInternalNodes = new LeafInternalNodes();
        leafInternalNodes.generateTree(arr);
    }

    public BinaryNode generateTree(char[] arr) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i=0;i<arr.length;i++) {
            linkedList.offer(Character.valueOf(arr[i]));
        }
        BinaryNode root = generateTreeUtil(linkedList);
        return root;
    }

    public BinaryNode generateTreeUtil(LinkedList<Character> linkedList) {
        if(linkedList.isEmpty()) {
            return null;
        }
        Character charData = linkedList.removeFirst();
        BinaryNode node = new BinaryNode(charData);
        if (charData == 'I') {
            node.left = generateTreeUtil(linkedList);
            node.right = generateTreeUtil(linkedList);
        }
        return node;
    }



}
