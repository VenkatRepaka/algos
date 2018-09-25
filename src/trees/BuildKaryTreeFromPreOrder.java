package trees;

import java.util.ArrayList;
import java.util.List;

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
        // int[] preOrder = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4};
        // int[] preOrder = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4, 11, 12, 13};
        int[] preOrder = {1, 2, 5, 14, 15, 16, 6, 7, 3, 8, 9, 10, 4, 11, 12, 13};
        // int[] preOrder = {1, 2, 5, 6, 7, 3, 4};
        // int[] preOrder = {1, 2, 3, 4};
        BuildKaryTreeFromPreOrder buildKaryTreeFromPreOrder = new BuildKaryTreeFromPreOrder();
        int height = buildKaryTreeFromPreOrder.minHeightOfTree(preOrder.length, 3);
        KaryTreeNode naryTree = buildKaryTreeFromPreOrder.buildKaryTree(preOrder, preOrder.length, 3, height, 1, new ArrayList<>());
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

    public KaryTreeNode buildKaryTree(int[] pre, int n, int k, int maxHeight, int depth, List<Integer> positional) {
        if(index.index >= n) {
            return null;
        }
        KaryTreeNode newNode = new KaryTreeNode(k);
        newNode.data = pre[index.index];
        int maximumNoOfNodesCurrentDepth = maxNoOfNodesCurrentHeight(depth, k);
        int totalNodes = maximumNoOfNodesCurrentDepth + childLastSize(positional, k);
        for(int i=0;i<k;i++) {
            if(depth < maxHeight && totalNodes <= n) {
                index.index += 1;
                positional.add(i+1);
                newNode.setChild(i, buildKaryTree(pre, n, k, maxHeight, depth + 1, positional));
                positional.remove(positional.size()-1);
            }
        }
        return newNode;
    }

    private int childLastSize(List<Integer> pos, int k) {
        int sum = 0;
        for(int i=0;i<pos.size();i++) {
            if(i == pos.size()-1) {
                sum += k*pos.get(i);
            }
            else
                /*if(pos.get(i) != 1) {
                    sum += (int) Math.pow(k, pos.get(i));
                }*/
                if(pos.get(i) == 2) {
                    sum += (int) Math.pow(k, pos.size() - i);
                }
                else if(pos.get(i) == 3) {
                    sum += (int) Math.pow(k, pos.size() - i) * 3;
                }
        }
        return sum;
    }

}
