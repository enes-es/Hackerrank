import java.util.*;
import java.io.*;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    public static int getHeight(Node root) {
        // code assumes height of single node is -1 and not 0.
        // thus, the recurisve algorithm is as follows.
        // simplest case: no child, return -1;
        // iteratice case: if child, return 1 (this node) plus the taller of the
        // children

        if (root == null)
            return -1;

        else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            int tallerChildHeight = Math.max(leftHeight, rightHeight);

            return 1 + tallerChildHeight;
        }

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}