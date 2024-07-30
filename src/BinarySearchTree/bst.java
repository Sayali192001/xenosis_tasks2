package BinarySearchTree;


import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class bst {

    TreeNode root;

    public bst() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return root;

        if (key < root.val)
            root.left = deleteRec(root.left, key);
        else if (key > root.val)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.val = minValue(root.right);
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(TreeNode root, int key) {
        if (root == null)
            return false;
        if (root.val == key)
            return true;
        return key < root.val ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.val + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bst bsearch=new bst();

        int choice, value;

        do {
            System.out.println("\nTo Perform Binary Search Tree Operations:");
            System.out.println("1. Insert a node");
            System.out.println("2. Delete a node");
            System.out.println("3. Search for a node");
            System.out.println("4. In-order traversal");
            System.out.println("5. Pre-order traversal");
            System.out.println("6. Post-order traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    bsearch.insert(value);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    bsearch.deleteKey(value);
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    System.out.println("Search result: " + bsearch.search(value));
                    break;
                case 4:
                    System.out.println("In-order traversal:");
                    bsearch.inOrder();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Pre-order traversal:");
                    bsearch.preOrder();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Post-order traversal:");
                    bsearch.postOrder();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        sc.close();
    }


}

