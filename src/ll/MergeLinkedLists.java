package ll;

public class MergeLinkedLists {

    public static void main(String[] args) {
        Node currentNode = new Node(1);
        Node head1 = currentNode;
        currentNode.next = new Node(2);
        /*currentNode = currentNode.next;
        currentNode.next = new Node(3);
        currentNode = currentNode.next;
        currentNode.next = new Node(4);
        currentNode = currentNode.next;
        currentNode.next = new Node(5);
        currentNode = currentNode.next;
        currentNode.next = new Node(6);*/

        currentNode = new Node(3);
        Node head2 = currentNode;
        currentNode.next = new Node(4);
        /*currentNode = currentNode.next;
        currentNode.next = new Node(3);
        currentNode = currentNode.next;
        currentNode.next = new Node(4);
        currentNode = currentNode.next;
        currentNode.next = new Node(5);
        currentNode = currentNode.next;
        currentNode.next = new Node(6);*/
        MergeLinkedLists mergeLinkedLists = new MergeLinkedLists();
        Node merged = mergeLinkedLists.merge(head1, head2);
        merged.print();
    }

    public Node merge(Node head1, Node head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        Node head;
        if(head1.value < head2.value) {
            head = head1;
            head.next = merge(head1.next, head2);
        }
        else {
            head = head2;
            head.next = merge(head1, head2.next);
        }
        return head;
    }

}
