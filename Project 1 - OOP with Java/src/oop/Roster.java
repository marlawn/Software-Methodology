package oop;

/**
 * Roster class which is used in RosterManager class.
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class Roster {
    /** array of Student objects */
    private Student[] roster;

    /** size of corresponding array of Student objects */
    private int size;

    /**
     * Constructor for Roster which initializes a Student[] of size 4 and size = 0.
     */
    public Roster() {
        this.roster = new Student[4];
        this.size = 0;
    }

    /**
     * Gets the student.
     * @param student student to be returned.
     * @return student as a Student object.
     */
    public Student getStudent(Student student) {
        return roster[find(student)];
    }

    /**
     * Gets the size.
     * @return size as int.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the roster.
     * @return roster as Student[].
     */
    public Student[] getRoster() {
        return roster;
    }

    /**
     * Finds the index of a student in roster.
     * @param student whose index will be found.
     * @return index where the student is.
     */
    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (roster[i].compareTo(student) == 0) return i;
        }
        return Constants.NOT_FOUND;
    }

    /**
     * Grows the roster array by 4.
     */
    private void grow() {
        int temp = this.size + Constants.GROW_SIZE;
        Student[] newRoster = new Student[temp];
        for (int i = 0; i < this.size; i++) {
            newRoster[i] = this.roster[i];
        }
        this.roster = newRoster;
    }

    /**
     * Adds student to roster array.
     * @param student to be added to the roster.
     * @return true if student was successfully added, false otherwise.
     */
    public boolean add(Student student) {
        if (contains(student)) return false;
        if (this.size == this.roster.length) grow(); // will this work?? pretty sure
        this.roster[size] = student;
        this.size++;
        return true;
    }

    /**
     * Removes student from roster.
     * @param student student to be removed
     * @return true if student was successfully removed, false otherwise.
     */
    public boolean remove(Student student) {
        if (!(contains(student))) return false;
        int index =  find(student);
        for (int i = index; i < this.size-1; i++) {
            this.roster[i] = this.roster[i+1];
        }
        this.roster[this.size-1] = null;
        this.size--;
        return true;
    }

    /**
     * Checks if student is in roster.
     * @param student to be checked.
     * @return true if student is in roster, false otherwise.
     */
    public boolean contains(Student student) {
        if (find(student) == Constants.NOT_FOUND) return false;
        return true;
    }

    /**
     * Sorts the given Student[] array alphabetically using bubble sort
     * @param stdarr Student[] array to be sorted.
     * @param count size of the array.
     * @return Student[] array sorted.
     */
    private Student[] sort(Student[] stdarr, int count) {
        for (int i = 0; i < count-1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (stdarr[j].compareTo(stdarr[j+1]) > 0) {
                    Student t = stdarr[j];
                    stdarr[j] = stdarr[j+1];
                    stdarr[j+1] = t;
                }
            }
        }
        return stdarr;
    }

    /**
     * Sorts the roster Student[] array alphabetically using bubble sort.
     */
    private void sort() {
        for (int i = 0; i < this.getSize()-1; i++) {
            for (int j = 0; j < this.getSize() - i - 1; j++) {
                if (this.roster[j].compareTo(this.roster[j+1]) > 0) {
                    Student t = this.roster[j];
                    this.roster[j] = this.roster[j+1];
                    this.roster[j+1] = t;
                }
            }
        }
    }

    /**
     * Combines the arrays together.
     * @param fr freshman Student[] array.
     * @param so sophomore Student[] array.
     * @param ju junior Student[] array.
     * @param se senior Student[] array.
     * @param frc size of freshman Student[] array.
     * @param soc size of sophomore Student[] array.
     * @param juc size of junior Student[] array.
     * @param sec size of senior Student[] array.
     */
    private void combineS(Student[] fr, Student[] so, Student[] ju, Student[] se, int frc, int soc, int juc, int sec) {
        int count = 0;
        for (int i = 0; i < frc; i++) {
            roster[count] = fr[i];
            count++;
        }
        for (int i = 0; i < soc; i++) {
            roster[count] = so[i];
            count++;
        }
        for (int i = 0; i < juc; i++) {
            roster[count] = ju[i];
            count++;
        }
        for (int i = 0; i < sec; i++) {
            roster[count] = se[i];
            count++;
        }
    }
    /**
     * Sorts roster array in order of standing, then lexicographically.
     */
    private void sortStanding() {
        Student[] freshman = new Student[this.size];
        Student[] sophomore = new Student[this.size];
        Student[] junior = new Student[this.size];
        Student[] senior = new Student[this.size];
        int frc = 0;
        int soc = 0;
        int juc = 0;
        int sec = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.roster[i].getStanding().equals("Freshman")) {
                freshman[frc] = this.roster[i];
                frc++;
            } else if (this.roster[i].getStanding().equals("Sophomore")) {
                sophomore[soc] = this.roster[i];
                soc++;
            } else if (this.roster[i].getStanding().equals("Junior")) {
                junior[juc] = this.roster[i];
                juc++;
            } else {
                senior[sec] = this.roster[i];
                sec++;
            }
        }
        combineS(sort(freshman,frc), sort(sophomore,soc), sort(junior,juc), sort(senior,sec), frc, soc, juc, sec);
    }

    /**
     * Combines the arrays together.
     * @param RBS RBS Student[] array.
     * @param SASC SAS:CS Student[] array.
     * @param SASM SAS:MATH Student[] array.
     * @param SCI SCI Student[] array.
     * @param SOE SOE Student[] array.
     * @param rbsc size of RBS Student[] array.
     * @param sascc size of SAS:CS Student[] array.
     * @param sasmc size of SAS:MATH Student[] array.
     * @param scic size of SCI Student[] array.
     * @param soec size of SOE Student[] array.
     */
    private void combineSM(Student[] RBS, Student[] SASC, Student[] SASM, Student[] SCI, Student[] SOE,
                         int rbsc, int sascc, int sasmc, int scic, int soec) {
        int count = 0;
        for (int i = 0; i < rbsc; i++) {
            roster[count] = RBS[i];
            count++;
        }
        for (int i = 0; i < sascc; i++) {
            roster[count] = SASC[i];
            count++;
        }
        for (int i = 0; i < sasmc; i++) {
            roster[count] = SASM[i];
            count++;
        }
        for (int i = 0; i < scic; i++) {
            roster[count] = SCI[i];
            count++;
        }
        for (int i = 0; i < soec; i++) {
            roster[count] = SOE[i];
            count++;
        }
    }

    /**
     * Sorts roster array in order of school major, then lexicographically.
     */
    private void sortSchoolMajor() {
        Student[] RBS = new Student[this.size];
        Student[] SASC = new Student[this.size];
        Student[] SASM = new Student[this.size];
        Student[] SCI = new Student[this.size];
        Student[] SOE = new Student[this.size];
        int rbsc = 0;
        int sascc = 0;
        int sasmc = 0;
        int scic = 0;
        int soec = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.roster[i].getMajor().getSchoolName().equals("RBS")) {
                RBS[rbsc] = this.roster[i];
                rbsc++;
            } else if (this.roster[i].getMajor().getSchoolName().equals("SAS")) {
                if (this.roster[i].getMajor().getMajorCode().equals("01:198")) {
                    SASC[sascc] = this.roster[i];
                    sascc++;
                } else {
                    SASM[sasmc] = this.roster[i];
                    sasmc++;
                }
            } else if (this.roster[i].getMajor().getSchoolName().equals("SC&I")) {
                SCI[scic] = this.roster[i];
                scic++;
            } else {
                SOE[soec] = this.roster[i];
                soec++;
            }
        }
        combineSM(sort(RBS, rbsc), sort(SASC, sascc), sort(SASM, sasmc), sort(SCI, scic), sort(SOE, soec),
                rbsc, sascc, sasmc, scic, soec);
    }

    /** Prints roster (Student[]) by profile. */
    public void print() {
        sort();
        for (int i = 0; i < size; i++) {
            System.out.println(this.roster[i].getProfile().getFname() + " "
            + this.roster[i].getProfile().getLname() + " " + this.roster[i].getProfile().getDob().toString()
            + " (" + this.roster[i].getMajor().getMajorCode() + " " + this.roster[i].getMajor() + " "
            + this.roster[i].getMajor().getSchoolName() + ") credits completed: " + this.roster[i].getCreditsCompleted()
            + " (" + this.roster[i].getStanding() + ")");
        }
    }

    /** Prints roster (Student[]) by standing, then profile. */
    public void printByStanding() {
        sortStanding();
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i].getProfile().getFname() + " "
            + roster[i].getProfile().getLname() + " " + roster[i].getProfile().getDob().toString()
            + "(" + roster[i].getMajor().getMajorCode() + " " + roster[i].getMajor() + " "
            + roster[i].getMajor().getSchoolName() + ") credits completed: " + roster[i].getCreditsCompleted() + " ("
            + roster[i].getStanding() + ")");
        }
    }

    /** Prints roster (Student[]) by school, major, then profile. */
    public void printBySchoolMajor() {
        sortSchoolMajor();
        for (int i = 0; i < size; i++) {
            System.out.println(roster[i].getProfile().getFname() + " "
            + roster[i].getProfile().getLname() + " " + roster[i].getProfile().getDob().toString()
            + "(" + roster[i].getMajor().getMajorCode() + " " + roster[i].getMajor() + " "
            + roster[i].getMajor().getSchoolName() + ") credits completed: " + roster[i].getCreditsCompleted() + " ("
            + roster[i].getStanding() + ")");
        }
    }
}