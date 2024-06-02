// Name: Tia Vanderyacht
//Date:06/02/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 7 Binary Search Tree
// Purpose: Application class for the BST. This class contains the main method to run the application.
// Citation: GeeksforGeeks, w3schools.com,and youtube(bro code)

import java.util.InputMismatchException;
import java.util.Scanner;

import customer.Customer;
import customer.CustomerBST;
    
    public class BSTApp {
        public static void main(String[] args) {
            CustomerBST customerTree = new CustomerBST();// create a new BST
            Scanner scanner = new Scanner(System.in);
            int choice = 0;

            System.out.println("\nCustomer Directory Application");
            System.out.println("-------------------------------");
            //do while loop for the menu
            do {
                System.out.println("\n1. Add customer");
                System.out.println("2. Remove customer");
                System.out.println("3. Search customer");
                System.out.println("4. Print customer directory");
                System.out.println("5. Exit");
                System.out.print("Please enter your choice: ");
                //try catch block to catch invalid input
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Entry. Please enter an integer.");
                    scanner.nextLine();  // consume newline left-over
                    continue;
                }
                scanner.nextLine();  // consume newline left-over

                switch (choice) {
                    case 1:
                        addCustomer(scanner,customerTree);// call the addCustomer method
                        break;
                    case 2:
                        removeCustomer(scanner,customerTree);// call the removeCustomer method
                        break;
                    case 3:
                        searchCustomer(scanner,customerTree);// call the searchCustomer method
                        break;
                    case 4:
                        printCustomerDirectory(customerTree,scanner);// call the printCustomerDirectory method
                        break;
                    case 5:
                        System.out.println("Thank you for using the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } while (choice != 5);
        }//end of main method
    
        //method to add a customer
        private static void addCustomer(Scanner scanner,CustomerBST customerTree) {
            String addMore;
            do {
                    int id = 0;
                    boolean validInput = false;
                    
                    while (!validInput) {
                        System.out.print("\nPlease enter an ID number for the customer: ");
                        String input = scanner.nextLine();
                        try {
                            id = Integer.parseInt(input);
                            validInput = true;  // if parsing is successful, set the flag to true
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter an integer.");
                        }
                    }

                    Customer existingCustomer = customerTree.search(id);//call the search method from the CustomerBST class to check if the customer exists
                    
                    //if the customer exists, print a message, else add the customer
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
                        System.out.print("Enter customer city: ");
                        String city = scanner.nextLine();
                        System.out.print("Enter customer state: ");
                        String state = scanner.nextLine();
                        System.out.print("Enter customer zip: ");
                        String zip = scanner.nextLine();
                        customerTree.addNode(new Customer(id, firstName, lastName, phone, address, city, state, zip));
                        System.out.println("Customer added successfully.");
                    }
                    System.out.print("\nWould you like to add another customer? (yes/no): ");
                    addMore = scanner.nextLine();
            } while (addMore.equalsIgnoreCase("yes"));
        }//end of addCustomer method
        
        //method to remove a customer
        public static void removeCustomer(Scanner scanner, CustomerBST customerTree) {
            String removeMore;
            do {
                int removeId = 0;
                boolean validInput = false;

                //while loop to check for valid input
                while (!validInput) {
                    System.out.print("\nEnter the ID of the customer you want to remove: ");
                    String input = scanner.nextLine();
                    try {
                        removeId = Integer.parseInt(input);
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please enter ID in numerical form.");
                    }
                }

                Customer customer = customerTree.search(removeId);//call the search method from the CustomerBST class to check if the customer exists

                //if the customer exists, remove the customer, else print a message
                if (customer != null) {
                    customerTree.remove(removeId);//call the remove method from the CustomerBST class
                    System.out.println("Customer removed successfully.");
                } else {
                    System.out.println("Customer with ID " + removeId + " does not exist.");
                }
                System.out.print("\nWould you like to remove another customer? (yes/no): ");
                removeMore = scanner.nextLine();
            } while (removeMore.equalsIgnoreCase("yes"));
        }//end of removeCustomer method

        //method to search for a customer
        public static void searchCustomer(Scanner scanner, CustomerBST customerTree) {
            String searchMore;
            do {
                int searchId = 0;
                boolean validInput = false;

                //while loop to check for valid input
                while (!validInput) {
                    System.out.print("\nEnter customer ID: ");
                    String input = scanner.nextLine();
                    try {
                        searchId = Integer.parseInt(input);
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                    }
                }

                Customer customer = customerTree.search(searchId);//call the search method from the CustomerBST class

                if (customer != null) {
                    System.out.println("Customer found: " + customer);
                } else {
                    System.out.println("Customer with ID " + searchId + " does not exist.");
                }
                System.out.print("\nWould you like to search for another customer? (yes/no): ");
                searchMore = scanner.nextLine();
            }while(searchMore.equalsIgnoreCase("yes"));
        }//end of searchCustomer method

        public static void printCustomerDirectory(CustomerBST customerTree,Scanner scanner  ) {
            String printMore;
                do {
                int traversalType = 0;
                boolean validInput = false;

                //while loop to check for valid input
                while(!validInput) {
                    System.out.println("\nCustomer directory: Please choose a look up an option: enter 1 for pre-order, 2 for in-order, 3 for post-order");
                    String input = scanner.nextLine();
                    try {
                        traversalType = Integer.parseInt(input);
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                    }
                customerTree.customerTraversalLookup(traversalType);//call the customerTraversalLookup method from the CustomerBST class
                }
                System.out.print("\nWould you like to print the customer directory again? (yes/no): ");
                printMore = scanner.nextLine();
            }while(printMore.equalsIgnoreCase("yes"));
    }//end of printCustomerDirectory method
}//end of BSTApp class