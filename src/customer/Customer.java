// Name: Tia Vanderyacht
//Date:06/02/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 7 Binary Search Tree
// Purpose: Object class for the customer object. This class contains the customer object and the getters and setters for the customer object.
// Citation: GeeksforGeeks, w3schools.com,and youtube(bro code)

package customer;//custom package created for the customer class

// Customer class
public class Customer {

    // instance variables
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    //customer constructor
    public Customer(int id, String firstName, String lastName, String phoneNumber, String streetAddress, String state, String city, String zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // getters and setters
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getZipCode() {
        return zipCode;
    }

    @Override
    // toString method
    public String toString() {
        return String.format("%nID: %d%nFirst Name: %s%nLast Name: %s%nPhone Number: %s%nStreet Address: %s%nState: %s%ncity: %s%nZip Code: %s%n",
        id, firstName, lastName, phoneNumber, streetAddress,city, state, zipCode);
    }
}