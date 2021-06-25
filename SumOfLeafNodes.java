class Node {
    private int data;
    private Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class BinarySearchTree {
    private Node root;

    public void insert(int data) {
        Node node = new Node(data);
        Node parent = null, tmp = root;

        if (root == null) {
            root = node;
            return;
        }

        while (tmp != null) {
            parent = tmp;
            if (node.getData() < tmp.getData())
                tmp = tmp.getLeft();
            else
                tmp = tmp.getRight();
        }

        if (node.getData() < parent.getData())
            parent.setLeft(node);
        else
            parent.setRight(node);
    }

    public void display() {
        inorder(root);

        System.out.println();

        System.out.println(sumOfLeafNodes(root));
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder(root.getRight());
        }
    }

    public int sumOfLeafNodes(Node root) {
        if (root == null)
            return 0;

        if (root.getLeft() == null && root.getRight() == null)
            return root.getData();

        return sumOfLeafNodes(root.getLeft()) + sumOfLeafNodes(root.getRight());
    }
}


public class SumOfLeafNodes {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(100);
        tree.insert(20);
        tree.insert(500);
        tree.display();
    }
}
