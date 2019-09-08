package com.warmzen.algs;

public class BinaryTree {



    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();

        n1.value = 1;
        n2.value = 2;
        n3.value = 3;
        n4.value = 4;
        n5.value = 5;

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        invertTree(n1);
    }

    public static Node invertTree(Node node){
        if(node == null){
            return node;
        } else {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            invertTree(node.left);
            invertTree(node.right);
        }

        return node;
    }

    static class Node{
        public int value;
        Node left;
        Node right;
    }
}
