package trees;

public class BuildKaryTreeFromPreOrder {

    public class KaryTreeNode {
        public int data;
        public KaryTreeNode[] child;
        public KaryTreeNode(int k) {
            child = new KaryTreeNode[k];
        }
        public void setChild(int index, KaryTreeNode node) {
            child[index] = node;
        }

        public KaryTreeNode getChild(int index) {
            return child[index];
        }
    }

    public class Index {
        public int index;
    }

    private Index index = new Index();

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4};
        BuildKaryTreeFromPreOrder buildKaryTreeFromPreOrder = new BuildKaryTreeFromPreOrder();
        KaryTreeNode naryTree = buildKaryTreeFromPreOrder.buildKaryTree(preOrder, preOrder.length, 3);
        System.out.println(naryTree);
    }

    public KaryTreeNode buildKaryTree(int[] preorder, int n, int k) {
        if (n==0) {
            return null;
        }
        KaryTreeNode newNode = new KaryTreeNode(k);
        newNode.data = preorder[index.index];
        for(int i=0;i<k;i++) {
            if(k*index.index+1<n) {
                index.index += 1;
                newNode.setChild(i, buildKaryTree(preorder, n, k));
            }
        }
        return newNode;
    }

}
