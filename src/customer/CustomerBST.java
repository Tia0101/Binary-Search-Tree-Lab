
package customer;

public class CustomerBST {

    private Node root;// root of the tree

    private class Node {
        protected Customer customer;
        protected Node left;
        protected Node right;

        public Node(Customer customer) {
            this.customer = customer;
        }
    }

    public void addNode(Customer customer) {
        root = addHelper(root, customer);
        
    }

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

    public void remove(int id) {
        root = removeHelper(root, id);
    }

    private Node removeHelper(Node current, int id) {
        if (current == null) {
            return null;
        }

        if (id == current.customer.getId()) {
            // Node to delete found
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.right == null) {
                return current.left;
            } else if (current.left == null) {
                return current.right;
            } else {
                // node has two children
                int smallestValue = findMinID(current.right);
                current.customer.setId(smallestValue);
                current.right = removeHelper(current.right, smallestValue);
                return current;
            }
        } 

        if (id < current.customer.getId()) {
            current.left = removeHelper(current.left, id);
            return current;
        }

        current.right = removeHelper(current.right, id);
        return current;
    }

    private int findMinID(Node root) {
        if (root.left == null) {
            return root.customer.getId();
        } else {
            return findMinID(root.left);
        }
    }

    public Customer search(int id) {
        return searchHelper(root, id);
    }

    private Customer searchHelper(Node current, int id) {
        if (current == null) {
            return null;
        }

        if (id == current.customer.getId()) {
            return current.customer;
        }

        if (id < current.customer.getId()) {
            return searchHelper(current.left, id);
        } else {
            return searchHelper(current.right, id);
        }
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.customer.toString());
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder() {
            traversePreOrder(root);
        }
    
    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.customer.toString());
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.customer.toString());
        }
    }

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
