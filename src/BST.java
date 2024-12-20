import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return searchHelper(root, val);
    }

    public boolean searchHelper(BSTNode node, int val) {
        if (node == null) {
            return false;
        }
        else if (val > node.getVal()) {
            return searchHelper(node.getRight(), val);
        }
        else if (val < node.getVal()) {
            return searchHelper(node.getLeft(), val);
        }
        else {
            return true;
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        getInorderHelper(root, arr);
        return arr;
    }
    public void getInorderHelper(BSTNode node, ArrayList<BSTNode> arr) {
        if (node != null) {
            // left subtree
            getInorderHelper(node.getLeft(), arr);
            // add the node
            arr.add(node);
            // right subtree
            getInorderHelper(node.getRight(), arr);
        }
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        getPreorderHelper(root, arr);
        return arr;
    }
    public void getPreorderHelper(BSTNode node, ArrayList<BSTNode> arr) {
        if (node != null) {
            // add the node
            arr.add(node);
            // go to the left
            getPreorderHelper(node.getLeft(), arr);
            // go to the right
            getPreorderHelper(node.getRight(), arr);
        }
    }
    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        getPostorderHelper(root, arr);
        return arr;
    }
    public void getPostorderHelper(BSTNode node, ArrayList<BSTNode> arr) {
        if (node != null) {
            // go to the left
            getPreorderHelper(node.getLeft(), arr);
            // go to the right
            getPreorderHelper(node.getRight(), arr);
            // add the node
            arr.add(node);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // create a new node to insert
        BSTNode node = new BSTNode(val);
        // if its null just set it on the spot
        if (root == null) {
            root = node;
        }
        // otherwise do the whole helper function process
        else {
            insertHelper(root, val);
        }
    }

    public void insertHelper(BSTNode node, int val) {
        if (val < node.getVal()) {
            // left subtree
            if (node.getLeft() == null) {
                // insert node if left is null
                node.setLeft(new BSTNode(val));
            }
            else {
                // Keep going in left subtree
                insertHelper(node.getLeft(), val);
            }
        }
        else if (val > node.getVal()) {
            // right subtree
            if (node.getRight() == null) {
                // Set it if it's null
                node.setRight(new BSTNode(val));
            }
            else {
                // Keep traversing right otherwise
                insertHelper(node.getRight(), val);
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
