public class Profile implements Comparable<Profile> {
    private String lname;
    private String fname;
    private Date dob;
    public Profile(String f, String l, Date d) {
        this.fname = f;
        this.lname = l;
        this.dob = d;
    }
    public void setFname(String f) {
        this.fname = f;
    }
    public void setLname(String l) {
        this.lname = l;
    }
    public void setDob(Date d) {
        this.dob = d;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public Date getDob() {
        return dob;
    }
    @Override
    public String toString() {
        return "First Name: " + fname + "\r\n" + "Last Name: " + lname + "\r\n" + "Date of Birth: " + dob;
    }
    public boolean equals(Profile p) {
        return p.getFname() == this.fname && p.getLname() == this.lname && p.getDob().getDay() == this.dob.getDay() &&
        p.getDob().getMonth() == this.getDob().getMonth() && p.getDob().getYear() == this.getDob().getYear();
    }
    public int compareTo(Profile o) {
        if (this.lname.compareTo(o.getLname()) != 0) { return this.lname.compareTo(o.getLname()); }
        if (this.fname.compareTo(o.getFname()) != 0) { return this.fname.compareTo(o.getFname()); }
        if (this.dob.compareTo(o.getDob()) != 0) { return this.dob.compareTo(o.getDob()); }
        return 0;
    }
}
