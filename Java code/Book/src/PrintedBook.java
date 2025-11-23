
public class PrintedBook extends Book {

    private int pages;

    /**
     * Default constructor for PrintedBook.
     */
    public PrintedBook() {
        super("", "", "", 0.0);
        this.pages = 0;
    }

    /**
     * Parameterized constructor to fully initialize a PrintedBook.
     */
    public PrintedBook(String t, String a, String g, double c, int p) {
        super(t, a, g, c);
        this.pages = p;
    }

    // --- Setter ---
    public void setPages(int p) {
        this.pages = p;
    }

    // --- Getters ---

    public int getPages() {
        return pages;
    }

    public double getAvePages() {
        return (double)pages;
    }

    @Override
    public double getCost() { // Implementation of abstract method from Book
        return cost;
    }

    public String displayLastThreePrinted() {
        return "Displaying info for the last 3 printed books.";
    }

    @Override
    public String toString() { // Concrete method [cite: 38]
        return "PrintedBook: " + getTitle() + " by " + getAuthor() +
                " | Genre: " + getGenre() + " | Cost: $" + getCost() +
                " | Pages: " + pages;
    }
}