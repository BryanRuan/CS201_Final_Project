
public class AudioBook extends Book {

    private double length;

    /**
     * Default constructor for AudioBook.
     */
    public AudioBook() {
        super("", "", "", 0.0);
        this.length = 0.0;
    }

    /**
     * Parameterized constructor to fully initialize an AudioBook.
     */
    public AudioBook(String t, String a, String g, double c, double len) {
        super(t, a, g, c);
        this.length = len;
    }

    // --- Setter ---
    public void setLength(double len) {
        this.length = len;
    }

    // --- Getters ---

    public double getLength() {
        return length;
    }

    public double getAvelength() {
        return length;
    }

    @Override
    public double getCost() {
        return cost;
    }

    public String displayLastThreeAudio() {
        return "Displaying info for the last 3 audiobooks.";
    }

    @Override
    public String toString() {
        return "AudioBook: " + getTitle() + " by " + getAuthor() +
                " | Genre: " + getGenre() + " | Cost: $" + getCost() +
                " | Length: " + length + " hours";
    }
}