import java.util.*;

abstract class JobRole { String title; public JobRole(String title) { this.title = title; } public String toString() { return title; } }
class SoftwareEngineer extends JobRole { public SoftwareEngineer() { super("Software Engineer"); } }
class DataScientist extends JobRole { public DataScientist() { super("Data Scientist"); } }
class ProductManager extends JobRole { public ProductManager() { super("Product Manager"); } }

class Resume<T extends JobRole> {
    T role;
    public Resume(T role) { this.role = role; }
    public void process() { System.out.println("Processing resume for: " + role); }
}

public class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) System.out.println("Screening: " + role);
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> se = new Resume<>(new SoftwareEngineer());
        Resume<DataScientist> ds = new Resume<>(new DataScientist());
        se.process();
        ds.process();

        List<JobRole> roles = Arrays.asList(new SoftwareEngineer(), new ProductManager());
        processResumes(roles);
    }
}
