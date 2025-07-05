class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentManagement {
    private Student head;

    // Add at beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    // Add at position
    public void addAtPosition(int pos, int rollNumber, String name, int age, char grade) {
        if (pos == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    // Delete by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Search by roll number
    public Student searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Update grade
    public void updateGrade(int rollNumber, char newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    // Display all students
    public void displayAll() {
        Student current = head;
        System.out.println("Roll Number\tName\tAge\tGrade");
        while (current != null) {
            System.out.println(current.rollNumber + "\t\t" + current.name + "\t" + current.age + "\t" + current.grade);
            current = current.next;
        }
    }
}