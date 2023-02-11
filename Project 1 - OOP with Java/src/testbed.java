public class testbed {
    public static void main(String[] args) {
        Date bad1 = new Date("2/29/2003");
        System.out.println("bad1.isValid() = " + bad1.isValid());
        Date bad2 = new Date("4/31/2003");
        System.out.println("bad2.isValid() = " + bad2.isValid());
        Date bad3 = new Date("13/31/2003");
        System.out.println("bad3.isValid() = " + bad3.isValid());
        Date bad4 = new Date("3/32/2003");
        System.out.println("bad4.isValid() = " + bad4.isValid());
        Date bad5 = new Date("-1/31/2003");
        System.out.println("bad5.isValid() = " + bad5.isValid());

        Date good1 = new Date("9/2/2022");
        System.out.println("good1.isValid() = " + good1.isValid());
        Date good2 = new Date("12/20/2004");
        System.out.println("good2.isValid() = " + good2.isValid());

        // equals()
        Date same1 = new Date("4/12/2002");
        Date same2 = new Date("4/12/2002");
        Date diff = new Date("4/13/2002");
        System.out.println("same1 == same2: " + same1.equals(same2));
        System.out.println("same1 == diff: " + same1.equals(diff));

        // compareTo() *tested with different dates, months, and years -> ALL WORKS
        Date comp = new Date("4/12/2002");
        Date compLess = new Date("3/12/2002");
        Date compMore = new Date("5/12/2002");
        System.out.println("should return -1: " + comp.compareTo(compLess));
        System.out.println("should return 1: " + comp.compareTo(compMore));
        System.out.println("should return 0: " + comp.compareTo(same1));

        Profile p1 = new Profile("Marlon", "Vergara", comp);
        Profile p2 = new Profile("Marlon", "Vergara", diff);
        System.out.println(p1.equals(p2));

        Student s = new Student(p1, Major.CS, 54);
        System.out.println(s.toString());

        System.out.println(Major.EE.getMajorCode() + " " + Major.EE.getSchoolName());
    }
}
