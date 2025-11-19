import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Create instances of the concrete classes
        AudioBook duneAudio = new AudioBook("Dune", "Frank Herbert", "Sci-Fi", 5.0, 21.5);
        PrintedBook martianPrint = new PrintedBook("The Martian", "Andy Weir", "Sci-Fi", 15.0, 384);
        PrintedBook lotrPrint = new PrintedBook("Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 20.0, 1178);
        AudioBook hpAudio = new AudioBook("Harry Potter", "J.K. Rowling", "Fantasy", 12.0, 15.0);

        // 2. Use an ArrayList typed to the abstract class Book (Polymorphism)
        List<Book> bookCollection = new ArrayList<>();
        bookCollection.add(duneAudio);
        bookCollection.add(martianPrint);
        bookCollection.add(lotrPrint);
        bookCollection.add(hpAudio);

        System.out.println("--- Books in the Collection ---");
        double totalCost = 0.0;

        // 3. Iterate through the collection and demonstrate polymorphism
        for (Book book : bookCollection) {
            // book.toString() calls the specific toString() method for AudioBook or PrintedBook
            System.out.println(book.toString());

            // book.getCost() calls the specific implementation of getCost() for each object type
            totalCost += book.getCost();
        }
        System.out.println("----------------------------\n");

        // 4. Print results (Total Cost Calculation)
        System.out.printf("Total Cost of all books (Polymorphic call): $%.2f%n", totalCost);

        // Note: Methods like numBookPerGenre() and getLast10Books() from BookInterface
        // would require manual collection logic here since the dedicated Library class is absent.

        // Example of calling a specific method on one object:
        System.out.println(duneAudio.displayLastThreeAudio());
    }
}