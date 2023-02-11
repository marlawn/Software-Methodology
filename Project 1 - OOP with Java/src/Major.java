public enum Major {
    CS      ("01:198", "SAS"),
    MATH    ("01:640", "SAS"),
    EE      ("14:332", "SOE"),
    ITI     ("04:547", "SC&I"),
    BAIT    ("33:136", "RBS");
    private String majorCode;
    private String schoolName;
    Major(String majorCode, String schoolName) {
        this.majorCode = majorCode;
        this.schoolName = schoolName;
    }
    String getMajorCode() {
        return majorCode;
    }
    String getSchoolName() {
        return schoolName;
    }
}
// what to do with the "which include a list of the major names, major codes, and school names"
