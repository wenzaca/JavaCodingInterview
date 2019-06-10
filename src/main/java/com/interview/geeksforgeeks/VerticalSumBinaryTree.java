package com.interview.geeksforgeeks;

import java.util.*;

public class VerticalSumBinaryTree {
    /*
        class Node
            int data;
            Node left;
            Node right;
     */

    public static List<Integer> sumHoriztonal(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();

        verticalSumUtil(root, 0,map);

        return (List<Integer>) map.values();
    }

    // Traverses the tree in in-order form and builds
    // a hashMap hM that contains the vertical sum
    private static void verticalSumUtil(Node root, int hD,
                                 Map<Integer, Integer> hM) {

        // base case
        if (root == null) {  return; }

        // Store the values in hM for left subtree
        verticalSumUtil(root.left, hD - 1, hM);

        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.data);

        // Store the values in hM for right subtree
        verticalSumUtil(root.right, hD + 1, hM);
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        sumHoriztonal(root).forEach(System.out::println);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
