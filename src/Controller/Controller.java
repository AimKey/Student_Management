package Controller;

import Common.Library;
import Model.Student;
import Model.Students;
import View.DisplayMenu;
import View.Menu;
import View.StudentView;
import java.util.ArrayList;
import java.util.Collections;

public class Controller extends Menu {

    Library lib = new Library();
    StudentView view;
    Students students;

    public Controller(StudentView sView) {
        super(new String[]{"Create", "Find/Sort", "Update/Delete", "Report", "Exit"},
                "Student Manager");
        this.view = sView;
        students = new Students();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createStudent();
                break;
            case 2:
                doSearchAndSort();
                break;
            case 3:
                doModify();
                break;
            case 4:
                doReport();
                break;
            case 5:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void createStudent() {
        int choice = 1;
        if (students.size() < 10) {
            while (students.size() < 10 || choice == 1) {
                int id = lib.getInt("Enter student ID", "ID must be a number");
                String name = lib.getString("Enter student name", "Name must contain only characters");
                int semester = lib.getInt("Enter semester", "Semester must be a number");
                String course = lib.getString("Enter course", "Course must contain only characters");
                Student st = new Student(id, semester, name, course);
                students.add(st);
                System.out.println("Total: " + students.size());
                System.out.println("Do you want to continue?\n1.Yes \n2.No");
                choice = lib.getInt("Your choice");
                if (choice >= 2) break;
            }
        } else {
            int id = lib.getInt("Enter student ID", "ID must be a number");
            String name = lib.getString("Enter student name", "Name must contain only characters");
            int semester = lib.getInt("Enter semester", "Semester must be a number");
            String course = lib.getString("Enter course", "Course must contain only characters");
            Student st = new Student(id, semester, name, course);
            students.add(st);
        }
        view.display(students);
    }

    public void doSearchAndSort() {
        Menu s = new Menu(new String[]{"Search", "Sort"}, "Search/Sort") {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        String name = lib.getString("Enter name to search", "Not a name");
                        view.display(students.search(p -> p.getName().contains(name)));
                        break;
                    case 2:
                        Collections.sort(students);
                        view.display(students);
                        break;
                }
            }
        };
        s.run();
    }

    public void doModify() {
        lib.display(students);
        int idToFind = lib.getInt("Enter ID to modify", "ID must be a number");
        ArrayList<Student> targets = students.search(p -> p.getId() == idToFind);
        DisplayMenu m = new DisplayMenu(targets, "Choose one");
        Student target = targets.get(m.getSelected() - 1);
        String ans = lib.getString("Do you want update (U) or delete (D) student")
                .toUpperCase();
        if ("U".equals(ans)) {
            int id = lib.getInt("Enter new id", "Id only contains numbers!");
            String name = lib.getString("Enter new name", "Name only contain characters!");
            int semester = lib.getInt("Enter new semester", "Semester only contains number!");
            String courseName = lib.getString("Enter new course name", "Course Name only contain characters!");
            target.setId(id);
            target.setName(name);
            target.setSemester(semester);
            target.setCourseName(courseName);
        } else if ("D".equals(ans)) {
            students.remove(target);
        } else {
            view.printErr("Wrong input!");
        }
        lib.display(students);
    }

    public void doReport() {
        ArrayList<Student> unique = new ArrayList<>();
        for (Student student : students) {
            if (!unique.contains(student)) {
                unique.add(student);
            }
        }
        view.report(unique, students);
    }

}
