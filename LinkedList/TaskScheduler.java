class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;
    private Task tail;
    private Task current;

    // Add at beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
            current = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add at end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
            current = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add at position
    public void addAtPosition(int pos, int taskId, String taskName, int priority, String dueDate) {
        if (pos == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task current = head;
        for (int i = 1; i < pos - 1 && current.next != head; i++) {
            current = current.next;
        }
        newTask.next = current.next;
        current.next = newTask;
        if (newTask.next == head) {
            tail = newTask;
        }
    }

    // Remove by task ID
    public void removeByTaskId(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = tail = current = null;
            } else {
                head = head.next;
                tail.next = head;
                if (current.taskId == taskId) {
                    current = head;
                }
            }
            return;
        }
        Task prev = head;
        Task current = head.next;
        while (current != head && current.taskId != taskId) {
            prev = current;
            current = current.next;
        }
        if (current != head) {
            prev.next = current.next;
            if (current == tail) {
                tail = prev;
            }
            if (this.current.taskId == taskId) {
                this.current = prev.next;
            }
        }
    }

    // View current task and move to next
    public Task viewCurrentAndMoveNext() {
        if (current == null) return null;
        Task result = current;
        current = current.next;
        return result;
    }

    // Display all tasks
    public void displayAll() {
        if (head == null) return;
        Task current = head;
        System.out.println("Task ID\tTask Name\tPriority\tDue Date");
        do {
            System.out.println(current.taskId + "\t" + current.taskName + "\t" + current.priority + "\t" + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search by priority
    public Task searchByPriority(int priority) {
        if (head == null) return null;
        Task current = head;
        do {
            if (current.priority == priority) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }
}