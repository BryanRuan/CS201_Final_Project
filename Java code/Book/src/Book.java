public abstract class Book implements BookInterface {
    //field
    protected String title;
    protected String author;
    protected String genre;
    protected double cost;

    // Constructor
    public Book(String t, String a, String g, double c) {
        this.title = t;
        this.author = a;
        this.genre = g;
        this.cost = c;
    }

    // Abstract method
    public abstract double getCost();

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    // BookInterface methods

    @Override
    public double getTotalCost() {
        // For a single book instance, total cost is its calculated cost
        return getCost();
    }

    @Override
    public void getLast10Books() {
        // Placeholder implementation for a single book
        System.out.println("Method intended for a collection class.");
    }

    @Override
    public int numBookPerGenre() {
        // Placeholder implementation for a single book
        return 1;
    }
}