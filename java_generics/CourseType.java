import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    String courseName;
    
    CourseType(String courseName) {
        this.courseName = courseName;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName) {
        super(courseName);
    }
}

class Course<T extends CourseType> {
    T courseType;
    
    Course(T courseType) {
        this.courseType = courseType;
    }
    
    public void displayCourse(List<? extends CourseType> list) {
        for (CourseType course : list) {
            System.out.println(course.courseName);
        }
    }
    
    public static void main(String[] args) {
        List<CourseType> courseList = new ArrayList<>();
        courseList.add(new ExamCourse("Math Exam"));
        courseList.add(new AssignmentCourse("History Assignment"));
        courseList.add(new ResearchCourse("Physics Research"));
        
        Course<CourseType> universityCourse = new Course<>(null);
        universityCourse.displayCourse(courseList);
    }
}
