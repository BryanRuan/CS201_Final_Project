public class PrintedBook extends Book {

    // Field
    private int pages; // pages: int

    // Constructor
    public PrintedBook(String title, String author, String genre, double baseCost, int pages) {
        super(title, author, genre, baseCost);
        this.pages = pages;
    }

    // Implementation of abstract getCost()
    @Override
    public double getCost() {
        // Uses baseCost
        return this.baseCost + (0.02 * this.pages);
    }

    // Getter + Setter
    public void setPages(int p) {
        this.pages = p;
    }

    public int getPages() {
        return pages;
    }

    // Specific Methods
    public double getAvePages() {
        // Placeholder calculation
        return (double) pages / 100.0;
    }

    public String displayLastThreePrinted() {
        return "Displaying last three printed books related to " + getTitle();
    }

    // Overrides Object's toString()
    @Override
    public String toString() {
        return "PrintedBook: " + title + " by " + author + ", Pages: " + pages + ", Cost: $" + getCost();
    }
}