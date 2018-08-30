package ll;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node head = reverseLinkedList.generateData();
        head = reverseLinkedList.reverseLinkedList(head);
        head.print();
    }

    public Node reverseLinkedList(Node head) {
        Node temp = null, nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = temp;
            temp = head;
            head = nextNode;
        }
        return temp;
    }

    public Node generateData() {
        Node currNode = new Node(1);
        Node head = currNode;
        currNode.next = new Node(2);
        currNode = currNode.next;
        currNode.next = new Node(3);
        currNode = currNode.next;
        currNode.next = new Node(4);
        currNode = currNode.next;
        currNode.next = new Node(5);
        return head;
    }

}
