package Discussions.Discussion2.Introduction_to_Java;

import java.util.Arrays;

public class SemesterCS61b {
    public static String universityName = "UC Berkeley";
    public String semester;
    public String[] students;
    public String[] waitlisted;

    public SemesterCS61b(int capacity, String[] signups, String semester) { // constructor
        this.semester = semester;
        String[] arr1 = new String[capacity];
        String[] arr2 = new String[signups.length - capacity];

        for (int i = 0; i < capacity; i++) {
            arr1[i] = signups[i];
        }
        this.students = arr1;

        for (int i = 0; i < signups.length - capacity; i++) {
            arr2[i] = signups[i + capacity];
        }
        this.waitlisted = arr2;
    }

    public void makeStudentsWatchLecture() { // instance method

    }

    public static void changeUniversity(String uni) {
        universityName = uni;
    }

    public void expand(int newCapacity) {
        int newN = newCapacity - students.length;
        String[] newStudentList = new String[newCapacity];
        String[] newWaitlistedList = new String[newN+1];

        for (int i = 0; i < newCapacity; i++) {
            if (i < students.length)
                newStudentList[i] = students[i];

            else
                newStudentList[i] = waitlisted[i - students.length];
        }
        this.students = newStudentList;

        for (int i = 0; i < newN + 1; i++) {
            System.out.println(i);
            newWaitlistedList[i] = waitlisted[i + newN];
        }
        this.waitlisted = newWaitlistedList;

    }


    public static void main(String[] args) {

    }
}
