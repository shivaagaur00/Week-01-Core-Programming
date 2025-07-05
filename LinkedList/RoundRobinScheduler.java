class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head;
    private Process tail;
    private int timeQuantum;
    private int totalProcesses;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.head = null;
        this.tail = null;
        this.totalProcesses = 0;
    }

    // Add process at end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        totalProcesses++;
    }

    // Remove process by ID
    public void removeProcess(int processId) {
        if (head == null) return;
        if (head.processId == processId) {
            if (head.next == head) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            totalProcesses--;
            return;
        }
        Process prev = head;
        Process current = head.next;
        while (current != head && current.processId != processId) {
            prev = current;
            current = current.next;
        }
        if (current != head) {
            prev.next = current.next;
            if (current == tail) {
                tail = prev;
            }
            totalProcesses--;
        }
    }

    // Simulate scheduling
    public void simulate() {
        if (head == null) {
            System.out.println("No processes to schedule");
            return;
        }
        int[] waitingTime = new int[totalProcesses + 1];
        int[] turnaroundTime = new int[totalProcesses + 1];
        int[] remainingTime = new int[totalProcesses + 1];
        
        // Initialize remaining time
        Process current = head;
        do {
            remainingTime[current.processId] = current.burstTime;
            current = current.next;
        } while (current != head);
        
        int time = 0;
        boolean done;
        do {
            done = true;
            current = head;
            do {
                if (remainingTime[current.processId] > 0) {
                    done = false;
                    int executionTime = Math.min(timeQuantum, remainingTime[current.processId]);
                    System.out.println("Time " + time + ": Process " + current.processId + " executing for " + executionTime + " units");
                    time += executionTime;
                    remainingTime[current.processId] -= executionTime;
                    if (remainingTime[current.processId] == 0) {
                        turnaroundTime[current.processId] = time;
                        waitingTime[current.processId] = turnaroundTime[current.processId] - current.burstTime;
                        System.out.println("Process " + current.processId + " completed at time " + time);
                    }
                }
                current = current.next;
            } while (current != head);
        } while (!done);
        
        // Calculate averages
        double totalWaiting = 0, totalTurnaround = 0;
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        current = head;
        do {
            System.out.println(current.processId + "\t" + current.burstTime + "\t\t" + 
                             waitingTime[current.processId] + "\t\t" + turnaroundTime[current.processId]);
            totalWaiting += waitingTime[current.processId];
            totalTurnaround += turnaroundTime[current.processId];
            current = current.next;
        } while (current != head);
        
        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWaiting / totalProcesses);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTurnaround / totalProcesses);
    }

    // Display processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the scheduler");
            return;
        }
        Process current = head;
        System.out.println("Process ID\tBurst Time\tPriority");
        do {
            System.out.println(current.processId + "\t\t" + current.burstTime + "\t\t" + current.priority);
            current = current.next;
        } while (current != head);
    }
}