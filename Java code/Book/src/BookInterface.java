public interface BookInterface {

    /** Returns the last 10 books. */
    void getLast10Books();

    /** Returns the number of books per genre. */
    int numBookPerGenre();

    /** Calculates the total cost of the collection or object. */
    double getTotalCost();
}