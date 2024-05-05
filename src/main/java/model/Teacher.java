package model;

public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String salt;
    private String passwordHash;
    private Address address;

    public Teacher(int id, String firstName, String lastName, String email,
                    String salt, String passwordHash, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salt = salt;
        this.passwordHash = passwordHash;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSalt() {
        return salt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Address getAddress() {
        return address;
    }
}
