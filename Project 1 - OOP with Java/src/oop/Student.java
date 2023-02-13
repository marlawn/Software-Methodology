package oop;

/**
 * Student object used in Roster class
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class Student implements Comparable<Student>{
    /** Profile object for Student */
    private Profile profile;

    /** Major object for Student */
    private Major major;

    /** credits completed for Student */
    private int creditsCompleted;

    /**
     * Constructor for Student object which contains profile, major, and credits completed.
     * @param prf Profile object for profile.
     * @param mjr enum value for Major.
     * @param crd integer representing credits completed.
     */
    public Student(Profile prf, Major mjr, int crd) {
        this.profile = prf;
        this.major = mjr;
        this.creditsCompleted = crd;
    }

    /**
     * Constructor for Student object with only profile.
     * major is set to null and creditsCompleted is set to 0.
     * @param prf Profile object for profile.
     */
    public Student(Profile prf) {
        this.profile = prf;
        this.major = null;
        this.creditsCompleted = 0;
    }

    /**
     * Get profile.
     * @return profile as Profile object.
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Get major.
     * @return major as Major enum value.
     */
    public Major getMajor() {
        return major;
    }

    /**
     * Set major.
     * @param mjr major to be set.
     */
    public void setMajor(Major mjr) {
        this.major = mjr;
    }

    /**
     * Gets amount of credits completed.
     * @return credits completed as integer.
     */
    public int getCreditsCompleted() {
        return creditsCompleted;
    }

    /**
     * Gets standing in class (Freshman, Sophomore, Junior, Senior)
     * @return standing as a String
     */
    public String getStanding() {
        if (this.creditsCompleted < 30) return "Freshman";
        else if (this.creditsCompleted < 60) return "Sophomore";
        else if (this.creditsCompleted < 90) return "Junior";
        else return "Senior";
    }

    /**
     * Overrides toString() to a customized output.
     * @return String as "[firstName] [lastName] is majoring in [major] and has completed [creditsCompleted] credits."
     */
    @Override
    public String toString() {
        return this.profile.getFname() + " " + this.profile.getLname() + " is majoring in " + this.major
                + " and has completed " + this.creditsCompleted + " credits.";
    }

    /**
     * Overrides equals(Object obj) to determine if two Profiles are equal.
     * @param obj object to be determined if equal to this Student or not.
     * @return true if the object equals the Profile, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return s.getProfile().equals(this.profile) && s.getMajor().equals(this.major) && s.getCreditsCompleted() == this.creditsCompleted;
    }

    /**
     * Overrides compareTo(Student std)
     * @param std the object to be compared.
     * @return -1 if this student is before std, 1 if this student is after std, 0 if equal
     */
    @Override
    public int compareTo(Student std) {
        if (!this.profile.equals(std.getProfile())) { return this.profile.compareTo(std.getProfile()); }
        return 0;
    }

    /**
     * main method to test compareTo()
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Date d1 = new Date("4/12/2002");
        Date d2 = new Date("4/13/2002");
        Date d3 = new Date("4/12/2002");

        Profile p1 = new Profile("Marlon", "Vergara", d2);
        Profile p2 = new Profile("Luis", "Castellanos", d1);
        Profile p3 = new Profile("Luis", "Vergara", d1);
        Profile p4 = new Profile("Marlon", "Vergara", d1);
        Profile p5 = new Profile("Marlon", "Vergara", d2);

        Student s1 = new Student(p1);
        Student s2 = new Student(p2);
        Student s3 = new Student(p3);
        Student s4 = new Student(p4);
        Student s5 = new Student(p5);

        System.out.println("s2 last name comes before s1, should return negative: " + s2.compareTo(s1));
        System.out.println("s1 last name comes after s2, should return positive: " + s1.compareTo(s2));
        System.out.println("last names equal, s3 first name comes before s1, should return negative: " + s3.compareTo(s1));
        System.out.println("last names equal, s1 first name comes before s3, should return positive: " + s1.compareTo(s3));
        System.out.println("full names equal, s4 date of birth comes before s1, should return negative: " + s4.compareTo(s1));
        System.out.println("full names equal, s1 date of birth comes before s4, should return positive: " + s1.compareTo(s4));
        System.out.println("both profiles equal, should return 0: " + s1.compareTo(s5));
    }

}
