package com.study.book.tree;

public class BinaryTree<T> {

    TreeNode<T> root;

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void printPreOrder() {
        System.out.print("전위 순회 (Pre-Order): ");
        preOrderRecursive(this.root);
        System.out.println();
    }

    private void preOrderRecursive(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);
    }

    public void printInOrder() {
        System.out.print("중위 순회 (In-Order): ");
        inOrderRecursive(this.root);
        System.out.println();
    }

    private void inOrderRecursive(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrderRecursive(node.left);
        System.out.print(node.data + " ");
        inOrderRecursive(node.right);
    }

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.root = new TreeNode<>(1);
        tree.root.left = new TreeNode<>(2);
        tree.root.right = new TreeNode<>(3);
        tree.root.left.left = new TreeNode<>(4);
        tree.root.left.right = new TreeNode<>(5);

        tree.printPreOrder();
        tree.printInOrder();

        BinaryTree<String> stringTree = new BinaryTree<>();
        stringTree.root = new TreeNode<>("A");
        stringTree.root.left = new TreeNode<>("B");
        stringTree.root.right = new TreeNode<>("C");

        System.out.println("\n--- String Tree ---");
        stringTree.printPreOrder();
    }
}
