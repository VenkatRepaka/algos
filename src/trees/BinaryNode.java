package trees;

public class BinaryNode {

    public BinaryNode() {
    }

    public BinaryNode(int data) {
        this.data = data;
    }
    public BinaryNode(char data) {
        this.charData = data;
    }

    public int data;
    public char charData;
    public BinaryNode left;
    public BinaryNode right;

}
