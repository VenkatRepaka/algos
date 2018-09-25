package trees;

/*
 This only works for height 3. Have to fix to figure out solution for any height.
 */
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

        public void setChild(KaryTreeNode[] child) {
            this.child = child;
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
        // int[] preOrder = {1, 2, 5, 6, 7, 3, 4};
        // int[] preOrder = {1, 2, 3, 4};
        BuildKaryTreeFromPreOrder buildKaryTreeFromPreOrder = new BuildKaryTreeFromPreOrder();
        int height = buildKaryTreeFromPreOrder.minHeightOfTree(preOrder.length, 3);
        KaryTreeNode naryTree = buildKaryTreeFromPreOrder.buildKaryTree(preOrder, preOrder.length, 3, height, 1, height);
        System.out.println(naryTree);
    }

    public int minHeightOfTree(int noOfNodes, int k) {
        return (int)Math.ceil((Math.log((double)noOfNodes*(k-1)+1))/Math.log((double)k));
    }

    public int maxNoOfNodesCurrentHeight(int height, int k) {
        if(height == 1) {
            return 1;
        }
        return ((int)Math.pow(k, height) - 1)/(k-1);
    }

    public KaryTreeNode buildKaryTree(int[] pre, int n, int k, int height, int nodeNumber, int maxHeight) {
        if (n==0) {
            return null;
        }
        KaryTreeNode newNode = new KaryTreeNode(k);
        newNode.data = pre[index.index];
        int newNodeNumber = 0;
        for (int i=0;i<k;i++) {
            // if(index.index < n-1 && height > 1 && nodeNumber < n) {
            int maxNumberOfNodesAtThisHeight = maxNoOfNodesCurrentHeight(maxHeight - height + 1, k);
            newNodeNumber = maxNumberOfNodesAtThisHeight + 1 + i * (int)Math.pow(k, maxHeight - height);
            // newNodeNumber = nodeNumber+(int)Math.pow(k, maxHeight-height)+i;
            if(height > 1 && newNodeNumber < n) {
                index.index += 1;
                newNode.child[i] = buildKaryTree(pre, n, k, height-1, newNodeNumber, maxHeight);
            }
            else {
                newNode.setChild(null);
            }
        }
        return newNode;
    }

}
