
public interface BookInterface {

    /**
     * Abstract method to get the number of books per genre.
     */
    int numBookPerGenre();

    /**
     * Abstract method to get the total cost.
     */
    double getTotalCost();

    /**
     * Default method to display the last 10 added books.
     */
    default void getLast10Books() {
        System.out.println("Displaying the last 10 added books."); // Default method implementation [cite: 14]
        // Actual logic for retrieving and displaying the last 10 books would go here.
    }
}