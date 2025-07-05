class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagement {
    private Movie head;
    private Movie tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
            return;
        }
        newMovie.next = head;
        head.prev = newMovie;
        head = newMovie;
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
            return;
        }
        tail.next = newMovie;
        newMovie.prev = tail;
        tail = newMovie;
    }

    // Add at position
    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newMovie.next = current.next;
        newMovie.prev = current;
        if (current.next != null) {
            current.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        current.next = newMovie;
    }

    // Remove by title
    public void removeByTitle(String title) {
        if (head == null) return;
        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }
        Movie current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }
        if (current == null) return;
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }

    // Search by director
    public Movie searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search by rating
    public Movie searchByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Update rating
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }

    // Display forward
    public void displayForward() {
        Movie current = head;
        System.out.println("Title\tDirector\tYear\tRating");
        while (current != null) {
            System.out.println(current.title + "\t" + current.director + "\t" + current.year + "\t" + current.rating);
            current = current.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Movie current = tail;
        System.out.println("Title\tDirector\tYear\tRating");
        while (current != null) {
            System.out.println(current.title + "\t" + current.director + "\t" + current.year + "\t" + current.rating);
            current = current.prev;
        }
    }
}