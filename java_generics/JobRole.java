import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    String roleName;
    
    JobRole(String roleName) {
        this.roleName = roleName;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    T jobRole;
    
    Resume(T jobRole) {
        this.jobRole = jobRole;
    }
    
    public void processResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println("Processing resume for: " + resume.roleName);
        }
    }
    
    public static void main(String[] args) {
        List<JobRole> resumes = new ArrayList<>();
        resumes.add(new SoftwareEngineer());
        resumes.add(new DataScientist());
        resumes.add(new ProductManager());
        
        Resume<JobRole> resumeProcessor = new Resume<>(null);
        resumeProcessor.processResumes(resumes);
    }
}
