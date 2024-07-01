package Trees;

public class BinaryTree {
    public int data;
    public BinaryTree leftChild;
    public BinaryTree rightChild;

    public BinaryTree(int item){
        this.data = item;
        this.rightChild = null;
        this.leftChild = null;
    }

    public BinaryTree binaryTreeFromArray(int []  arr){
        BinaryTree root = new BinaryTree(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            BinaryTree tempNode = new BinaryTree(arr[i]);
        }


        return root;
    }
}
