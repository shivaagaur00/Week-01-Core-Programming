import java.util.*;

interface Graded {
    void assignGrade(Student student, String courseCode, String grade);
}

class Student {
    private String name;
    private String id;
    private double gpa;
    private int totalCredits;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.gpa = 0.0;
        this.totalCredits = 0;
    }

    public void updateGPA(String grade, int credits) {
        double gradePoint = 0.0;
        switch (grade.toUpperCase()) {
            case "A": gradePoint = 4.0; break;
            case "B": gradePoint = 3.0; break;
            case "C": gradePoint = 2.0; break;
            case "D": gradePoint = 1.0; break;
            case "F": gradePoint = 0.0; break;
            default: System.out.println("Invalid grade."); return;
        }
        double totalQualityPoints = this.gpa * this.totalCredits + gradePoint * credits;
        this.totalCredits += credits;
        this.gpa = totalQualityPoints / this.totalCredits;
    }

    public void showTranscript() {
        System.out.println("Student: " + name + " (" + id + ")");
        System.out.printf("GPA: %.2f\n", gpa);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Undergraduate extends Student {
    public Undergraduate(String name, String id) {
        super(name, id);
    }
}

class Postgraduate extends Student {
    public Postgraduate(String name, String id) {
        super(name, id);
    }
}

class Course {
    String code;
    String title;
    int credits;

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }
}

class Faculty implements Graded {
    String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void assignGrade(Student student, String courseCode, String grade) {
        int credits = 3;
        student.updateGPA(grade, credits);
        System.out.println("Faculty " + name + " assigned grade " + grade + " for course " + courseCode + " to student " + student.getId());
    }
}

class Enrollment {
    Student student;
    Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        System.out.println("Enrolled " + student.getId() + " in course " + course.code);
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Student> students = new HashMap<>();
        Map<String, Course> courses = new HashMap<>();

        System.out.print("Enter number of students to register: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student ID: ");
            String id = sc.nextLine();
            System.out.print("Enter type (UG/PG): ");
            String type = sc.nextLine();

            if(type.equalsIgnoreCase("UG")) {
                students.put(id, new Undergraduate(name, id));
            } else {
                students.put(id, new Postgraduate(name, id));
            }
        }

        System.out.print("\nEnter number of courses to create: ");
        int m = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < m; i++) {
            System.out.print("Enter course code: ");
            String code = sc.nextLine();
            System.out.print("Enter course title: ");
            String title = sc.nextLine();
            System.out.print("Enter course credits: ");
            int credits = sc.nextInt();
            sc.nextLine();

            courses.put(code, new Course(code, title, credits));
        }

        System.out.print("\nEnter faculty name: ");
        String facultyName = sc.nextLine();
        Faculty faculty = new Faculty(facultyName);

        System.out.print("Enter number of enrollments: ");
        int e = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < e; i++) {
            System.out.print("Enter student ID to enroll: ");
            String sid = sc.nextLine();
            System.out.print("Enter course code to enroll in: ");
            String cid = sc.nextLine();

            if(students.containsKey(sid) && courses.containsKey(cid)) {
                new Enrollment(students.get(sid), courses.get(cid));
            } else {
                System.out.println("Invalid student or course.");
            }
        }

        System.out.print("\nEnter number of grades to assign: ");
        int g = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < g; i++) {
            System.out.print("Enter student ID: ");
            String sid = sc.nextLine();
            System.out.print("Enter course code: ");
            String cid = sc.nextLine();
            System.out.print("Enter grade (A-F): ");
            String grade = sc.nextLine();

            if(students.containsKey(sid)) {
                faculty.assignGrade(students.get(sid), cid, grade);
            } else {
                System.out.println("Invalid student ID.");
            }
        }

        System.out.println("\nTranscripts:");
        for(Student s : students.values()) {
            s.showTranscript();
        }

        sc.close();
    }
}
