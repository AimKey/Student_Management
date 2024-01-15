package Model;

import java.util.Objects;

/**
 *
 * @author phamm
 */
public class Student implements Comparable<Student> {

    private int id, semester;
    private String name, courseName;

    public Student(int Id, int semester, String name, String courseName) {
        this.id = Id;
        this.semester = semester;
        this.name = name;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id != -1) {
            this.id = id;
        }
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if (semester != -1) {
            this.semester = semester;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName.length() > 0) {
            this.courseName = courseName;
        }
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.courseName, other.courseName);
    }

    @Override
    public String toString() {
        String r = String.format("|%-5s |Name:%-20s |Semester:%-5d |Course Name:%-10s", id, name, semester, courseName);
        return r;
    }

}
