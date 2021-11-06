package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversals_Iterative {

    // PreOrder Traversal
    public static void preOrder(Node root) {
        if (root == null) return;

        Stack<Node> stk = new Stack<>();
        stk.push(root);

        Node curr;
        while (!stk.isEmpty()) {
            curr = stk.pop();
            System.out.print(curr.data + " ");

            if (curr.right != null) stk.push(curr.right);
            if (curr.left != null) stk.push(curr.left);
        }
    }

    // InOrder Traversal
    public static void inOrder(Node root) {
        if (root == null) return;

        Stack<Node> stk = new Stack<>();
        Node curr = root;

        while (!stk.isEmpty() || curr != null) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }

            curr = stk.pop();
            System.out.print(curr.data + " ");

            curr = curr.right;
        }
    }

    // PostOrder Traversal
    public static void postOrder(Node root) {
        if (root == null) return;

        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();
        stk1.push(root);

        Node curr;
        while (!stk1.isEmpty()) {
            curr = stk1.pop();
            stk2.push(curr);

            if (curr.left != null) stk1.push(curr.left);
            if (curr.right != null) stk1.push(curr.right);
        }

        while (!stk2.isEmpty()) {
            System.out.print(stk2.pop().data + " ");
        }
    }

    // LevelOrder Traversal
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Node curr;
        while (!q.isEmpty()) {
            curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }
}
