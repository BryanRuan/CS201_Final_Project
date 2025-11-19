public class AudioBook extends Book {

    // Field
    private double length; // length: double

    // Constructor
    public AudioBook(String title, String author, String genre, double baseCost, double length) {
        super(title, author, genre, baseCost);
        this.length = length;
    }

    // Implementation of abstract getCost()
    @Override
    public double getCost() {
        // Example logic: Base cost + 0.50 per hour of length
        return this.cost + (0.50 * this.length);
    }

    // Getter + Setter
    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    // Specific Methods
    public double getAveLength() {
        // Placeholder calculation
        return length / 2.0;
    }

    public String displayLastThreeAudio() {
        return "Displaying last three audio books related to " + getTitle();
    }

    // Overrides Object's toString()
    @Override
    public String toString() {
        return "AudioBook: " + title + " by " + author + ", Length: " + length + "h, Cost: $" + getCost();
    }
}