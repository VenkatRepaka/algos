package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        BinaryNode head = TreeDataGenerator.generateBinaryTree();
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        traversal.levelOrderTraversal(head);
    }

    public void levelOrderTraversal(BinaryNode head) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.offer(head);
        queue.offer(null);
        BinaryNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if(temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            else if (!queue.isEmpty()){
                queue.offer(null);
                System.out.println();
            }
        }
    }

}
