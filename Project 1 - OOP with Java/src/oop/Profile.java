package oop;

/**
 * Profile object used in the Student object.
 * Contains the first name, last name, date of birth, and methods regarding the profile.
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class Profile implements Comparable<Profile> {
    /** last name in Profile object */
    private String lname;

    /** first name in Profile object */
    private String fname;

    /** date of birth in Profile object */
    private Date dob;

    /**
     * Constructor which contains the first name, last name, and date of birth.
     * @param firstName first name as a String.
     * @param lastName last name as a String.
     * @param dob date of birth as a Date object.
     */
    public Profile(String firstName, String lastName, Date dob) {
        this.fname = firstName;
        this.lname = lastName;
        this.dob = dob;
    }

    /**
     * Gets the first name.
     * @return first name as a String.
     */
    public String getFname() {
        return fname;
    }

    /**
     * Gets the last name.
     * @return last name as a String.
     */
    public String getLname() {
        return lname;
    }

    /**
     * Gets the date of birth.
     * @return date of birth as a Date object.
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Overrides the toString() method to a customized output.
     * @return String reading the following "First Name: ___, Last Name: ___, Date of Birth: ___".
     */
    @Override
    public String toString() {
        return "First Name: " + fname + "\r\n" + "Last Name: " + lname + "\r\n" + "Date of Birth: " + dob;
    }

    /**
     * Checks to see if the two objects are equal to each other.
     * @param obj object to be compared to this Profile to see if equal.
     * @return true if the two Profiles are the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Profile)) return false;
        Profile p = (Profile) obj;
        return p.getFname() == this.fname && p.getLname() == this.lname && p.getDob().getDay() == this.dob.getDay() &&
        p.getDob().getMonth() == this.getDob().getMonth() && p.getDob().getYear() == this.getDob().getYear();
    }

    /**
     * Compares the two Profile objects
     * @param obj the object to be compared.
     * @return -1 if this Profile is before obj, 1 if this Profile is after obj, 0 if both Profiles are equal
     */
    @Override
    public int compareTo(Profile obj) {
        if (this.lname.compareTo(obj.getLname()) != 0) return this.lname.compareTo(obj.getLname());
        if (this.fname.compareTo(obj.getFname()) != 0) return this.fname.compareTo(obj.getFname());
        if (this.dob.compareTo(obj.getDob()) != 0) return this.dob.compareTo(obj.getDob());
        return 0;
    }
}
