package oop;

/**
 * Documents the Majors that are used in the Student object.
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public enum Major {
    /** CS Major */
    CS      ("01:198", "SAS"),

    /** MATH Major */
    MATH    ("01:640", "SAS"),

    /** EE Major */
    EE      ("14:332", "SOE"),

    /** ITI Major */
    ITI     ("04:547", "SC&I"),

    /** BAIT Major */
    BAIT    ("33:136", "RBS");

    /** major code in Major enum type */
    private String majorCode;

    /** school name in Major enum type */
    private String schoolName;

    /**
     * Constructor for Major which contains major code and school name.
     * @param majorCode code corresponding to major.
     * @param schoolName school name corresponding to major.
     */
    Major(String majorCode, String schoolName) {
        this.majorCode = majorCode;
        this.schoolName = schoolName;
    }

    /**
     * gets the major code
     * @return major code as a String.
     */
    String getMajorCode() {
        return majorCode;
    }

    /**
     * gets the school name
     * @return school name as a String
     */
    String getSchoolName() {
        return schoolName;
    }
}