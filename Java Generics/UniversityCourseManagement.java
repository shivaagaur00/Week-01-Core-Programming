import java.util.*;

abstract class CourseType { String name; public CourseType(String name) { this.name = name; } }
class ExamCourse extends CourseType { public ExamCourse(String name) { super(name); } }
class AssignmentCourse extends CourseType { public AssignmentCourse(String name) { super(name); } }
class ResearchCourse extends CourseType { public ResearchCourse(String name) { super(name); } }

class Course<T extends CourseType> {
    private T type;
    public Course(T type) { this.type = type; }
    public void showType() { System.out.println(type.name); }
}

public class UniversityCourseManagement {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) System.out.println(course.name);
    }
    public static void main(String[] args) {
        List<CourseType> courses = Arrays.asList(new ExamCourse("Math"), new AssignmentCourse("CS Lab"));
        displayCourses(courses);
    }
}
