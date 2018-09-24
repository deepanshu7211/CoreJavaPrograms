package com.deep.enum_impl;

/**
 * Created by deepanshu.saxena on 19/11/15.
 */
public class BTree {

    Node root;

    public static void main(String[] args) {

        BTree theTree = new BTree();

        theTree.addNode(50, "Boss");

        theTree.addNode(25, "Vice President");

        theTree.addNode(15, "Office Manager");

        theTree.addNode(30, "Secretary");

        theTree.addNode(75, "Sales Manager");

        theTree.addNode(85, "Salesman 1");

        theTree.preOrder(theTree.root);
//        theTree.inOrder(theTree.root);
//        theTree.postOrder(theTree.root);

        System.out.println(theTree.findNode(85));

    }

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {

            Node currentNode = root;
            Node parent;

            while (true) {
                parent = currentNode;

                if (key < currentNode.key) {
                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }

            }
        }

    }

    public void preOrder(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode);
            preOrder(currentNode.left);
            preOrder(currentNode.right);
        }
    }

    public void postOrder(Node currentNode) {
        if (currentNode != null) {
            postOrder(currentNode.left);
            postOrder(currentNode.right);
            System.out.println(currentNode);
        }
    }

    public void inOrder(Node currentNode) {
        if (currentNode != null) {
            inOrder(currentNode.left);
            System.out.println(currentNode);
            inOrder(currentNode.right);

        }
    }

    public Node findNode(int key) {
        Node currentNode = root;

        while (currentNode.key != key) {
            if (key < currentNode.key)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;

            if (currentNode == null)
                return null;
        }
        return currentNode;
    }
}
