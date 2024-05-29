
    import java.util.InputMismatchException;
import java.util.Scanner;

import customer.Customer;
import customer.CustomerBST;
    
    public class App {
        public static void main(String[] args) {
            CustomerBST customerTree = new CustomerBST();
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
    
            do {
                System.out.println("\n1. Add customer");
                System.out.println("2. Remove customer");
                System.out.println("3. Search customer");
                System.out.println("4. Print customer directory");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine();  // consume newline left-over
                    continue;
                }
    
                switch (choice) {
                    case 1:
                        addCustomer(scanner, customerTree);
                        break;
                    case 2:
                        System.out.print("Enter customer ID to remove: ");
                        int removeId = scanner.nextInt();
                        customerTree.remove(removeId);
                        System.out.println("Customer removed successfully.");
                        break;
                    case 3:
                        System.out.print("Enter customer ID to search: ");
                        int searchId = scanner.nextInt();
                        Customer customer = customerTree.search(searchId);
                        if (customer != null) {
                            System.out.println("Customer found: " + customer);
                        } else {
                            System.out.println("Customer with ID " + searchId + " does not exist.");
                        }
                        break;
                    case 4:
                        System.out.println("Customer directory: Please pick a look up tupe enter 1 for pre-order, 2 for in-order, 3 for post-order");
                        int traversalType = scanner.nextInt();
                        customerTree.customerTraversalLookup(traversalType);
                        break;
                    case 5:
                        System.out.println("Thank you for using the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter between 1 and 5.");
                }
            } while (choice != 5);
        }
    
        private static void addCustomer(Scanner scanner, CustomerBST customerTree) {
            System.out.print("Enter customer ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume newline left-over
    
            Customer existingCustomer = customerTree.search(id);
    
            if(existingCustomer != null) {
                System.out.println("ID number " + id + " already exists. Please enter a different ID number.");
            } else {
                System.out.print("Enter customer first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter customer last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter customer phone: ");
                String phone = scanner.nextLine();
                System.out.print("Enter customer address: ");
                String address = scanner.nextLine();
                System.out.print("Enter customer state: ");
                String state = scanner.nextLine();
                System.out.print("Enter customer zip: ");
                String zip = scanner.nextLine();
                customerTree.addNode(new Customer(id, firstName, lastName, phone, address, state, zip));
                System.out.println("Customer added successfully.");
            }
        }
    }
