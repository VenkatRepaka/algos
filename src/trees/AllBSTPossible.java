package trees;

import java.util.ArrayList;
import java.util.List;

public class AllBSTPossible {

    public static void main(String[] args) {
        AllBSTPossible allBSTPossible  = new AllBSTPossible();
        int n = 4;
        int solutions[] = new int[n];
        for(int i=0;i<n;i++) {
            solutions[i] = -1;
        }
        int possibilities = allBSTPossible.computePossibilities(n, solutions);
        System.out.println("Possibilities: " + possibilities);

        List<BinaryNode> allPossibleBSTs = allBSTPossible.constructTrees(1, n);
        System.out.println("Possibilities: " + allPossibleBSTs.size());
    }

    public int computePossibilities(int n, int[] solutions) {
        if(n < 0) {
            return 0;
        }
        if(n == 0 || n == 1) {
            return 1;
        }
        int possibilities = 0;
        for(int i=0;i<n;i++) {
            if(solutions[i] == -1) {
                solutions[i] = computePossibilities(i, solutions);
            }
            if(solutions[n-1-i] == -1) {
                solutions[n-i-1] = computePossibilities(n-i-1, solutions);
            }
            possibilities += solutions[i] * solutions[n-i-1];
        }
        return possibilities;
    }

    public List<BinaryNode> constructTrees(int start, int end) {
        List<BinaryNode> nodes = new ArrayList<>();
        if(start > end) {
            nodes.add(null);
            return nodes;
        }
        for(int i=start; i<=end;i++) {
            List<BinaryNode> leftSubTree = constructTrees(start, i-1);
            List<BinaryNode> rightSubTree = constructTrees(i+1, end);
            for(int j=0;j<leftSubTree.size();j++) {
                BinaryNode left = leftSubTree.get(j);
                for(int k=0;k<rightSubTree.size();k++) {
                    BinaryNode right = rightSubTree.get(k);
                    BinaryNode node = new BinaryNode(i);
                    node.left = left;
                    node.right = right;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }

}
