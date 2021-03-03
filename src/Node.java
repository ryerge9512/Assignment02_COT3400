public class Node {
    private Node leftChild;
    private Node rightChild;
    private int data;

    public Node(Node leftChild, Node rightChild, int data){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild){
        this.rightChild = rightChild;
    }

    public Node getLeftChild(){
        return  leftChild;
    }

    public Node getRightChild(){
        return rightChild;
    }

    public int getData(){
        return data;
    }
}
