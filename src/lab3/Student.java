package lab3;

public class Student implements Comparable<Student> {
    int course;
    String fio;

    public Student(int course, String s) {
        this.course = course;
        this.fio = s;
    }

    @Override
    public int compareTo(Student s) {
        if (course != s.course) {
            return course - s.course;
        }
        return fio.compareTo(s.fio);
    }
    @Override
    public String toString() {
        return  "course: " + course + " fio: " + fio;
    }
}
