package model;

public class Students {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String salt;
    private String passwordHash;
    private Address address;
    private School school;
    private Major major;
    private Period period;

    public Students(int id, String firstName, String lastName, String email
            , String salt, String passwordHash, Address address,
                    School school, Major major, Period period) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salt = salt;
        this.passwordHash = passwordHash;
        this.address = address;
        this.school=school;
        this.major=major;
        this.period=period;
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

    public Address getAddress() {
        return address;
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

    public School getSchool() {
        return school;
    }

    public Major getMajor() {
        return major;
    }

    public Period getPeriod() {
        return period;
    }
}
