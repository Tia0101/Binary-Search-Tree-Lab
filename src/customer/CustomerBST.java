
package customer;

public class CustomerBST {

    private Node root;// root of the tree

    // nested class to represent a node in the tree
    private class Node {
        protected Customer customer;
        protected Node left;
        protected Node right;
        
        // constructor
        public Node(Customer customer) {
            this.customer = customer;
        }
    }

    // add a new customer to the tree
    public void addNode(Customer customer) {
        root = addHelper(root, customer);
        
    }

    // helper method to add a new customer to the tree recursively
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

    // helper method to remove a customer from the tree recursively
    private Node removeHelper(Node current, int id) {
        if (current == null) {
            return null;
        }
        // compare the id of the customer to the id of the current node
        if (id == current.customer.getId()) {
            // Node to delete found
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.right == null) {
                return current.left;
            } else if (current.left == null) {
                return current.right;
            } else {
                // node has two children replace the node with the smallest ID value in the right subtree
                int smallestValue = findMinID(current.right);
                current.customer.setId(smallestValue);
                current.right = removeHelper(current.right, smallestValue);
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
    
    // helper method to find the smallest ID value in the tree recursively
    private int findMinID(Node root) {
        if (root.left == null) {
            return root.customer.getId();
        } else {
            return findMinID(root.left);
        }
    }

    // search for a customer in the tree
    public Customer search(int id) {
        return searchHelper(root, id);
    }

    // helper method to search for a customer in the tree recursively
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
        if (node == null) {
            System.out.println("There currently are no customers in the directory");;
        }
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
        if (node == null) {
            System.out.println("There currently are no customers in the directory");;
        }
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
        if (node == null) {
            System.out.println("There currently are no customers in the directory");;
        }
        //transverse left, right, root
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.customer.toString());
        }
    }
    // customerTraversalLookup method to allow the user to choose the type of traversal
    public void customerTraversalLookup(int traversalType) {
        switch (traversalType) {
            case 1:
                traversePreOrder();
                break;
            case 2:
                traverseInOrder();
                break;
            case 3:
                traversePostOrder();
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                break;
        }
    }
}
