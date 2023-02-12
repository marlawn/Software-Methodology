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
    }
}
