public abstract class Book implements BookInterface {

    private String title;
    private String author;
    private String genre;
    protected double cost;


    /**
     * Constructor for the Book class.
     */
    public Book(String t, String a, String g, double c) {
        this.title = t;
        this.author = a;
        this.genre = g;
        this.cost = c;
    }

    // --- Getter Methods ---

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }

    /**
     * Abstract method for getting the cost.
     */
    public abstract double getCost();

    // --- Concrete Methods ---

    /**
     * Returns the total cost.
     */
    @Override
    public double getTotalCost() {
        return getCost();
    }

    // --- Interface Method Implementations ---

    @Override
    public int numBookPerGenre() {
        return 1;
    }
}