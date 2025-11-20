public abstract class Book implements BookInterface {
    //field
    protected String title;
    protected String author;
    protected String genre;
    protected double baseCost; // Base price of the book

    // Constructor
    public Book(String t, String a, String g, double c) {
        this.title = t;
        this.author = a;
        this.genre = g;
        this.baseCost = c;
    }

    // Abstract method: MUST return the FINAL calculated cost (base + modifiers)
    public abstract double getCost();

    // New Getter for the raw base cost
    public double getBaseCost() {
        return baseCost;
    }

    // Getter methods (Remain)
    public String getTitle() {
        return title;
    }
    // ... other getters ...

    // BookInterface methods (Placeholders, as requested)
    // ...
}