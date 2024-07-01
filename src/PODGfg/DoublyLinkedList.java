package PODGfg;

public class DoublyLinkedList {
    int data;
    public DoublyLinkedList  next;
    public DoublyLinkedList prev;

    public DoublyLinkedList(){}
    public DoublyLinkedList(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }

    public DoublyLinkedList deleteNode(DoublyLinkedList head,int x){
        if (head == null) {
            return null;
        }

        DoublyLinkedList current = head;

        // Traverse to find the node with the given value x
        while (current != null && current.data != x) {
            current = current.next;
        }

        // If the node with value x is not found
        if (current == null) {
            printDLinkedList(head);
            return head;
        }

        // If the node to be deleted is the head node
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
            printDLinkedList(head);
            return head;
        }

        // If the node to be deleted is the last node
        if (current.next == null) {
            current.prev.next = null;
            printDLinkedList(head);
            return head;
        }

        // If the node to be deleted is in the middle
        current.prev.next = current.next;
        current.next.prev = current.prev;
        printDLinkedList(head);
        return head;

    }

    public void printDLinkedList(DoublyLinkedList head){
        DoublyLinkedList current = head;
        while (current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
