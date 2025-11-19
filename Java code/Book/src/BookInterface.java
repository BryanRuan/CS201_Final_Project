public interface BookInterface {

    /** Returns the last 10 books. (UML: void) */
    void getLast10Books();

    /** Returns the number of books per genre. (UML: int) */
    int numBookPerGenre();

    /** Calculates the total cost of the collection or object. (UML: double) */
    double getTotalCost();
}