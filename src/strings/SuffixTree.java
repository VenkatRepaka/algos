package strings;

import java.util.HashMap;
import java.util.Map;


// Reference https://nbviewer.jupyter.org/gist/BenLangmead/6665861
public class SuffixTree {

    private Node root;

    public static class Node {
        String label;
        Map<Character, Node> out;

        public Node(String label) {
            this.label = label;
            out = new HashMap<>();
        }
    }

    public SuffixTree(String data) {
        // Add $ to end of input string
        data += '$';
        // Add an empty root node.
        root = new Node(null);
        // Add a child node with full input string for first character of the string
        root.out.put(data.charAt(0), new Node(data));
        // j & k are used to check if the substring is same or has a point for a new sub string
        int j=0, k=0;
        Node child = null;
        Node currNode = null;
        String label;
        for(int i=1;i<data.length();i++) {
            // At the beginning in the loop, set current node to root node
            currNode = root;
            j = i;
            while(j < data.length()) {
                if(currNode.out.containsKey(data.charAt(j))) {
                    // Get the existing child for a given character
                    child = currNode.out.get(data.charAt(j));
                    label = child.label;
                    // Traverse the path to check if label and substring are same.
                    k = j+1;
                    while(k-j<label.length() && data.charAt(k) == label.charAt(k-j)) {
                        k += 1;
                    }
                    // If label is part of substring
                    if(k-j == label.length()) {
                        currNode = child;
                        j = k;
                    }
                    else {
                        // A sub string id repeated. i.e  there is a break point
                        // repeated characters. start of the repeated characters.
                        char existingChar = label.charAt(k-j);
                        // Break occurred
                        char newChar = data.charAt(k);
                        // Middle node contains the repeated first characters
                        Node midNode = new Node(label.substring(0, k-j));
                        // for the middle node assign child node of new character
                        midNode.out.put(newChar, new Node(data.substring(k)));
                        // for the existing character assign the node which was earlier for the same character
                        midNode.out.put(existingChar, child);
                        // Reassign new label
                        child.label = label.substring(k-j);
                        // change the current node to middle node
                        currNode.out.put(data.charAt(j), midNode);
                        break;
                    }
                }
                else {
                    currNode.out.put(data.charAt(j), new Node(data.substring(j)));
                }
            }
        }
    }

    private Map<String, Object> followPath(String input) {
        Node cur = this.root, child = null;
        int j;
        for(int i=0;i<input.length();) {
            char c = input.charAt(i);
            if(!cur.out.containsKey(c)) {
                break;
            }
            child = cur.out.get(c);
            String label = child.label;
            j = i+1;
            while (j-i < label.length() && j < input.length() && input.charAt(j) == label.charAt(j-i)) {
                j += 1;
            }
            if(j-i == label.length()) {
                cur = child;
                i = j;
            }
            else if(j == label.length()) {
                return Map.of("node", child, "off", j-i);
            }
            else {
                return null;
            }

        }
        return Map.of("node", cur, "off", -100);
    }

    public boolean hasSubString(String input) {
        Map<String, Object> resp = followPath(input);
        return resp != null && resp.get("node") != null;
    }

    public boolean hasSuffix(String input) {
        Map<String, Object> resp = followPath(input);
        Node node = (Node) resp.get("node");
        Integer off = (Integer)resp.get("off");
        if (node == null){
            return Boolean.FALSE;
        }
        if(off == -100) {
            return node.out.containsKey('$');
        }
        else {
            return node.label.charAt(off) == '$';
        }
    }

    public static void main(String[] args) {
        SuffixTree suffixTree = new SuffixTree("banana");
        // System.out.println(suffixTree.hasSubString("an"));
        System.out.println(suffixTree.hasSuffix("ana"));
    }

}
