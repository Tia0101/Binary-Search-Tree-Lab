package customer;


public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String streetAddress;
    private String state;
    private String zipCode;

    public Customer(int id, String firstName, String lastName, String phoneNumber, String streetAddress, String state, String zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
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
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return String.format("%nID: %d%nFirst Name: %s%nLast Name: %s%nPhone Number: %s%nStreet Address: %s%nState: %s%nZip Code: %s%n",
        id, firstName, lastName, phoneNumber, streetAddress, state, zipCode);
    }
    // toString method
}