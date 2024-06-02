// Name: Tia Vanderyacht
//Date:05/07/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 7 Binary Search Tree
// Purpose: This class is the Binary Search Tree class. This class contains the methods to add, remove, search, and traverse the tree.
// Citation: GeeksforGeeks, w3schools.com,and youtube(bro code)

package customer;//custom package created for the customer class

public class CustomerBST {

    private Node root;// root of the tree

    // nested class to represent a node in the tree
    private class Node {
        protected Customer customer;
        protected Node left;
        protected Node right;
        
        //node constructor
        public Node(Customer customer) {
            this.customer = customer;
        }
    }

    // add a new customer to the tree
    public void addNode(Customer customer) {
        root = addHelper(root, customer);
        
    }

    // helper method to add a new customer to the tree recursively and return the node
    private Node addHelper(Node current, Customer customer) {
        if (current == null) {
            return new Node(customer);
        }
        // compare the id of the customer to the id of the current node
        if (customer.getId() < current.customer.getId()) {
            current.left = addHelper(current.left, customer);
        } else if (customer.getId() > current.customer.getId()) {
            current.right = addHelper(current.right, customer);
        }
        // customer already exists
        return current;
    }

    // remove a customer from the tree
    public void remove(int id) {
        root = removeHelper(root, id);
    }

    // helper method to remove a customer from the tree recursively and return the node
    private Node removeHelper(Node current, int id) {
        if (current == null) {
            return null;
        }
        // compare the id of the customer to the id of the current node
        if (id == current.customer.getId()) {
            // the node has no children
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.right == null) { // the node has one child to the left
                return current.left;//return the left child
            } else if (current.left == null) {// the node has one child to the right
                return current.right;//return the right child
            } else {
                // the node has two children replace the node with the smallest ID value in the right subtree
                int smallestValue = findMinID(current.right);
                current.customer.setId(smallestValue);//set the id of the current node to the smallest value
                current.right = removeHelper(current.right, smallestValue);//remove the node that has the smallest value
                return current;
            }
        } 
        // if the id of the customer is less than the id of the current node, go to the left subtree
        if (id < current.customer.getId()) {
            current.left = removeHelper(current.left, id);
            return current;
        }
        // if the id of the customer is greater than the id of the current node, go to the right subtree
        current.right = removeHelper(current.right, id);
        return current;
    }
    
    // helper method to find the smallest ID value in the tree recursively and return the ID value
    private int findMinID(Node root) {
        if (root.left == null) {
            return root.customer.getId();
        } else {
            return findMinID(root.left);
        }
    }

    // search for a customer in the tree return the customer object
    public Customer search(int id) {
        return searchHelper(root, id);
    }

    // helper method to search for a customer in the tree recursively and return the customer object
    private Customer searchHelper(Node current, int id) {
        if (current == null) {
            return null;
        }
        // compare the id of the customer to the id of the current node
        if (id == current.customer.getId()) {
            return current.customer;
        }
        if (id < current.customer.getId()) {
            return searchHelper(current.left, id);
        } else {
            return searchHelper(current.right, id);
        }
    }

    // traverse the tree in-order
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    // helper method to traverse the tree in-order recursively
    private void traverseInOrder(Node node) {

        //transverse left, root, right
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.customer.toString());
            traverseInOrder(node.right);
        }
    }

    // traverse the tree pre-order
    public void traversePreOrder() {
            traversePreOrder(root);
        }
    
    // helper method to traverse the tree pre-order recursively
    private void traversePreOrder(Node node) {
        //transverse root, left, right
        if (node != null) {
            System.out.print(node.customer.toString());
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // traverse the tree post-order
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    // helper method to traverse the tree post-order recursively
    private void traversePostOrder(Node node) {
        //transverse left, right, root
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.customer.toString());
        }
    }
    // customerTraversalLookup method to allow the user to choose the type of traversal
    public void customerTraversalLookup(int traversalType) {
        if (root == null) {
            System.out.println("There currently are no customers in the directory");
            return;
        }

        switch (traversalType) {
            case 1:
                System.out.println("Pre-order traversal:");
                traversePreOrder();
                break;
            case 2:
                System.out.println("In-order traversal:");
                traverseInOrder();
                break;
            case 3:
                System.out.println("Post-order traversal:");
                traversePostOrder();
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                break;
        }
    }
}
