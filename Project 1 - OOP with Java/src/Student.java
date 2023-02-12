/**
 * A student object which contains the necessary information for each student.
 * @author Marlon Vergara, Luis Castellanos
 */
public class Student implements Comparable<Student>{
    private Profile profile;
    private Major major;
    private int creditsCompleted;
    public Student(Profile p, Major m, int c) {
        this.profile = p;
        this.major = m;
        this.creditsCompleted = c;
    }
    public Profile getProfile() { return profile; }
    public Major getMajor() {
        return major;
    }
    public int getCreditsCompleted() {
        return creditsCompleted;
    }
    @Override
    public String toString() {
        return this.profile.getFname() + " " + this.profile.getLname() + " is majoring in " + this.major
                + " and has completed " + this.creditsCompleted + " credits.";
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return s.getProfile().equals(this.profile) && s.getMajor().equals(this.major) && s.getCreditsCompleted() == this.creditsCompleted;
    }
    @Override
    public int compareTo(Student o) {
        if (!this.profile.equals(o.getProfile())) { return this.profile.compareTo(o.getProfile()); }
        return 0;
    }
}
