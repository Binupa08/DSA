import java.util.Scanner;

class AVLNode {
    int data, height;
    AVLNode left, right;

    AVLNode(int value) {
        data = value;
        height = 1;
    }
}

public class AVLTree {

    AVLNode root;

    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        y.left = x.right;
        x.right = y;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        x.right = y.left;
        y.left = x;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    AVLNode insert(AVLNode node, int value) {
        if (node == null)
            return new AVLNode(value);

        if (value < node.data)
            node.left = insert(node.left, value);
        else
            node.right = insert(node.right, value);

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left
        if (balance > 1 && value < node.left.data)
            return rightRotate(node);

        // Right Right
        if (balance < -1 && value > node.right.data)
            return leftRotate(node);

        return node;
    }

    void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            tree.root = tree.insert(tree.root, sc.nextInt());
        }

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);

        sc.close();
    }
}
