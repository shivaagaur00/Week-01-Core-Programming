class TextState {
    String content;
    TextState next;
    TextState prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int maxStates;
    private int count;

    public TextEditor(int maxStates) {
        this.maxStates = maxStates;
        this.head = null;
        this.tail = null;
        this.current = null;
        this.count = 0;
    }

    // Add new state
    public void addState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = tail = current = newState;
            count = 1;
            return;
        }
        
        // If we're not at the end of the history, remove all states after current
        if (current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }
        
        newState.prev = tail;
        tail.next = newState;
        tail = newState;
        current = newState;
        count++;
        
        // Enforce max states limit
        if (count > maxStates) {
            head = head.next;
            head.prev = null;
            count--;
        }
    }

    // Undo
    public String undo() {
        if (current == null || current.prev == null) {
            return null;
        }
        current = current.prev;
        return current.content;
    }

    // Redo
    public String redo() {
        if (current == null || current.next == null) {
            return null;
        }
        current = current.next;
        return current.content;
    }

    // Get current state
    public String getCurrentState() {
        return current != null ? current.content : "";
    }

    // Display history
    public void displayHistory() {
        TextState state = head;
        System.out.println("Text Editor History:");
        while (state != null) {
            String prefix = (state == current) ? "> " : "  ";
            System.out.println(prefix + state.content);
            state = state.next;
        }
    }
}