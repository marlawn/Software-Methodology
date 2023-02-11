public class Roster {
    private Student[] roster;
    private int size;
    public Roster() {
        roster = new Student[4];
        size = 0;
    }
    private int find(Student student) {
        // for faster implement binary search
        for (int i = 0; i < size; i++) {
            if (roster[i] == student) return i;
        }
        return Constants.NOT_FOUND;
    }
    private void grow() {
        int temp = size + 4;
        Student[] newRoster = new Student[temp];
        for (int i = 0; i < size; i++) {
            newRoster[i] = roster[i];
        }
        roster = newRoster;
    }
    public boolean add(Student student) {
        if (size == roster.length) grow(); // will this work?? pretty sure
        roster[size + 1] = student;
        size++;
        return true; // is there a return false? like an exception?
    }
    public boolean remove(Student student) {
        int index =  find(student);
        if (index < 0) return false;
        for (int i = index + 1; i < size; i++) {
            roster[i-1] = roster[i]; // moves every index in front of one behind by 1
        }
        return true;
    }
    private void sort() {

    }
    public void print() {
        sort();
        for (int i = 0; i < size; i++) {
            // print shit
        }
    }
}