package classes;



public class Node {
    int data;
    Node  next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public boolean areIdentical(Node head1, Node head2) {
        Node i = head1;
        Node j = head2;
        while(i.next !=null && j.next!=null){
            int xor = i.data^j.data;
            if(xor!=0){
                return false;
            }

            i = i.next;
            j = j.next;

        }
        return true;
    }
}