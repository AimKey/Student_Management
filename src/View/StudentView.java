package View;

import Common.Library;
import Model.Student;
import java.util.ArrayList;

/**
 *
 * @author phamm
 */
public class StudentView {

    Library lib = new Library();

    public void report(ArrayList<Student> unique, ArrayList<Student> sList) {
        display(sList);
        for (Student student : unique) {
            int count = 0;
            for (Student student1 : sList) {
                if (student.equals(student1)) {
                    count++;
                }
            }
            System.out.printf("|%-20s |%-20s |%d\n", student.getName(),
                    student.getCourseName(), count);
        }
    }

    public void display(ArrayList<Student> sList) {
        System.out.println("-----------------------------");
        for (Student student : sList) {
            System.out.printf("|Name:%-20s |Semester:%-10d |Course Name:%-10s\n",
                    student.getName(), student.getSemester(), student.getCourseName());
        }
        System.out.println("-----------------------------");
        System.out.println("Total: " + sList.size());
    }

    public void printErr(String msg) {
        System.out.println("\u001B[31m" + msg + "\u001B[0m");
    }

}
