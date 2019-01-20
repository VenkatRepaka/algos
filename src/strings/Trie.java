package strings;

import javax.swing.text.TabExpander;

public class Trie {

    final int ALPHABETS_SIZE = 26;
    private final TrieNode root = new TrieNode();

    private class TrieNode {
        private TrieNode[] children = new TrieNode[ALPHABETS_SIZE];
        private boolean endOfWord = false;

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public TrieNode getChildAtIndex(int index) {
            return children[index];
        }
    }

    public void insertNode(String key) {
        int index = 0;
        TrieNode currentNode = root;
        for(int i=0;i<key.length();i++) {
            index = key.charAt(i) - 'a';
            if(currentNode.getChildAtIndex(index) == null) {
                currentNode.getChildren()[index] = new TrieNode();
            }
            currentNode = currentNode.getChildren()[index];
        }
        currentNode.setEndOfWord(Boolean.TRUE);
    }

    public boolean searchPattern(String key) {
        int index = 0;
        TrieNode currentNode = root;
        for(int i=0;i<key.length();i++) {
            index = key.charAt(i) - 'a';
            currentNode = currentNode.getChildren()[index];
            if(currentNode == null) {
                return false;
            }
        }
        return currentNode != null && currentNode.isEndOfWord();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] patterns = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        for(int i=0;i<patterns.length;i++) {
            trie.insertNode(patterns[i]);
        }
        System.out.println(trie.searchPattern("the"));
        System.out.println(trie.searchPattern("ther"));
        System.out.println(trie.searchPattern("answ"));
        System.out.println(trie.searchPattern("answer"));
    }

}
