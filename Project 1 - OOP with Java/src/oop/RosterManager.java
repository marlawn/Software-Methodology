package oop;

import java.util.Scanner;
/**
 * Gets run by RunProject1.java which handles all the commands in the terminal.
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class RosterManager {
    /** first name */
    private String fn;

    /** last name */
    private String ln;

    /** date of birth */
    private Date dob;

    /** major */
    private Major mjr;

    /** credits completed */
    private int crd;

    /** new Scanner object */
    Scanner sc  = new Scanner(System.in);

    /** new Roster object */
    Roster r = new Roster();


    /**
     * Runs the project and reads from the command line.
     */
    public void run() {
        System.out.println("Roster Manager running...");
        System.out.println();
        while (!sc.hasNext("Q")) {
            String command = sc.next();
            if (command.equals("A")) {
                String fname = sc.next();
                String lname = sc.next();
                String date = sc.next();
                String major = sc.next();
                if (!(sc.hasNextInt())) { sc.next(); System.out.println("Credits completed invalid: not an integer"); }
                else {
                    int creditsCompleted = sc.nextInt();
                    A(fname, lname, date, major, creditsCompleted);
                }
            }
            else if (command.equals("R")) R(sc.next(), sc.next(), sc.next());
            else if (command.equals("P")) P();
            else if (command.equals("PS")) PS();
            else if (command.equals("PC")) PC();
            else if (command.equals("L")) L(sc.next());
            else if (command.equals("C")) C(sc.next(), sc.next(), sc.next(), sc.next());
            else System.out.println(command + " is an invalid command!");
        }
        Q();
    }

    /**
     * Checks to see if major is valid.
     * @param str major to be checked if valid.
     * @return true if major is valid, false otherwise.
     */
    private boolean isValidMajor(String str) {
        if (str.toUpperCase().equals("CS") || str.toUpperCase().equals("MATH") || str.toUpperCase().equals("EE")
        || str.toUpperCase().equals("ITI") || str.toUpperCase().equals("BAIT")) return true;
        return false;
    }

    /**
     * Checks to see if age is >= 16.
     * @param dt date to check if it is >= 16.
     * @return -1 if younger than 16, 1 if older than 16, 0 if equal.
     */
    private int checkAge(Date dt) {
        Date sixteenYears = new Date();
        int yr = sixteenYears.getYear() - Constants.AGE_LIMIT;
        sixteenYears.setYear(yr);
        return sixteenYears.compareTo(dt);
    }

    /**
     * Checks to see if date of birth is today or future date.
     * @param dt date to check if it is today or future date.
     * @return -1 if future date, 1 if past date, 0 if equal.
     */
    private int checkIfDobTodayOrMore(Date dt) {
        Date today = new Date();
        return today.compareTo(dt);
    }

    /**
     * Adds student to roster with the following restrictions:
     * <ul>
     *     <li>Any date of birth that is not a valid calendar date</li>
     *     <li>The date of birth is today or a future date</li>
     *     <li>A student who is less than 16 years old</li>
     *     <li>The major doesn’t exist</li>
     *     <li>The student is in the roster already</li>
     *     <li>Negative number of credit completed</li>
     * </ul>
     * @param fname first name to add to profile.
     * @param lname last name to add to profile.
     * @param date date of birth to add to profile.
     * @param major major to add to student object.
     * @param creditsCompleted credits completed to add to student object.
     */
    private void A(String fname, String lname, String date, String major, int creditsCompleted) {
        fn = fname.substring(0,1).toUpperCase() + fname.substring(1).toLowerCase(); // correct casing
        ln = lname.substring(0,1).toUpperCase() + lname.substring(1).toLowerCase(); // correct casing
        dob = new Date(date);
        if (!(dob.isValid()) || checkIfDobTodayOrMore(dob) == 0 || checkIfDobTodayOrMore(dob) < 0) {
            System.out.println("DOB invalid: " + dob.toString() + " not a valid calendar date!");
            return;
        }
        if (checkAge(dob) < 0) {
            System.out.println("DOB invalid: " + date + " younger than 16 years old.");
            return;
        }
        if (creditsCompleted < 0) {
            System.out.println("Credits completed invalid: cannot be negative!");
            return;
        }
        if (!(isValidMajor(major))) {
            System.out.println("Major code invalid: " + major);
            return;
        }
        else mjr = Major.valueOf(major.toUpperCase()); // Makes the major input not case sensitive (i.e. "ee" -> "EE")
        Profile prf = new Profile(fn, ln, dob);
        Student std = new Student(prf, mjr, creditsCompleted);

        boolean bool = r.add(std);

        if (bool) System.out.println(fname + " " + lname + " " + date + " added to the roster.");
        else System.out.println(fname + " " + lname + " " + date + " is already in the roster.");
    }

    /**
     * Removes the specified student from the roster.
     * Rejects if the user is removing a student who is not in the roster.
     * @param fname first name to be removed from the roster.
     * @param lname last name to be removed from the roster.
     * @param date date of birth to be removed from the roster.
     */
    private void R(String fname, String lname, String date) {
        fn = fname.substring(0,1).toUpperCase() + fname.substring(1).toLowerCase();
        ln = lname.substring(0,1).toUpperCase() + lname.substring(1).toLowerCase();
        dob = new Date(date);
        Profile prf = new Profile(fn, ln, dob);
        Student std = new Student(prf);
        if (!(r.contains(std))) {
            System.out.println(fname  + " " + lname + " " + date + " is not in the roster.");
            return;
        }
        Student t = r.getStudent(std);
        int crd = t.getCreditsCompleted();
        mjr = t.getMajor();
        std = new Student(prf, mjr, crd);
        r.remove(std);
        System.out.println(fname + " " + lname + " " + date + " removed from the roster.");
    }

    /**
     * Prints roster by last name, first name, then date of birth.
     */
    private void P() {
        if (r.getSize() == 0) System.out.println("Student roster is empty!");
        else {
            System.out.println("* Student roster sorted by last name, first name, DOB **");
            r.print();
            System.out.println("* end of roster **");
        }
    }

    /**
     * Prints roster by standing, last name, first name, then date of birth.
     */
    private void PS() {
        if (r.getSize() == 0) System.out.println("Student roster is empty!");
        else {
            System.out.println("* Student roster sorted by standing **");
            r.printByStanding();
            System.out.println("* end of roster **");
        }
    }

    /**
     * Prints roster by school, major, last name, first name, then date of birth
     */
    private void PC() {
        if (r.getSize() == 0) System.out.println("Student roster is empty!");
        else {
            System.out.println("* Student roster sorted by school, major **");
            r.printBySchoolMajor();
            System.out.println("* end of roster **");
        }
    }

    /**
     * Prints the roster by school.
     * @param school school roster to be printed.
     */
    private void printBySchool(String school) {
        for (int i = 0; i < r.getSize(); i++) {
            if (school.equals(r.getRoster()[i].getMajor().getSchoolName())) {
                System.out.println(r.getRoster()[i].getProfile().getFname() + " "
                + r.getRoster()[i].getProfile().getLname() + " "
                + r.getRoster()[i].getProfile().getDob().toString() + " ("
                + r.getRoster()[i].getMajor().getMajorCode() + " "
                + r.getRoster()[i].getMajor() + " " + r.getRoster()[i].getMajor().getSchoolName()
                + ") credits completed: " + r.getRoster()[i].getCreditsCompleted() + " ("
                + r.getRoster()[i].getStanding() + ")");
            }
        }
        System.out.println("* end of list **");
    }

    /**
     * Lists the students in a specified school.
     * Sorted by last name, first name, then date of birth.
     * @param school to have the students listed for.
     */
    private void L(String school) {
        String scl = school.toUpperCase();
        if (!(scl.equals("SAS") || scl.equals("SOE") || scl.equals("SOE")
        || scl.equals("SC&I") || scl.equals("RBS"))) {
            System.out.println("School doesn't exist: " + school);
            return;
        }
        System.out.println("* Students in " + school + " *");
        printBySchool(scl);
    }

    /**
     * Changes a student's major.
     * @param fname first name of the student.
     * @param lname last name of the student.
     * @param date date of birth of the student.
     * @param major major to be changed to.
     */
    private void C(String fname, String lname, String date, String major) {
        Date dob = new Date(date);
        Profile prf = new Profile(fname, lname, dob);
        Student std = new Student(prf);
        if (!(r.contains(std))) {
            System.out.println(fname  + " " + lname + " " + date + " is not in the roster.");
            return;
        }
        else {
            if (!(isValidMajor(major))) { System.out.println("Major code invalid: " + major); return; }
            else mjr = Major.valueOf(major.toUpperCase());
        }
        Student t = r.getStudent(std);
        int crd = t.getCreditsCompleted();
        r.remove(t);
        std = new Student(prf, mjr, crd);
        r.add(std);
        System.out.println(fname + " " + lname + " " + date + " major changed to " + major);
    }

    /**
     * Stops the program execution and display "Roster Manger terminated."
     */
    private void Q() {
        System.out.println("Roster Manager terminated.");
    }
}
