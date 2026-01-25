import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinarySearchTree {

    Node root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insertRec(root.left, value);
        else
            root.right = insertRec(root.right, value);

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }

        System.out.println("Inorder traversal:");
        bst.inorder(bst.root);

        sc.close();
    }
}
