package ll;

public class ReverseLinkedListInPairs {

    public static void main(String[] args) {
        ReverseLinkedListInPairs reverseLinkedListInPairs = new ReverseLinkedListInPairs();
        Node linkedList = reverseLinkedListInPairs.generateData();
        // Node reversePairedLinkedList = reverseLinkedListInPairs.reverseInPairs(linkedList);
        // Node reversePairedLinkedList = reverseLinkedListInPairs.reverseInPairsRecursive(linkedList);
        Node reversePairedLinkedList = reverseLinkedListInPairs.reverseInPairs(linkedList, 3);
        reversePairedLinkedList.print();
    }

    public Node reverseInPairs(Node head, int size) {
        Node temp, nextNode, newHead = null, prevTail = null, prevHead = null;
        prevHead = head;
        while(head != null) {
            int i = size;
            temp = null;
            while(head != null && i > 0) {
                nextNode = head.next;
                head.next = temp;
                temp = head;
                head = nextNode;
                i--;
            }
            if(prevTail != null) {
                prevTail.next = temp;
            }
            if(newHead == null) {
                newHead = temp;
            }
            prevTail = prevHead;
            prevHead = head;
        }
        return newHead;
    }

    public Node reverseInPairs(Node head) {
        Node temp = null, newHead = null;
        while(head != null && head.next != null) {
            if(temp != null) {
                temp.next.next = head.next;
            }
            temp = head.next;
            head.next = temp.next;
            temp.next = head;
            if(newHead == null) {
                newHead = temp;
            }
            head = head.next;
        }
        return newHead;
    }

    public Node reverseInPairsRecursive(Node head) {

        if (head == null) {
            return null;
        }
        else if(head.next == null) {
            return head;
        }
        else {
            Node temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head.next = reverseInPairsRecursive(head.next);
            return temp;
        }
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
        currNode = currNode.next;
        currNode.next = new Node(6);
        currNode = currNode.next;
        currNode.next = new Node(7);
        return head;
    }

}
