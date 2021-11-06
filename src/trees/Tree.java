package trees;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class Tree {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();

        System.out.println("Height: " + height(root));

        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    private static Node createTree() {
        Node root;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) return null;

        root = new Node(data);

        System.out.println("Enter left of " + data);
        root.left = createTree();

        System.out.println("Enter right of " + data);
        root.right = createTree();

        return root;
    }

    public static int height(Node root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;

        return (Math.max(height(root.left), height(root.right)) + 1);
    }

    static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
